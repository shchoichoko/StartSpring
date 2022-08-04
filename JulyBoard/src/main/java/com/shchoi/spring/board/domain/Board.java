package com.shchoi.spring.board.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer number;
	
	private String name;
	
	@OneToMany(mappedBy = "board",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Reply2> reply2;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
