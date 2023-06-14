<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Suraj">
<!--meta name="_csrf" th:content=""/>
    <meta name="_csrf_header" th:content=""/-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/core/bootstrap-5.min.css"
	type="text/css" />
<link rel="stylesheet" href="/resources/css/custom.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/core/flag-icon.min.css"
	type="text/css" />
<title>입고처리(마감)</title>
<script type="text/javascript" src="/resources/js/navbar-scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
</head>
<body>
	<div>
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
				style="position: relative;">
				<div class="container-fluid">
					<a class="navbar-brand" href="#" onclick="goToHome();">
						<h2>
							<b>조달구매시스템</b>
						</h2>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="navbarSupportedContent"
					style="position: absolute; left: 250px; top: 40px;">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="inboundmain" id="inbound">입고처리(마감)</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="transactionstatementmain"
							id="transactionStatement">거래명세서 발행</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="outbound" id="outbound">출고처리</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="stockcalculation" id="stockCalculation">재고산출</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="report" id="report">현황관리리포트(재고금액)</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</nav>
			<div class="area"></div>
			<nav class="main-menu">
				<ul>
					<li class="has-subnav" style="font-size: 10px;"><a href="#"
						style="height: 50px;" id="procurement">
							<div class="nav-text" style="position: relative; left: 10px;">
								조달 관리</div>
					</a></li>
					<li class="has-subnav" style="font-size: 10px;"><a href="#"
						style="height: 50px;" id="order">
							<div class="nav-text" style="position: relative; left: 10px;">
								발주 관리</div>
					</a></li>
					<li class="has-subnav" style="font-size: 10px;"><a href="#"
						style="height: 50px;" id="stock">
							<div class="nav-text" style="position: relative; left: 10px;">
								자재 관리</div>
					</a></li>
				</ul>
			</nav>
			<br />
		</div>
	</div>
	<div style="position: relative;">
		<form action="insertinbound" method="post">
			<button type="button" class="btn btn-primary"
				style="position: relative; left: 1355px; background-color: rgb(29, 204, 81); border-color: rgb(29, 204, 81);"
				data-bs-toggle="modal" data-bs-target="#newInvoiceModal"
				id="modalbtn">조달계획조회</button>
			<button type="submit" class="btn btn-primary"
				style="position: relative; left: 1355px;">입고등록</button>
			<div class="container"
				style="position: absolute; left: 250px; width: 3000px;">

				<div class="wrap">
					<div class="card" style="border-color: #FFFFFF;">
						<form action="outbound">
							<div class="card-body">
								<div class="row g-3">
									<div class="col-md-3">
										<b style="font-size: large;">협력업체: <span>${supplier }</span></b>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
						</form>
					</div>
					<br /> <br />
					<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
		                <symbol id="check-circle-fill" fill="currentColor"
							viewBox="0 0 16 16">
		                    <path
							d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
		                </symbol>
		                <symbol id="info-fill" fill="currentColor"
							viewBox="0 0 16 16">
		                    <path
							d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
		                </symbol>
		                <symbol id="exclamation-triangle-fill"
							fill="currentColor" viewBox="0 0 16 16">
		                    <path
							d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
		                </symbol>
		            </svg>

					<table id='myTable'
						class="table table-bordered table-striped table-hover caption-top">
						<caption style="color: black;">
							<b>발주품목 목록</b>
						</caption>
						<thead class="table-dark">
							<tr>
								<th scope="col" style="text-align: center;">순번</th>
								<th scope="col" style="text-align: center;">품목코드</th>
								<th scope="col" style="text-align: center;">품목명</th>
								<th scope="col" style="text-align: center;">발주수량</th>
								<th scope="col" style="text-align: center;">조달계획 완료여부</th>
								<th scope="col" style="text-align: center;">입고수량</th>
								<th scope="col" style="text-align: center;">입고일</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="no" value="0" />
							<c:forEach var="list" items="${oiList }">
								<tr>
									<td style="text-align: center;">${no=no+1 }</td>
									<td style="text-align: center;"><span>${list.item_code }</span></td>
									<td style="text-align: center;"><span>${list.item_name }</span></td>
									<td style="text-align: center;"><span> <fmt:formatNumber
												value="${list.amount }" pattern="#,###" />
									</span></td>
									<c:if test="${list.pp_status == 0 }">
										<td style="text-align: center;"><span>미완료</span></td>
										<td style="text-align: center;"><input type="number"
											name="inBoundVOList[${no-1}].amount" id="amount"></td>
										<td style="text-align: center;"><input type="date"
											name="inBoundVOList[${no-1}].date" id="date"></td>
									</c:if>
									<c:if test="${list.pp_status == 1 }">
										<td style="text-align: center;"><span>완료</span></td>
										<td style="text-align: center;" colspan="2"><span>입고완료</span>
										</td>
									</c:if>
									<input type="hidden" value="${list.item_code }"
										name="inBoundVOList[${no-1}].item_code">
									<input type="hidden" value="${po_code}"
										name="inBoundVOList[${no-1}].po_code">
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</form>
		<div id="newInvoiceModal" class="modal fade" tabindex="-1"
			aria-labelledby="newInvoiceModal" aria-hidden="true">
			<form action="" method="post">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">조달계획조회</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close" id="close"></button>
						</div>
						<div id="invoiceModalBody" class="modal-body">
							<table id='myModalTable'
								class="table table-bordered table-striped table-hover caption-top">
								<thead class="table-dark">

									<tr>
										<th scope="col" style="text-align: center;">순번</th>
										<th scope="col" style="text-align: center;">품목코드</th>
										<th scope="col" style="text-align: center;">품목명</th>
										<th scope="col" style="text-align: center;">자재소요공정</th>
										<th scope="col" style="text-align: center;">생산일</th>
										<th scope="col" style="text-align: center;">소요량</th>
										<th scope="col" style="text-align: center;">조달납기</th>
										<th scope="col" style="text-align: center;">완료여부</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="no" value="0" />
									<c:forEach var="list" items="${ppList }">
										<tr>
											<td style="text-align: center;"><span>${no=no+1 }</span></td>
											<td style="text-align: center;"><span>${list.item_code }</span></td>
											<td style="text-align: center;"><span>${list.item_name }</span></td>
											<td style="text-align: center;"><span>${list.process }</span></td>
											<td style="text-align: center;"><span> <fmt:formatDate
														value="${list.production_date}" pattern="yyyy-MM-dd(E)" />
											</span></td>
											<td style="text-align: center;"><span> <fmt:formatNumber
														value="${list.amount }" pattern="#,###" />
											</span></td>
											<td style="text-align: center;"><span><fmt:formatDate
														value="${list.procurement_date }" pattern="yyyy-MM-dd(E)" /></span>
											</td>
											<td style="text-align: center;"><c:if
													test="${list.pp_status == 0 }">
													<span>미완료</span>
												</c:if> <c:if test="${list.pp_status == 1 }">
													<span>완료</span>
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<input type="hidden" value="0" id="flag">
	<script src="/resources/js/core/popper.min.js" type="text/javascript"></script>
	<script src="/resources/js/core/bootstrap-5.min.js"
		type="text/javascript"></script>
	<script>
		if (document.getElementById("flag").value == 0) {
			document.getElementById("inbound").style.backgroundColor = "#fff";
			document.getElementById("inbound").style.color = "#000000";
			document.getElementById("inbound").style.fontWeight = "bold";
			document.getElementById("stock").style.backgroundColor = "#fff";
			document.getElementById("stock").style.color = "#000000";
			document.getElementById("stock").style.fontWeight = "bold";
		}
	</script>
	<script>
		$(document).ready(function() {
			$('#startDate').change(function() {
				if ($('#startDate').val() != '') {
					$('#endDate').attr('required', true);
					console.log("시작일 값 있음");
				} else {
					$('#endDate').attr('required', false);
					console.log("시작일 값 없음");
				}
			});
			$('#endDate').change(function() {
				if ($('#endDate').val() != '') {
					$('#startDate').attr('required', true);
					console.log("종료일 값 있음");
				} else {
					$('#startDate').attr('required', false);
					console.log("종료일 값 없음");
				}
			});

			$(document).on("change", '#amount', function() {
				if ($('#amount').val() != '') {
					$('#date').attr('required', true);
					console.log("출고량 값 있음");
				} else {
					$('#date').attr('required', false);
					console.log("출고량 값 없음");
				}
			});
			$(document).on("change", '#date', function() {
				if ($('#date').val() != '') {
					$('#amount').attr('required', true);
					console.log("출고일 값 있음");
				} else {
					$('#amount').attr('required', false);
					console.log("출고일 값 없음");
				}
			});

		});
	</script>
	<script>
		$("#modalbtn").click(function() {
			$("#newInvoiceModal").fadeIn();
		}); //로그인버튼을 누르면 모달창 생성 
		$("#close").click(function() {
			$("#newInvoiceModal").fadeOut(); //닫기를 누르면 모달창 사라짐
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#myModalTable').tablesorter();
		});
		$(document).ready(function() {
			$('#myTable').tablesorter();
		});
	</script>

</body>
</html>