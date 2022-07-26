package kr.ac.kopo.ctc.spring.board.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ParentTable {
	@Id
	@Column(name="parentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@OneToMany(mappedBy = "parentTable",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ChildTable> childTable;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ChildTable> getChildTable() {
		return childTable;
	}
	public void setChildTable(List<ChildTable> childTable) {
		this.childTable = childTable;
	}
}
