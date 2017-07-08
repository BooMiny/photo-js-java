package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ImgPage{
	public String title;
	public ArrayList<Img> imgl= new ArrayList<Img>();
	public static ArrayList<ImgPage> pgl= new ArrayList<ImgPage>();
	public void Imgep(){
		pgl.clear();
		String path = "D:\\myEclipse\\Photo\\WebRoot\\blog\\images\\img";
		File f = new File(path);
		File [] fileArray = f.listFiles();
		for(File fp:fileArray){
		
			if(fp.isDirectory()){
				//
				int i = 1;
				Object [] mesArray = null;
				//
				ImgPage page = new ImgPage();
				Img ti = null;
				for(File ft:fp.listFiles()){
					//¿ªÊ¼
					if(ft.getName().indexOf("txt")>-1){
						mesArray = getMessage(ft);
						continue;
					}
					//½áÊø
					ti=new Img();
					ti.setPicPath("images/img/"+fp.getName()+"/"+ft.getName());
					page.imgl.add(ti);
				}
				page.title = mesArray[0].toString();
				for(Img e :page.imgl){
					
					e.setContent(mesArray[i++].toString());
				}
				pgl.add(page);
			}
		}
	}
	@SuppressWarnings("null")
	public Object[] getMessage(File f){
		ArrayList<String>sta = new ArrayList<String>();
        String [] ST = null;
		try{
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String str = reader.readLine();
			while(str !=null){
				sta.add(str);

				str = reader.readLine();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		 
		return sta.toArray();
	}
}
