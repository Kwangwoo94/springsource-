package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	private int pageNum;
	private int amount;
	
	//검색 추가
	private String type; //검색조건
	private String keyword; //검색어
	
	public Criteria() {
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		//type => TCW =>{"T","C","W"}
		return type==null?new String[] {}:type.split("");
	}
	
}
