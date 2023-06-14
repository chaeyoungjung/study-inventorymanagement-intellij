<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html class="no-js" lang="">

<head>
<meta charset="utf-8">
<title>거래명세서</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/resources/css/modern-normalize.css">
<link rel="stylesheet" href="/resources/css/web-base.css">
<link rel="stylesheet" href="/resources/css/invoice.css">
<script type="text/javascript" src="/resources/js/scripts.js"></script>
<style>
.main_title {
	text-align: center !important;
	border-bottom: 2px solid #ddd !important;
}

.sub_title_left {
	text-align: center !important;
}

.sub_title_right {
	border-left: 2px solid #ddd !important;
	text-align: center !important;
}

.my_content {
	text-align: left !important;
}
</style>
</head>
<body>

	<form action="inputtransactionstatement" method="post">
		<div class="web-container">

			<div class="page-container">
				Page <span class="page"></span> of <span class="pages"></span>
			</div>

			<div class="logo-container">
				<h1>거래명세서</h1>
			</div>
			<table class="line-items-container">
				<tr>
					<td colspan="2" class="client-name main_title"><strong>공급받는자</strong>
					</td>

					<td colspan="2" class="client-name main_title"><strong>공급자</strong>
					</td>
				</tr>

				<tr>
					<td class="sub_title_left"><strong>상호(법인명) : </strong></td>
					<td class="my_content">우리 회사</td>
					<td class="sub_title_right"><strong>상호(법인명) : </strong></td>
					<td class="my_content">${tsVO.subcontractor_name}</td>
				</tr>
				<tr>
					<td class="sub_title_left"><strong>사업장 주소 : </strong></td>
					<td class="my_content">우리 회사 주소</td>
					<td class="sub_title_right"><strong>사업장 주소 : </strong></td>
					<td class="my_content">${tsVO.subcontractor_address}</td>
				</tr>
				<tr>
					<td class="sub_title_left"><strong>전화번호 : </strong></td>
					<td class="my_content">031-000-0000</td>
					<td class="sub_title_right"><strong>전화번호 : </strong></td>
					<td class="my_content">${tsVO.subcontractor_tel}</td>
				</tr>
				<tr>
					<td class="sub_title_left"><strong>인수자 : </strong></td>
					<td class="my_content"><c:if test="${tsVO.acceptor != null}">${tsVO.acceptor}</c:if>
						<c:if test="${tsVO.acceptor == null}">
							<input type="text" name="person">
						</c:if></td>
					<td class="sub_title_right"><strong>담당자 성명 : </strong></td>
					<td class="my_content">${tsVO.subcontractor_person}</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td class="sub_title_right"><strong>담당자 e-mail : </strong></td>
					<td class="my_content">${tsVO.subcontractor_email}</td>
				</tr>
			</table>

			<table class="line-items-container">
				<thead>
					<tr>
						<th class="heading-description" style="font-size: medium;">품목명</th>
						<th class="heading-quantity"
							style="font-size: medium; text-align: center;">수량</th>
						<th class="heading-price"
							style="font-size: medium; text-align: center;">공급가격</th>
						<th class="heading-subtotal"
							style="font-size: medium; text-align: center;">합계금액</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="total" value="0" />
					<c:forEach var="list" items="${tsList}">
						<tr>
							<td>${list.item_name }</td>
							<td style="text-align: center;">${list.amount }</td>
							<td class="right" style="text-align: center;"><fmt:formatNumber
									value="${list.price }" pattern="#,###" /></td>
							<td class="bold" style="text-align: center;"><fmt:formatNumber
									value="${list.amount * list.price }" pattern="#,###" /></td>
						</tr>
						<input type="hidden"
							value="${total=total+(list.amount * list.price)}">
					</c:forEach>
				</tbody>
			</table>


			<table class="line-items-container has-bottom-border">
				<thead>
					<tr>
						<th style="font-size: medium;">거래일자</th>
						<th style="font-size: medium;">공급가액</th>
						<th style="font-size: medium;">세액</th>
						<th style="font-size: medium;">총 합계금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="payment-info" style="font-size: medium;">
							<div>
								<c:if test="${tsVO.deal_date != null}">
									<fmt:formatDate value="${tsVO.deal_date}"
										pattern="yyyy-MM-dd (E)" />
								</c:if>
								<c:if test="${tsVO.deal_date == null}">
									<input type="date" name="date">
								</c:if>
							</div>
						</td>
						<td class="payment-info" style="font-size: medium;">
							<div>
								<fmt:formatNumber value="${total}" pattern="#,###" />
							</div>
						</td>
						<td class="payment-info" style="font-size: medium;">
							<div>
								<fmt:formatNumber value="${total *(1/10)}" pattern="#,###" />
							</div>
						</td>
						<td class="large">
							<div>
								<fmt:formatNumber value="${total+total *(1/10)}" pattern="#,###" />
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="footer">
				<div class="footer-info">
					<c:if test="${tsVO.acceptor != null}">

				      <button type="button" onclick="return window.print()">출력</button> |
				     </c:if>
					<c:if test="${tsVO.acceptor == null}">
						<button type="submit">저장</button> |</c:if>
					<button type="button" onclick="location.href='/stockmanagement/transactionstatementmain'">돌아가기</button>
				</div>
				<div class="footer-thanks">
					<img
						src="https://github.com/anvilco/html-pdf-invoice-template/raw/main/img/heart.png"
						alt="heart"> <span>Thank you!</span>
				</div>
				<input type="hidden" name=po_code value="${po_code}">
			</div>
		</div>
	</form>




</body>
</html>
