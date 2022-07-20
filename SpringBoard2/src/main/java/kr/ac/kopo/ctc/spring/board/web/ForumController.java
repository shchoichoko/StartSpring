package kr.ac.kopo.ctc.spring.board.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.repository.BoardReplyRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyServiceImpl;
import kr.ac.kopo.ctc.spring.board.service.ForumService;
import kr.ac.kopo.ctc.spring.board.service.ForumServiceImpl;

@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	@Autowired
	private ForumService forumService;
	@Autowired
	private BoardReplyRepository boardReplyRepository;
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
		model.addAttribute("message",forumService.checkWritePage(forum));
		model.addAttribute("url","/forum/showForumList");
		return "message";
	}
	
	
	// 글 목록 페이지
	// 보류!
	@RequestMapping(value = "/showForumList")
	public String forumList(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
			String searchKeyword) {
		// Page<Forum> checkKeyword(String keyword, Pageable pageable);
		int pastPage = 0;
		int nextPage = 0;
		int numberPerPage = 10;
		Page<Forum> list = null;
		// list = forumService.checkKeyword(searchKeyword, pageable);

		return null;
	}

	@RequestMapping(value = "/showOneForum")
	public String showOne(Model model, Integer id) {
		model.addAttribute("forum", forumService.forumView(id));
		forumService.updateView(id);
		// 댓글 list가 계속 보여지기 위해서 view에도 명시해둠
		List<BoardReply> replyLists = boardReplyService.getReplyBoardID(id);
		model.addAttribute("replyLists", replyLists);

		return "showOneForum";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteOne(@PathVariable("id") Integer id) {
		forumService.forumDelete(id);
		return "forumList";
	}
	
	@RequestMapping(value = "/modify/{id}")
	public String modifyForum(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("board",forumService.forumView(id));
		return "forumModify";
	}
	
	@RequestMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Forum forum) throws Exception {

        String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();

        Forum updatedForum = forumService.forumView(id);
        updatedForum.setTitle(forum.getTitle());
        updatedForum.setContent(forum.getContent());
        updatedForum.setAuthor(forum.getAuthor());
        updatedForum.setDate(nowTime);

        forumService.write(updatedForum);

        return "forumList";

    }	
	
	
}
