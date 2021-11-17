package ocrtessdata;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages1 {

	public static void main(String[] args) throws Throwable
	{

     ITesseract image=new Tesseract();
     image.setDatapath("C:\\Program Files\\Java\\OCR\\tessdata"); 
     image.setLanguage("eng");
     
       
     try 
     {
    String str=image.doOCR(new File("C:\\selenium webdriver\\Jillian michaels.jpeg"));
   
    String[]s=str.split(":"); 
    String i=s[1].replaceAll("[^a-zA-Z]","");
    System.out.println("Data from image is "+ str);
     }
     catch(TesseractException e)
     {
    	 e.printStackTrace();
     }
	}

}
