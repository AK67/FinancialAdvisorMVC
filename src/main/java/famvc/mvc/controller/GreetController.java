package famvc.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@RequestMapping("/")
	 public String greet(){
		return " 1 1 2 0 3 2 0 3";
		 
	 }
	
	@RequestMapping("/a")
	 public String greeta(){
		System.out.println("asd");
		return " 1 1 2 0 3 2 0 3";
		 
	 }
}
