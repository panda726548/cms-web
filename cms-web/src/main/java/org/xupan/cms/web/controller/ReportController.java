package org.xupan.cms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.security.auth.x500.X500Principal;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xupan.basic.util.JsonUtil;
import org.xupan.cms.auth.AuthClass;
import org.xupan.cms.model.ReportDto;
import org.xupan.cms.service.ITopicService;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.DataView;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.feature.Mark;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.feature.SaveAsImage;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Series;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.google.gson.Gson;


@Controller
@AuthClass
public class ReportController {
	
	private ITopicService topicService;
	public ITopicService getTopicService() {
		return topicService;
	}
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}
	
	
	
	@RequestMapping(value="/lastweekreport",method=RequestMethod.GET)
	public String lastweekreport(Model model) {
		
		return "report/lastweekreport";
	}
	
	@RequestMapping(value="/getlastweekdata",method=RequestMethod.POST)
	public void getlastweekdata(Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			Object[] objs=topicService.getLastWeekData();
			//横轴数据
			String[] names=(String[]) objs[0];
			//纵轴数据
			Long[] counts=(Long[])objs[1];
			
			//创建Option对象
			Option option=new Option();
			//图表标题
			Title title=new Title();
			title.setText("最近一周发布文章统计");
			option.setTitle(title);
			//提示框
			Tooltip tooltip=new Tooltip();
			tooltip.setTrigger(Trigger.axis);
			option.setTooltip(tooltip);
			//legend  图例
			Legend legend=new Legend();
			List data = new ArrayList(Arrays.asList(new Object[]{"最近一周发布文章统计"}));
			legend.data(data);
			option.legend(legend);
			//工具箱 toolbox
			Toolbox toolbox=new Toolbox();
			toolbox.setShow(true);
			toolbox.feature(new Mark(),new DataView(),new MagicType(Magic.bar,Magic.line),new Restore(),new SaveAsImage());
			option.setToolbox(toolbox);
			//calculable
			option.setCalculable(true);
			//添加xAxis
			Axis<CategoryAxis> axis=new CategoryAxis();
			axis.data(names);
			option.xAxis(axis);
			//添加yAxis
			ValueAxis valueAxis = new ValueAxis();
			valueAxis.type(AxisType.value);
			option.yAxis(valueAxis);
			//添加series
			//柱形图
			Bar bar=new Bar();
			bar.data(counts);
			option.series(bar);
			
			Gson gson=new Gson();
			String json3=gson.toJson(option);
			System.out.println("option3数据：----------------->>"+json3);
			out.write(json3);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping(value="/channelreport",method=RequestMethod.GET)
	public String channelreport(Model model) {
		return "report/channelreport";
	}
	@RequestMapping(value="/getchannelreportkdata",method=RequestMethod.POST)
	public void getchannelreportdata(Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			Object[] objs=topicService.getChannelReportdata();
			//横轴数据
			String[] names=(String[]) objs[0];
			//纵轴数据
			Long[] counts=(Long[])objs[1];
			
			//创建Option对象
			Option option=new Option();
			//图表标题
			Title title=new Title();
			title.setText("各个栏目文章统计分析");
			option.setTitle(title);
			//提示框
			Tooltip tooltip=new Tooltip();
			tooltip.setTrigger(Trigger.axis);
			option.setTooltip(tooltip);
			//legend  图例
			Legend legend=new Legend();
			List data = new ArrayList(Arrays.asList(new Object[]{"栏目文章统计"}));
			legend.data(data);
			option.legend(legend);
			//工具箱 toolbox
			Toolbox toolbox=new Toolbox();
			toolbox.setShow(true);
			toolbox.feature(new Mark(),new DataView(),new MagicType(Magic.bar,Magic.line),new Restore(),new SaveAsImage());
			option.setToolbox(toolbox);
			//calculable
			option.setCalculable(true);
			//添加xAxis
			Axis<CategoryAxis> axis=new CategoryAxis();
			axis.data(names);
			option.xAxis(axis);
			//添加yAxis
			ValueAxis valueAxis = new ValueAxis();
			valueAxis.type(AxisType.value);
			option.yAxis(valueAxis);
			//添加series
			//柱形图
			Bar bar=new Bar();
			bar.data(counts);
			option.series(bar);
			
			Gson gson=new Gson();
			String json3=gson.toJson(option);
			System.out.println("option3数据：----------------->>"+json3);
			out.write(json3);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
