package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class firstController {

	@RequestMapping(value="/hello")
	public String helloSpring(Model model) {
		model.addAttribute("name", "test");
		return "hello";
	}
}
