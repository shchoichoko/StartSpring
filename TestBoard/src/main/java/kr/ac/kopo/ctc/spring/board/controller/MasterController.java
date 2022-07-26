package kr.ac.kopo.ctc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.ChildTable;
import kr.ac.kopo.ctc.spring.board.domain.ParentTable;
import kr.ac.kopo.ctc.spring.board.repository.ChildTableRepository;
import kr.ac.kopo.ctc.spring.board.repository.ParentTableRepository;
import kr.ac.kopo.ctc.spring.board.service.ChildTableService;
import kr.ac.kopo.ctc.spring.board.service.ParentTableService;


@Controller
@RequestMapping(value = "/home")
public class MasterController {
	
	@Autowired
	ParentTableRepository parentTableRepository;
	@Autowired
	ChildTableRepository childTableRepository;
	
	@Autowired
	ParentTableService parentTableService;
	@Autowired
	ChildTableService childTableService;
	
	@RequestMapping(value = "/createItems")
	public String createItems() {
		ParentTable parentTable = new ParentTable();
		parentTable.setName("홍길동");
		parentTableRepository.save(parentTable);
		ChildTable childTable = new ChildTable();
		childTable.setTitle("홍길동전");
		childTable.setParentTable(parentTable);
		childTableRepository.save(childTable);
		ChildTable childTable2 = new ChildTable();
		childTable2.setTitle("홍길동전2");
		childTable2.setParentTable(parentTable);
		childTableRepository.save(childTable2);
		
		return "createItems";
	}
	
	@RequestMapping(value="/viewParentItems")
	public String viewParent(Model model) {
		
		List<ParentTable> parentTable = parentTableService.viewAll();
		model.addAttribute("parentItems", parentTable);
		return "parentView";
	}
	
	@RequestMapping(value="/parentOneView/{id}")
	public String viewOneParent(Model model,@PathVariable("id")String getId) {
		int id = Integer.parseInt(getId);
		ParentTable parentTable = parentTableService.viewOne(id);
		model.addAttribute("parentItem", parentTable);
		return "parentOneView";
	}
	
	@RequestMapping(value="/childView/{id}")
	public String viewChild(Model model, @PathVariable("id")String getId) {
		Integer id = Integer.parseInt(getId);
		List<ChildTable> childtable = childTableService.viewChild(id);
		model.addAttribute("childItems", childtable);
		return "childView";
	}
	
}
