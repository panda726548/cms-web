package org.xupan.backup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;


public class TestCmd {

	@Test
	public void testSimpleCmd() {
		try {
			String cmd = "cmd /c dir c:\\";
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(),"GBK"));
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMySql() {
		BufferedReader br =null;
		BufferedWriter bw=null;
		try {
			String cmd = "cmd /c mysqldump -uroot -proot xp_cms";
			 Process process = Runtime.getRuntime().exec(cmd);  
			br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
			bw = new BufferedWriter(new FileWriter("d:/xp_cms.sql"));
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null){
					br.close();
				}
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Test
	public void testResume() {
		BufferedReader br =null;
		BufferedWriter bw=null;
		try {
			String cmd = "cmd /c mysql -uroot -proot xp_cms";
			Process proc = Runtime.getRuntime().exec(cmd);
			 bw = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
			 br = new BufferedReader(new FileReader("d:/xp_cms.sql"));
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw!=null){
					bw.close();
				}
				if(br!=null){
					br.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
