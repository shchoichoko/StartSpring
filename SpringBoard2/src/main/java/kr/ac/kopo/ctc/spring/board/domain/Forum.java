package kr.ac.kopo.ctc.spring.board.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity(name="forum")
@Data
@Getter @Setter
public class Forum {
	
    //부모가 지워지면 자식도 지워짐(orphan removal)
    @OneToMany(mappedBy = "forum", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BoardReply> boardReply;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String title;
	
	@Column(name="date")
	private String date;
	
	//DB에 해당 테이블의 insert 연산을 실행 할 때 아래 함수를 실행하도록하는 어노테이션
	@PrePersist
	public void createAt() {
		this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
	}
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name="countView")
	private Integer countView;

	@Column
	private String author;
	
	public List<BoardReply> getBoardReply() {
		return boardReply;
	}

	public void setBoardReply(List<BoardReply> boardReply) {
		this.boardReply = boardReply;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCountView() {
		return countView;
	}

	public void setCountView(Integer countView) {
		this.countView = countView;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Forum() {

	}

	public Forum(String title, String author, String date, String content, Integer countView) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.content = content;
		this.countView = countView;
	}
}
