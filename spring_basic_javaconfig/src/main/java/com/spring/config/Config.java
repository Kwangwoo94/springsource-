package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.test.LgTV;
import com.spring.test.SamsungTV;
import com.spring.test.MessageBean;
import com.spring.test.MessageBeanEn;

@Configuration //프로젝트와 관련된 설정 파일
public class Config {
	
	@Bean
	public MessageBean messageBean() {
//	<bean id="messageBean" class="com.spring.test.MessageBeanEn"/>
		return new MessageBeanEn();
	}
	@Bean
	public LgTV lg() {
//	<bean id="lg" class="com.spring.test.LgTV"/>
		return new LgTV();
	}
	
	@Bean
	public SamsungTV samsung() {
//	<bean id="samsung" class="com.spring.test.SamsungTV"/>
		return new SamsungTV();
	}
	
}
