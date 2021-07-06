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
	private int docNum; //������ȣ
	private String title; //��������
	private String contents; //��������
	private String authority; //����
	private boolean sign; //���� ���� ���� Ȯ��?
	private boolean attachFile; //÷�� ���� �ִ��� ������Ȯ��
	private int retentDate; //������� (1~3)
	private int send; //�۽�ó/�۽���
	private int dest; //����ó/������/������
	private int review; //������
	private String state; //��������
	private String storage; //���� ������
	private String message; //����/�ݷ� �� �޼���
	private Date regDate; //���� �ۼ� ����
}
