package com.overc1ock.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.text.SimpleDateFormat;
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

import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MailServiceImpl implements MailService {
	
	StockManagementMapper mapper;

	public void mailSender(List<Integer> pocodeList) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
		log.info("담당자에게 입고마감 메일 보내기 서비스");
		
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
		
		String text = "";
		for (Integer integer : pocodeList) {
			List<ProcurementPlanVO> list = mapper.getPurchaseOrderAtInbound(integer);
			text=text+"<h3>발주서 번호: "+list.get(0).getPo_code()+"&nbsp;&nbsp;&nbsp;입고예정일(조달납기): "+simpleDateFormat.format(list.get(0).getProcurement_date())+"&nbsp;&nbsp;&nbsp;협력업체: "+list.get(0).getSupplier()+"</h3>";
			text=text+"<table><tr><th>품목코드</th><th>품목명</th><th>발주수량</th></tr>";
			for (ProcurementPlanVO vo : list) {
				text=text+"<tr><td style='text-align: center;'>"+vo.getItem_code()+"</td><td style='text-align: center;'>"+vo.getItem_name()+"</td><td style='text-align: center;'>"+vo.getAmount()+"</td></tr>";
			}
			text=text+"</table>";
		}
		String receiver = "mittest1231@gmail.com"; // 메일 받을 주소
		String title = "입고처리(마감)완료의 건";
		String content = "안녕하세요, 담당자님.<br/>입고처리 마감이 완료된 건이 있어 전달 드립니다.<br/><br/>"+text+"<br/><br/>총 "+pocodeList.size()+"건에 대한 입고처리가 완료되었습니다.<br/>구매발주서 마감을 요청드립니다.<br/><br/>감사합니다.";
		

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
