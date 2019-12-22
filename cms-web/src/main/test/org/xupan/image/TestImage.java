package org.xupan.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;

import org.junit.Test;

public class TestImage {

	@Test
	public void test01() {
		try {
			Thumbnails.of(new File("d:/xm.jpg"))
			.size(330, 300)
			.scalingMode(ScalingMode.BILINEAR)
			.toFile(new File("d:/xm1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02() {
		try {
			Thumbnails.of(new File("d:/xm.jpg"))
			.scale(0.3f)
			.toFile(new File("d:/xm1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test03() {
		try {
			BufferedImage bi = Thumbnails.of(new File("d:/xm.jpg"))
			.scale(0.3f)
			.asBufferedImage();
			ImageIO.write(bi, "jpg",new FileOutputStream("d:/xm3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test04() {
		try {
			BufferedImage bi = Thumbnails.of(new File("d:/xm.jpg"))
					.scale(0.2f)
			.asBufferedImage();
			Thumbnails.of(bi)
				.sourceRegion(Positions.CENTER, 300, 300)
				.scale(1.0f)
				.toFile(new File("d:/xm4.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test05() {
		try {
//			BufferedImage bi = Thumbnails.of(new FileInputStream("e:/br/02.jpg")).scale(1.0f).asBufferedImage();
			BufferedImage bi = ImageIO.read(new FileInputStream("d:/xm.jpg"));
			System.out.println(bi.getWidth()+","+bi.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test06() {
		try {
			int width = 900;
			int thumb = 100;
			BufferedImage bi = ImageIO.read(new File("d:/xm.jpg"));
			Builder<BufferedImage> bf = Thumbnails.of(bi);
			bf.scale((double)width/(double)bi.getWidth())
			.toFile(new File("d:/xm6.jpg"));
			BufferedImage bi2 = Thumbnails.of(bi).scale((thumb*1.2)/bi.getWidth()).asBufferedImage();
			Thumbnails.of(bi2).scale(1.0f).sourceRegion(Positions.CENTER,100, 80).toFile(new File("e:/br/04_2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test07(){
		try {
			Thumbnails.of("d:/xm.jpg")   
			.size(1280, 1024)  
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("d:/qm.jpg")), 0.5f)   
			.outputQuality(0.8f)   
			.toFile("d:/xm7.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
