package kr.ac.kopo.ctc.spring.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChildTable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	private ParentTable parentTable;

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

	public ParentTable getParentTable() {
		return parentTable;
	}

	public void setParentTable(ParentTable parentTable) {
		this.parentTable = parentTable;
	}
}
