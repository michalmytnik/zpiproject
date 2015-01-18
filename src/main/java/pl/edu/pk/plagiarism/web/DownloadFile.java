package pl.edu.pk.plagiarism.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/download")
public class DownloadFile {
	
	
    private static final int BUFFER_SIZE = 4096;
    private String filePath = "d:\\baza\\";
    
	 @RequestMapping(value = "/file",method = RequestMethod.GET)
	    public void doDownload(HttpServletRequest request,
	            HttpServletResponse response,@RequestParam("fileName") String fileName) throws IOException {
	 
	    
	        ServletContext context = request.getServletContext();
	        String appPath = context.getRealPath("");
	 
	
	        String fullPath =  filePath + fileName;      
	        File downloadFile = new File(fullPath);
	        FileInputStream inputStream = new FileInputStream(downloadFile);
	         
	       
	        String mimeType = context.getMimeType(fullPath);
	        if (mimeType == null) {
	          
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	 
	 
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
	 
	    }
	

}
