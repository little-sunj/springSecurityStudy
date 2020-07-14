package io.security.basicsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("loginPage")
	public String loginPage() {
		return "loginPage";	//실제 페이지를 구현하게 된다.
	}

}
