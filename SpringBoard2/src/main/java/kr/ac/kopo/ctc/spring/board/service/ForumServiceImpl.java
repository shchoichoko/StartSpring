package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.pagenation.PageDto;
import kr.ac.kopo.ctc.spring.board.pagenation.Pagination;
import kr.ac.kopo.ctc.spring.board.repository.ForumRepository;
@Service
public class ForumServiceImpl implements ForumService {

	private final int countPerPage = 20;
	private final int pageSize = 10;
	
	@Autowired
	ForumRepository forumRepository;
	
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
			list = forumListPage(pageable);
		} else {
			list = forumSearchInList(keyword, pageable);
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
			forum.setCountView(0);
			write(forum);
			checkResult = "작성이 완료되었습니다.";
		}
		return checkResult;
	}

	@Override
	public PageDto getList(Integer cPage, String keyword) {
		int cPageNo = checkCPage(cPage, countPerPage, keyword);
		
		PageRequest pageable = PageRequest.of(cPageNo, countPerPage);
		Page<Forum> BoardItems = (keyword == null || keyword.equals("") ? 
		forumRepository.findAllByOrderByIdDesc(pageable) :
		forumRepository.findAllByTitleContainingOrderByIdDesc(keyword, pageable));
		
		Pagination pagination = makePagination(cPageNo + 1, countPerPage, pageSize, (int) BoardItems.getTotalElements());
		
		PageDto PageDto = new PageDto(BoardItems, pagination);
		
		return PageDto;
	}

	@Override
	public Pagination makePagination(int cPage, int countPerPage, int pageSize, int totalRecordCount) {
		Pagination pagination = new Pagination();

		// 총 페이지 수
		int totalPage = 0;
		if ((totalRecordCount % countPerPage) == 0) {
			totalPage = totalRecordCount / countPerPage;
		} else {
			totalPage = totalRecordCount / countPerPage + 1;
		}
		pagination.setTotalPage(totalPage);

		// 현재 페이지 번호
		if (cPage >= totalPage) {
			cPage = totalPage;
		} else if (cPage < 1) {
			cPage = 1;
		}
		pagination.setcPage(cPage);

		// 첫 페이지 번호
		int startPage = (cPage / pageSize) * pageSize + 1;
		if ((cPage % pageSize) == 0) {
			startPage -= pageSize;
		}
		pagination.setStartPage(startPage);

		// 마지막 페이지 번호
		int lastPage = (startPage + pageSize - 1) >= totalPage ? totalPage : (startPage + pageSize - 1);
		pagination.setLastPage(lastPage);

		// 첫 페이지 번호 & 이전 그룹 마지막 페이지 번호
		int ppPage = 0;
		int pPage = 0;
		if (startPage != 1) {
			ppPage = 1;
			pPage = startPage - 1;
		}
		pagination.setPpPage(ppPage);
		pagination.setpPage(pPage);

		// 다음 그룹 첫 페이지 번호 & 마지막 페이지 번호
		int nnPage = 0;
		int nPage = 0;
		if (!(startPage <= totalPage && totalPage <= startPage + pageSize - 1) && (totalPage != 0)) {
			nnPage = totalPage;
			nPage = startPage + pageSize;
		}
		pagination.setNnPage(nnPage);
		pagination.setnPage(nPage);

		// 한 페이지 당 레코드 수, 한 그룹 당 페이지 수, 총 게시물 수
		pagination.setCountPerPage(countPerPage);
		pagination.setPageSize(pageSize);
		pagination.setTotalRecordCount(totalRecordCount);

		// 레코드가 0개 일 경우 예외 처리
		if (totalRecordCount == 0) {
			pagination.setStartPage(0);
			pagination.setLastPage(0);
			pagination.setPpPage(0);
			pagination.setpPage(0);
			pagination.setNnPage(0);
			pagination.setnPage(0);
			pagination.setTotalPage(0);
		}
		return pagination;
	}

	@Override
	public int checkCPage(Integer cPage, int countPerPage, String keyword) {
		int totalcount = (int)(keyword == null || keyword.equals("") ?
				forumRepository.count() :
				forumRepository.countByTitleContaining(keyword));
			int totalPage = totalcount / countPerPage + (totalcount % countPerPage > 0 ? 1 : 0);
			
			/* 예외 처리 */
			if (cPage <= 0 || totalcount == 0) {	// cPage가 음수 혹은 레코드가 없을 경우
				cPage = 0;
			} else if (cPage > 0 && cPage <= totalPage) {	// 정상일 때 조회를 위해 cPage--
				cPage--;
			} else {								// cPage가 총 페이지 수보다 클 때
				cPage = totalPage - 1;
			}

			return cPage;
	}

}
