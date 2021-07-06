package com.spring.testvo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OfficeNoticeVO {
	private int docNum; //공문번호
	private String title; //공문제목
	private String contents; //공문내용
	private String authority; //권한
	private boolean sign; //사인 존재 여부 확인?
	private boolean attachFile; //첨부 파일 있는지 없는지확인
	private int retentDate; //만료기한 (1~3)
	private int send; //송신처/송신자
	private int dest; //수신처/수신자/결재자
	private int review; //검토자
	private String state; //공문상태
	private String storage; //공문 보관함
	private String message; //결재/반려 시 메세지
	private Date regDate; //공문 작성 일자
}
