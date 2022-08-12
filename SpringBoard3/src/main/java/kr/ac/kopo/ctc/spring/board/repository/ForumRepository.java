package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.ctc.spring.board.domain.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {
	@Transactional
    @Modifying
    @Query("update forum f set f.countView = f.countView + 1 where f.id = :id")
    int updateView(@Param("id") Integer id);

    Page<Forum> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	List<Forum> findByAuthor(String author);
	
	public long count();
	public long countByTitleContaining(String keyword);
	/* 제목 키워드 검색 (id기준 내림차순) */
	public Page<Forum> findAllByTitleContainingOrderByIdDesc(String keyword, Pageable pageagle);
	
	/* 목록 조회 (id기준 내림차순) */
	public Page<Forum> findAllByOrderByIdDesc(Pageable pageagle);
}
