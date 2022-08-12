package kr.ac.kopo.ctc.spring.board.pagenation;

import org.springframework.data.domain.Page;

import kr.ac.kopo.ctc.spring.board.domain.Forum;

public class PageDto {
	Page<Forum> forum;
	Pagination pagination;

	public PageDto(Page<Forum> forum, Pagination pagination) {
		this.forum = forum;
		this.pagination = pagination;
	}

	public Page<Forum> getForum() {
		return forum;
	}

	public void setForum(Page<Forum> forum) {
		this.forum = forum;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Pagination getPagination() {
		return pagination;
	}
}
