package kr.ac.kopo.ctc.spring.board.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
@Entity(name="reply")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer replyId;
	
	@Column
	private String content;
	
	@Column
	private String author;
	
	@Column
	private String title;
	
	@Column
	private String date;
	
	//DB에 해당 테이블의 insert 연산을 실행 할 때 아래 함수를 실행하도록하는 어노테이션
	@PrePersist
	public void createAt() {
		this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private ReviewBoard reviewBoard;
	
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public ReviewBoard getReviewBoard() {
		return reviewBoard;
	}

	public void setReviewBoard(ReviewBoard reviewBoard) {
		this.reviewBoard = reviewBoard;
	}
	
}
