package com.spring.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageVO {
	//페이지 나누기와 관련된 정보를 담고 있는 객체
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private Criteria cri;
	
	public PageVO(Criteria cri,int total) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil((total/1.0)/cri.getAmount()));
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage>1;
		this.next = this.endPage < realEnd;
	}
}
