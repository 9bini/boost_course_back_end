package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// 필수 적으로 컨트롤러 작성
public class PlusController {
	@GetMapping(path = "/plusform")
	// 웹페이지만 반환하기 때문에 페이지명만 반환한다.
	public String plusform() {
		return "plusForm";
	}

	@PostMapping(path = "/plus")
	public String plus(
			// name에는 http parameter의 name과 멥핑
			// required는 필수인지 아닌지 판단 
			@RequestParam(name = "value1", required = true) int value1
			, @RequestParam(name = "value2", required = true) int value2
			, ModelMap modelMap) {
		int result = value1 + value2;

		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);

		return "plusResult";
	}

}
