package com.qding.common.storage.util;

import java.io.IOException;
import java.util.logging.Logger;

import com.qding.common.stroage.util.ImgStorageUtil;
import com.qding.common.stroage.util.ImgStrorageUtilYPImpl;

public class ImgStorageUtilTest {

	public static void main(String[] args) {

		ImgStorageUtil imgStrorageUtil = new ImgStrorageUtilYPImpl();
	

		String dir = "testcrop";
		String file = "E:\\test2.jpeg";
		try {
			String url = imgStrorageUtil.imgStorage(dir,null,file);
			//String url2=imgStrorageUtil.ImgCrop(dir, file, "100,100,100,100");
			
			System.out.print(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
