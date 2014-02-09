package com.rekoe.test;

import java.io.File;
import java.util.List;

import org.nutz.lang.Files;
import org.nutz.resource.NutResource;
import org.nutz.resource.Scans;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;

/**
 * @author 科技㊣²º¹³ 2014年2月9日 下午2:30:51 http://www.rekoe.com QQ:5382211
 */
public class Test {
	private static final Integer IMAGE_HEIGHT = 26;// 验证码图片高度
	private static final Integer IMAGE_WIDTH = 70;// 验证码图片宽度
	private static final String IMAGE_PATH = "com/rekoe/cms/captcha";
	public static void main(String[] args) {
		List<NutResource> list = Scans.me().scan("com/rekoe/cms/captcha", ".+\\.jpg");
		System.out.println(list.size());
		NutResource resource = list.get(0);
		System.out.println(resource.getName());
		File file = Files.findFile(IMAGE_PATH +resource.getName());
		System.out.println(file.getParent());
		BackgroundGenerator backgroundGenerator = new FileReaderRandomBackgroundGenerator(IMAGE_WIDTH, IMAGE_HEIGHT, file.getParent());
	}

}
