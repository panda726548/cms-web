package org.xupan.basic.common;


import org.junit.Test;
import org.xupan.basic.model.BackupFile;
import org.xupan.basic.util.BackupFileUtil;

public class TestBackup {
	
	@Test
	public void testList() {
		BackupFileUtil bfu = BackupFileUtil.getInstance("E:\\网络知识");
		for(BackupFile bf:bfu.listBackups()) {
			System.out.println(bf);
		}
	}
	
	@Test
	public void testBackup() {
		BackupFileUtil.getInstance("E:\\网络知识\\SQL").backup("测试备份");
	}
	
	@Test
	public void testDelete() {
		BackupFileUtil.getInstance("E:\\论文和项目\\附中").delete("1377609125956_测试备份.tar.gz");
	}
	
	@Test
	public void testResume() {
		BackupFileUtil.getInstance("E:\\论文和项目\\附中").resume("1377610223607_测试备份.tar.gz");
	}
//	
}
