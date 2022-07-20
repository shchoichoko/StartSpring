package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.repository.ForumRepository;

public class ForumServiceImpl implements ForumService {

	@Autowired
	ForumRepository forumRepository;
	
	@Autowired
	ForumService forumService;
	
	@Override
	public void write(Forum forum) {
		forumRepository.save(forum);
	}

	@Override
	public Page<Forum> forumListPage(Pageable pageable) {
		return forumRepository.findAll(pageable);
	}

	@Override
	public Page<Forum> forumSearchInList(String searchKeyword, Pageable pageable) {
		return forumRepository.findByTitleContaining(searchKeyword, pageable);
	}

	@Override
	public Forum forumView(Integer id) {
		return forumRepository.findById(id).get();
	}

	@Override
	public int updateView(Integer id) {
		return forumRepository.updateView(id);
	}

	@Override
	public void forumDelete(Integer id) {
		forumRepository.deleteById(id);
	}

	@Override
	public Page<Forum> checkKeyword(String keyword, Pageable pageable) {
		Page<Forum> list = null;
		if(keyword == null) {
			list = forumService.forumListPage(pageable);
		} else {
			list = forumService.forumSearchInList(keyword, pageable);
		}
		return null;
	}

	@Override
	public String checkWritePage(Forum forum) {
		String checkResult = "";
		if(forum.getTitle().isEmpty()) {
			checkResult = "제목을 입력해주세요";
		} else if(forum.getContent().isEmpty()) {
			checkResult = "내용을 입력해주세요";
		} else {
			forumService.write(forum);
			checkResult = "작성이 완료되었습니다.";
		}
		return checkResult;
	}

}
