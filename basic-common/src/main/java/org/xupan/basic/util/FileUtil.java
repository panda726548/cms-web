package org.xupan.basic.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
/**
 * 文件操作工具类
 * @author Administrator
 *
 */
public class FileUtil {
	
    public static void main(String[] args) throws IOException {  
    	/*URL url = new URL("http://www.163.com/");  
    	HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
    	InputStream inputStream = conn.getInputStream();  
    	byte[] getData = readInputStream(inputStream);     
    	String data = new String(getData, "gb2312");  
    	System.out.println(data);  */
    
       
       
    	System.out.println(getFileContent("F:\\apache-tomcat-6.0.44-windows-x86\\apache-tomcat-6.0.44\\webapps\\cms-web\\WEB-INF/jsp/index/channel.jsp"));
    	//outFile("src/index3.html", getFileContent("src/index.html"));
    	// System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset()); 
        
    }  
    
    
    
    

    /**
     * 根据网络url获取整个网页的内容
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        while((len = inputStream.read(buffer)) != -1) {  
            bos.write(buffer, 0, len);  
        }  
        bos.close();  
        return bos.toByteArray();  
    }  
      
    /**
     * 根据路径获得文件的内容
     * @param path
     * @return
     */
   public static String getFileContent(String path){
	   StringBuffer sb=new StringBuffer();
	   BufferedReader br=null;
	   String data=null;
	   try {
		  br=new BufferedReader(new FileReader(new File(path)));
		  String str = br.readLine();
		  while(str!=null){
			  sb.append(str + "\r\n");
			  str = br.readLine();
		  }
		  data = new String(sb.toString().getBytes(), "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	return data;
   }
   
   /**
    * 输出文件到指定的路径
    * @param path
    * @param data
    */
   public static void outFile(String path,String data){
	   BufferedWriter bw=null;
	   try {
		bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
		bw.write(data);	
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		try {
			if(bw!=null){
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   }
   
   
   
}
