package pl.edu.pk.plagiarism.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.pk.plagiarism.service.FileService;
import pl.edu.pk.plagiarism.service.UserService;
import pl.edu.pk.plagiarism.utils.ComparisonStorage;
import pl.edu.pk.plagiarism.vo.Status;
import pl.edu.pk.plagiarism.vo.UserVo;

@Controller
@RequestMapping("/check")
public class MainChecker implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FileService fileService;
	
	@RequestMapping(value = "/isPlagarism", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<ComparisonStorage> checkIfPlagiarism(@RequestParam("fileName") String fileName) {
		List<ComparisonStorage> cs;
		try {
			cs = fileService.compareFileToOthers(fileName);
			System.out.println("workings...");
			return cs;
		} catch (Exception e) {
			return null;

		}
	}
	
	
	  
    /**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;
             
    /**
     * Path of the file to be downloaded, relative to application's directory
     */
    private String filePath = "d:\\";
    
	 @RequestMapping(value = "/download",method = RequestMethod.GET)
	    public void doDownload(HttpServletRequest request,
	            HttpServletResponse response,@RequestParam("fileName") String fileName) throws IOException {
	 
	        // get absolute path of the application
	        ServletContext context = request.getServletContext();
	        String appPath = context.getRealPath("");
	 
	        // construct the complete absolute path of the file
	        String fullPath =  filePath + fileName;      
	        File downloadFile = new File(fullPath);
	        FileInputStream inputStream = new FileInputStream(downloadFile);
	         
	        // get MIME type of the file
	        String mimeType = context.getMimeType(fullPath);
	        if (mimeType == null) {
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	 
	        // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	 
	        // get output stream of the response
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
	 
	    }
	
	
	

}
