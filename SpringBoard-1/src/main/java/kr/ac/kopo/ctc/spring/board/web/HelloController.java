package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardItemServiceImpl;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public String helloSpringBoot(Model model) {
		model.addAttribute("name","최수혁");
		return "hello";
	}
	
	@RequestMapping(value = "/newfile")
	public String goNewFile(Model model) {

		return "newfile";
	}
	
}
