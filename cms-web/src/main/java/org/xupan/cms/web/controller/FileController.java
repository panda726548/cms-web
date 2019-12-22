package org.xupan.cms.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xupan.basic.model.SystemContext;
import org.xupan.basic.util.EnumUtils;
import org.xupan.basic.util.FileUtil;
import org.xupan.cms.auth.AuthClass;
import org.xupan.cms.auth.AuthMethod;
import org.xupan.cms.dto.FileDto;
import org.xupan.cms.dto.TreeDto;
import org.xupan.cms.model.Channel;
import org.xupan.cms.model.ChannelType;
import org.xupan.cms.model.FileTree;
import org.xupan.cms.model.Files;
import org.xupan.cms.service.IFileService;
import org.xupan.cms.service.IIndexService;

@RequestMapping("/admin/file")
@Controller
@AuthClass
public class FileController {
	private IFileService fileService;
	private IIndexService indexService;

	public IFileService getFileService() {
		return fileService;
	}
	@Inject
	public void setFileService(IFileService fileService) {
		this.fileService = fileService;
	}
	public IIndexService getIndexService() {
		return indexService;
	}
	@Inject
	public void setIndexService(IIndexService indexService) {
		this.indexService = indexService;
	}
	@RequestMapping("/files")
	public String list(Model model) {
		//model.addAttribute("treeDatas", JsonUtil.getInstance().obj2json(fileService.generateTree()));
		return "files/list";
	}
	
	@RequestMapping("/files/{pid}")
	public String listChild(@PathVariable Integer pid,@Param Integer refresh,Model model) {
		Files fc = null;
		if(refresh==null) {
			model.addAttribute("refresh",0);
		} else {
			model.addAttribute("refresh",1);
		}
		if(pid==null||pid<=0) {
			fc = new Files();
			fc.setName(Files.ROOT_NAME);
			fc.setId(Files.ROOT_ID);
			fc.setFileUrl(null);
		} else
			fc = fileService.load(pid);
		model.addAttribute("pc", fc);
		model.addAttribute("files",fileService.listByParent(pid));
		return "files/list_child";
	}
	
	@RequestMapping("/treeAll")
	public @ResponseBody List<FileTree> tree() {
		return fileService.generateTree();
	}
	
	@RequestMapping(value="/treeAs",method=RequestMethod.POST)
	public @ResponseBody List<TreeDto> tree(@Param Integer pid) {
		List<TreeDto> tds = new ArrayList<TreeDto>();
		if(pid==null||pid<=0) {
			tds.add(new TreeDto(0,"网站系统文件",null,1));
			return tds;
		}
		List<FileTree> fts = fileService.generateTreeByParent(pid);
		for(FileTree ft:fts) {
			tds.add(new TreeDto(ft.getId(),ft.getName(),ft.getFileUrl(),1));
		}
		return tds;
	}
	
	private void initAdd(Model model,Integer pid) {
		if(pid==null) pid = 0;
		Files fc = null;
		if(pid==0) {
			fc = new Files();
			fc.setId(Files.ROOT_ID);
			fc.setName(Files.ROOT_NAME);
			fc.setFileUrl(null);
		} else {
			fc = fileService.load(pid);
		}
		model.addAttribute("pc", fc);
		model.addAttribute("types", EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
	}
	@RequestMapping(value="/eidtfile/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id ,Model model) throws UnsupportedEncodingException {
		System.out.println("目录id------->>>>>:"+id);
		Files fc =fileService.load(id);
		//获得文件的URL 读取文件 将内容传递到页面展示
		String fileUrl=fc.getFile().getFileUrl()+fc.getFileUrl();
		System.out.println("文件路径：=====》"+SystemContext.getRealPath()+fileUrl);
		//获得指定文件的内容
		String fileContent=FileUtil.getFileContent(SystemContext.getRealPath()+fileUrl);
		//System.out.println(fileContent);
		FileDto fileDto=new FileDto(fc.getId(), fc.getName(), fileContent);
		model.addAttribute("file", fc);
		model.addAttribute("fileDto", fileDto);
		return "files/update";
	}
	
	@RequestMapping(value="/eidtfile/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id , FileDto fileDto,Model model) {
		Files fc =fileService.load(id);
		//获得父节点
		int pid=fc.getFile().getId();
		//获得文件路径
		String fileUrl=fc.getFile().getFileUrl()+fc.getFileUrl();
		String savePath=SystemContext.getRealPath()+fileUrl;
		//获得文件的后缀名
		String postfix=fc.getPostfix();
		//将修改后的文件直接写入对应的文件夹中
		FileUtil.outFile(savePath, fileDto.getContent());
		//如果是模板文件要用模板文件生成jsp文件  模板文件后缀是.ftl
		if(postfix.equals(".ftl")){
			//用模板文件生成jsp文件
			if(fc.getName().equals("top1.ftl")){
				indexService.generateTop();
			}else if(fc.getName().equals("body4.ftl")){
				indexService.generateBody();
			}else if(fc.getName().equals("bottom1.ftl")){
				indexService.generateBottom();
			}
		}
		return "redirect:/admin/file/files/"+pid+"?refresh=1";
	}

}
