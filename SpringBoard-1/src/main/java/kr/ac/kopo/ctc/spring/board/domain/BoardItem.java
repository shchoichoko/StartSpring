package kr.ac.kopo.ctc.spring.board.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// hibernate가 구분하기 위해 id는 꼭 여기서 import하기
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoardItem implements Cloneable, Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String author;
	@Column
	private int no;
	@Column
	private String title;
	@Column
	private Date date;
	@Column
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardgroup_id")
	private BoardGroup boardgroup;
	/*
	public BoardItem(String author, int no, String title, Date date, String content) {
		this.author = author;
		this.no = no;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	*/
	public BoardGroup getBoardgroup() {
		return boardgroup;
	}
	public void setBoardgroup(BoardGroup boardgroup) {
		this.boardgroup = boardgroup;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
