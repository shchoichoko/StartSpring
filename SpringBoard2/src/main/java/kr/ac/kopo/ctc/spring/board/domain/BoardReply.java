package kr.ac.kopo.ctc.spring.board.domain;

import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// hibernate가 구분하기 위해 id는 꼭 여기서 import하기
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;


@Entity(name="boardReply")
@Data
@Getter @Setter
public class BoardReply{

	
	/*
	 
    User user ==> ManyToOne(user가 부모) ==> 댓글작성자
    Forum forum ==> ManyToOne (forum이 부모) ==> 댓글이 포함되는 게시글
    Timestamp createDate ==> 작성일
    String content ==> 댓글 내용
    
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer replyId;
	
	@Column(nullable = false)
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
	
    @NonNull
	@Column
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private Forum forum;
	
	public BoardReply() {}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}


}
