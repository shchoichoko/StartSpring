package kr.ac.kopo.ctc.spring.board.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
/*
public class BoardItemRepositoryImpl implements BoardItemRepository {

	@Autowired
	BoardItemRepository boardItemRepository;

	@Override
	public List<BoardItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BoardItem> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<BoardItem> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardItem getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardItem getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardItem getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BoardItem> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardItem entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends BoardItem> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends BoardItem> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends BoardItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends BoardItem> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends BoardItem> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends BoardItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BoardItem> findOne(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<BoardItem> findAll(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findAll(Specification<BoardItem> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAll(Specification<BoardItem> spec, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Specification<BoardItem> spec) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<BoardItem> findOneByAuthor(String author) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<BoardItem> findOneById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Page<BoardItem> findAllByAuthor(String author, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findByTitleContaining(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BoardItem> findByTitleContaining(String title, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllByBoardgroup_id(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardItem> findAllById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
*/
