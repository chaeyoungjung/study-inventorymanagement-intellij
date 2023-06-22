<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Suraj">
<!--meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_header" th:content="${_csrf.headerName}"/-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/core/bootstrap-5.min.css"
	type="text/css" />
<link rel="stylesheet" href="/resources/css/custom.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/apexcharts.css"
	type="text/css" />
<link rel="stylesheet" href="/resources/css/core/flag-icon.min.css"
	type="text/css" />
<title>재고금액현황관리리포트</title>
<script type="text/javascript" src="/resources/js/navbar-scripts.js"></script>
<script type="text/javascript" src="/resources/js/apexcharts.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
 <style>
    select option[value=""][disabled] {
     display: none;
    }
</style>
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
							class="nav-link" href="inbound" id="inbound">입고처리(마감)</a></li>
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

	<div class="container">
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="item-tab" data-bs-toggle="tab"
					data-bs-target="#reportByItem" type="button" role="tab"
					aria-controls="txnReport" aria-selected="false">품목별 조회</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="date-tab" data-bs-toggle="tab"
					data-bs-target="#reportByDate" type="button" role="tab"
					aria-controls="invoiceReport" aria-selected="false">날짜별 조회</button>
			</li>
		</ul>
		<form action="report">
			<div class="tab-content">
				<div class="tab-pane fade show active" id="reportByItem"
					role="tabpanel" aria-labelledby="txn-tab"></div>
				<div class="tab-pane fade" id="reportByDate" role="tabpanel"
					aria-labelledby="invoice-tab"></div>
			</div>
		</form>
		<br /> <br />
		<div class="wrap">
			<div class="card" id="chartarea">
				<div class="card-header">Report :</div>
				<div id="chart" style="height: 80%; width: 100%;"></div>
			</div>
		</div>
	</div>
	</form>
	<input type="hidden" value="4" id="flag">
	<script src="/resources/js/core/popper.min.js" type="text/javascript"></script>
	<script src="/resources/js/core/bootstrap-5.min.js"
		type="text/javascript"></script>
	<script>
	if (document.getElementById("flag").value == 4) {
		document.getElementById("report").style.backgroundColor = "#fff";
		document.getElementById("report").style.color = "#000000";
		document.getElementById("report").style.fontWeight = "bold";
		document.getElementById("stock").style.backgroundColor = "#fff";
		document.getElementById("stock").style.color = "#000000";
		document.getElementById("stock").style.fontWeight = "bold";

	}
</script>
	<script type="text/javascript">
	var itemReport = `<div class="card">
		<div class="card-body">
		<div class="row g-3">
			<div class="col-md-3">
				<div class="input-group mb-3">
					<span class="input-group-text">산출일</span> <input type="date"
						id="startDate" class="form-control datepicker"
						name="startDate" aria-label="Reported Date (From)" required>
					<span class="input-group-text"><img
						src="/resources/img/calendar3.svg" alt="" width="16"
						height="16" title="calendar" /></span>
				</div>
			</div>
			<div class="col-md-3">
				<div class="input-group mb-3">
					<span class="input-group-text">재고금액(원)</span> <input
						type="number" id="num" name="num"
						class="form-control" placeholder="금액 입력"
						aria-label="txnReportCustomerName"
						aria-describedby="basic-addon1"> <span
						class="input-group-text">이상</span>
				</div>
			</div>
			<div class="col-md-3">
				<div class="input-group mb-3" id="itemCategory">
					<label class="input-group-text" for="txnReportMakeId">품목군</label>
					<select class="form-select" id="category"
						name="category" required>
						<option value="" disabled selected><-- 품목군 선택 --></option>
						<option value="L">대</option>
						<option value="M">중
						<option value="S">소
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn btn-primary" id="itemchartbtn">조회</button>
			</div>
		</div>
	</div>
</div>`;

var dateReport = `<div class="card">
	<div class="card-body">
	<div class="row g-3">
		<div class="col-md-3">
			<div class="input-group mb-3">
				<span class="input-group-text">산출월</span> <input
					type="month" id="month"
					class="form-control datepicker" name="startDate"
					aria-label="Reported Date (From)" required> <span
					class="input-group-text"><img
					src="/resources/img/calendar3.svg" alt="" width="16"
					height="16" title="calendar" /></span>
			</div>
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-primary" id="datechartbtn">조회</button>
		</div>
	</div>
</div>
</div>`;
		$(document).ready(function() {

				$('#reportByItem').html(itemReport);
				$('#item-tab').click(function(){
					$('#reportByDate').text('');
					$('#reportByItem').html(itemReport);
				});
				
				$('#date-tab').click(function(){
					$('#reportByItem').text('');
					$('#reportByDate').html(dateReport);
				});
		})
		
</script>

