package com.overc1ock.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

	public void mailSender(List<Integer> pocodeList) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mittest1231@gmail.com", "irfhginppavbkual");
			}
		});

		String pocode = "";
		for (Integer integer : pocodeList) {
			pocode=pocode+integer+"번,";
		}
		String receiver = "mittest1231@gmail.com"; // 메일 받을 주소
		String title = "입고처리(마감)완료의 건";
		String content = "안녕하세요, 담당자님.<br/><br/>현재 발주서 코드 "+pocode.substring(0, pocode.length()-1)+" 총 "+pocodeList.size()+"건에 대한 입고처리가 완료되었습니다.<br/>구매발주서 마감을 요청드립니다.<br/><br/>감사합니다.";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("mittest1231@gmail.com", "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
