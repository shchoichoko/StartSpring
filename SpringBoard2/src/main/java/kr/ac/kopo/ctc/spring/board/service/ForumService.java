package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.spring.board.domain.Forum;

public interface ForumService {
	
	void write(Forum forum);
	Page<Forum> forumListPage(Pageable pageable);
	Page<Forum> forumSearchInList(String searchKeyword,Pageable pageable);
	Forum forumView(Integer id);
	int updateView(Integer id);
	void forumDelete(Integer id);
	Page<Forum> checkKeyword(String keyword, Pageable pageable);
	String checkWritePage(Forum forum);
	
	
}
