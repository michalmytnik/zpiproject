package pl.edu.pk.plagiarism.web;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

}
