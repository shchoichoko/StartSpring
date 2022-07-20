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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;
import kr.ac.kopo.ctc.spring.board.service.ForumService;

@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private BoardReplyService boardReplyService;
	
	// test 페이지로 보내기
	@RequestMapping(value = "/hello")
	public String goHello() {
		return "hello";
	}
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
		int pPage = 0; int nPage =0; int countPerPage = 10;
        Page<Forum> list = null;

        if(searchKeyword == null) {
            list = forumService.forumListPage(pageable);
        }else {
            list = forumService.forumSearchInList(searchKeyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() +1;
        int totalBlock = list.getTotalPages();
        int startPage = ((nowPage-1)/ countPerPage) * countPerPage + 1;
        if(startPage == 1) {
            pPage = 1;
        }
        if(startPage > 10) {
            pPage = startPage - countPerPage;
        }

        int endPage = startPage + countPerPage -1;
        if(endPage > totalBlock) {
            endPage = totalBlock;
            nPage = endPage;
        } else {
            nPage = endPage +1;
        }

        model.addAttribute("forumList", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("pPage", pPage);
        model.addAttribute("nPage", nPage);
        model.addAttribute("pageSize", 10);
        model.addAttribute("nnPage", totalBlock);
        model.addAttribute("ppPage", 1);

        return "forumList";
	}
	
	//글 하나 보기
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