<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click","#itemchartbtn",function(){
			var startDate = '';
			var num = '';
			var url = '';
			var category = '';
			var title='';
			
			if($('#startDate').val() != ''){
				console.log("품목군 기준 데이터 요청");
				
				title="품목군별 재고금액 현황관리 리포트";
			    startDate = $('#startDate').val();
				console.log("입력된 날짜 : "+startDate);
			    num = $('#num').val();
				console.log("입력된 재고금액 : "+num);
				category = $('#category').val();
				console.log("입력된 품목군 : "+category);
				
				if($('#category').val() == null){
					alert("품목군을 선택해주세요.");
				}else{
					url = "chartitemcategory?startDate="+startDate+"&num="+num+"&category="+category;
				}
			}else{
				alert("산출일을 선택해주세요.");
			}
		    
			if(url != ''){
				console.log("api 요청, 요청 url = "+url)
			    $.ajax({
			        type: 'get',
			        url: '/stockmanagement/api/'+url,
			        contentType: 'application/json; charset=utf-8',
			        success: function(data, status, xhr){
			            
			            var chartLabels = [];
			            var chartData = [];
			            
			            chartLabels.push(data.labelsarr);
			            chartData.push(data.valuesarr);
			            console.log(chartLabels[0]);
			            console.log(chartData[0]);
			            
			            var options = {
			                    series: [{
			                    data: chartData[0],
			                    name: "재고금액"
			                  }],
			                    chart: {
			                    type: 'bar',
			                  },
			                  plotOptions: {
			                    bar: {
			                      borderRadius: 4,
			                      horizontal: true,
			                    }
			                  },
			                  dataLabels: {
			                    enabled: false
			                  },
			                  title: {
			                      text: title,
			                      align: 'center',
			                      margin: 50,
			                      offsetX: 0,
			                      offsetY: 0,
			                      floating: false,
			                      style: {
			                        fontSize:  '25px',
			                        fontWeight:  'bold',
			                        fontFamily:  undefined,
			                      },
			                    },
			                  xaxis: {
			                    categories: chartLabels[0],
			                    labels: {
			                        formatter: function (val) {
			                          return val.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			                        }
			                      }
			                  },
			                  tooltip: {
			                	  y: {
			                          formatter: function (val) {
				                          return val.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

			                      	  }
			                	  
			                  	  }
			                  }

			            };
			            $('#chart').remove();
			            $('#chartarea').append('<div id="chart" style="height: 80%; width: 100%;"></div>');
			                  var chart = new ApexCharts(document.querySelector("#chart"), options);
			                  chart.render();
			        }
			        
			        
			    })
			}
			
		})
	})


</script>


<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click","#datechartbtn",function(){
			
		    var month = $('#month').val();
			console.log("입력된 달 : "+month);
			
			if(month != ''){
			    $.ajax({
			        type: 'get',
			        url: '/stockmanagement/api/chartdate?month='+month,
			        contentType: 'application/json; charset=utf-8',
			        success: function(data, status, xhr){
			            
			            var chartLabels = [];
			            var chartData = [];
			            
			            chartLabels.push(data.labelsarr);
			            chartData.push(data.valuesarr);
			            console.log(chartLabels[0]);
			            console.log(chartData[0]);
			            
			            var options = {
			                    series: [{
			                      name: "재고금액",
			                      data: chartData[0]
			                  }],
			                    chart: {
			                    type: 'line',
			                    zoom: {
			                      enabled: false
			                    }
			                  },
			                  dataLabels: {
			                    enabled: false
			                  },
			                  stroke: {
			                    curve: 'straight'
			                  },
			                  title: {
			                	  text: '날짜별 재고금액 현황관리 리포트',
			                      align: 'center',
			                      margin: 50,
			                      offsetX: 0,
			                      offsetY: 0,
			                      floating: false,
			                      style: {
			                        fontSize:  '25px',
			                        fontWeight:  'bold',
			                        fontFamily:  undefined,
			                      },
			                  },
			                  grid: {
			                    row: {
			                      colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
			                      opacity: 0.5
			                    },
			                  },
			                  xaxis: {
			                	  categories: chartLabels[0],
				                  

			                  },
			                  yaxis: {
			                	  labels: {
				                        formatter: function (val) {
				                          return val.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
				                        }
				                      }
			                  },
			                  tooltip: {
			                	  y: {
			                          formatter: function (val) {
				                          return val.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

			                      	  }
			                	  
			                  	  }
			                  }
			              };
					          $('#chart').remove();
					          $('#chartarea').append('<div id="chart" style="height: 80%; width: 100%;"></div>');
			                  var chart = new ApexCharts(document.querySelector("#chart"), options);
			                  chart.render();
			            
			            
			        }
			        
			    })
				
			}else{
				alert("산출월을 선택해주세요.");
			}
		    
		})
	})


</script>

</body>
</html>


</body>
</html>