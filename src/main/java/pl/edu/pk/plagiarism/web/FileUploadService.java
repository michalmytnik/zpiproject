package pl.edu.pk.plagiarism.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import pl.edu.pk.plagiarism.service.FileService;
import pl.edu.pk.plagiarism.service.UserService;



@Controller
@RequestMapping("/file")
public class FileUploadService { 
	
	@Inject
	private FileService fileService;
	
	
	private final String UPLOADED_FILE_PATH = "d:\\baza\\";
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                writeFile(bytes,UPLOADED_FILE_PATH + name);
                fileService.addFile(name, UPLOADED_FILE_PATH + "\\" + name);
                return "Dodawanie pliku " + name + " zakończyło się sukcesem !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST , produces = "application/json; charset=utf-8")
	   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {                 
	 
	     //0. notice, we have used MultipartHttpServletRequest
	 
	     //1. get the files from the request object
	     Iterator<String> itr =  request.getFileNames();
	 
	     MultipartFile mpf = request.getFile(itr.next());
	     System.out.println(mpf.getOriginalFilename() +" uploaded!");
	 
	     try {
             byte[] bytes = mpf.getBytes();
             BufferedOutputStream stream =
                     new BufferedOutputStream(new FileOutputStream(new File(mpf.getOriginalFilename() + "-uploaded")));
             writeFile(bytes,UPLOADED_FILE_PATH + mpf.getOriginalFilename());
             fileService.addFile(mpf.getOriginalFilename() , UPLOADED_FILE_PATH + "\\" + mpf.getOriginalFilename() );
             return "Dodawanie pliku " + mpf.getOriginalFilename()  + " zakończyło się sukcesem !";
  
         } catch (Exception e) {
             return "You failed to upload " + mpf.getOriginalFilename() + " => " + e.getMessage();
         }

	 
	  }

	
	private void writeFile(byte[] content, String filename) throws IOException {
		 
		File file = new File(filename);
 
		if (!file.exists()) {
			file.createNewFile();
		}
 
		FileOutputStream fop = new FileOutputStream(file);
 
		fop.write(content);
		fop.flush();
		fop.close();
 
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
 
    }