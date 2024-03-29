package kr.ac.kopo.ctc.spring.board.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.pagenation.PageDto;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;
import kr.ac.kopo.ctc.spring.board.service.ForumService;

@Controller
@RequestMapping(value = "/forum")
public class ForumController {

	@Autowired
	private ForumService forumService;
	@Autowired
	private BoardReplyService boardReplyService;

	// 글 작성 페이지로 보내기
	@RequestMapping(value = "/goWrite")
	public String goWrite() {
		return "write";
	}

	// 글 작성 확인 페이지
	@RequestMapping(value = "/confirmWrite")
	public String confirmWrite(Forum forum, Model model) {
		model.addAttribute("message", forumService.checkWritePage(forum));
		model.addAttribute("url", "/forum/showForumList");
		return "confirmWrite";
	}

	// 글 목록 페이지
	/* 목록 조회 */
	@RequestMapping(value = "/showForumList")
	public String showBoardList(Model model,
		@RequestParam(value = "cPage", required = false, defaultValue = "0") Integer cPage,
		@RequestParam(value = "keyword", required = false) String keyword) {
		PageDto pageDto = forumService.getList(cPage, keyword);
		model.addAttribute("PageDto", pageDto);
		model.addAttribute("keyword", keyword);
		System.out.println(cPage);
		return "forumList";
	}


	// 글 하나 보기
	@GetMapping(value = "/showOneForum/{id}")
	public String showOne(@PathVariable("id") String getId, Model model) {
		Integer id = Integer.parseInt(getId);
		model.addAttribute("forum", forumService.forumView(id));
		forumService.updateView(id);
		
		// 댓글 list가 계속 보여지기 위해서 view에도 명시해둠
		List<BoardReply> replyLists = boardReplyService.getReplyBoardID(id);
		model.addAttribute("boardReplyLists", replyLists);

		return "showOneForum";
	}

	// 글 삭제하기
	@RequestMapping(value = "/delete/{id}")
	public String deleteOne(@PathVariable("id") String getId) {
		Integer id = Integer.parseInt(getId);
		forumService.forumDelete(id);
		return "deleteComplete";
	}

	// 글 수정페이지로 이동하기
	@RequestMapping(value = "/modify/{id}")
	public String modifyForum(@PathVariable("id") String getId, Model model) {
		Integer id = Integer.parseInt(getId);
		model.addAttribute("forumModify", forumService.forumView(id));
		return "forumModify";
	}

	// 글 수정하기
	@RequestMapping("/update/{id}")
	public String boardUpdate(@PathVariable("id") String getId, Forum forum) throws Exception {
		Integer id = Integer.parseInt(getId);
		String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
		Forum updatedForum = forumService.forumView(id);
		updatedForum.setTitle(forum.getTitle());
		updatedForum.setContent(forum.getContent());
		updatedForum.setAuthor(forum.getAuthor());
		updatedForum.setDate(nowTime);
		forumService.write(updatedForum);
		return "forumModifyComplete";

	}

}
