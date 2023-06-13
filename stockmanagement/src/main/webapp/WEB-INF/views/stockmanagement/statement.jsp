<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    .main_title{
      text-align: center !important; border-bottom: 2px solid #ddd !important;
    }
    .sub_title_left{
      text-align: center !important;
    }
    .sub_title_right{
      border-left: 2px solid #ddd !important; text-align: center !important;
    }
    .my_content{
      text-align: left !important;
    }

  </style>
</head>
<body>

<div class="web-container">

  <div class="page-container">
    Page
    <span class="page"></span>
    of
    <span class="pages"></span>
  </div>
  
  <div class="logo-container">
   <h1>거래명세서</h1>
  </div>
  
  <table class="line-items-container">
    <tr>
      <td colspan="2" class="client-name main_title">
        <strong>공급받는자</strong>
      </td>

      <td colspan="2" class="client-name main_title">
        <strong>공급자</strong>
      </td>
    </tr>

    <tr>
      <td class="sub_title_left">
        <strong>상호(법인명) : </strong>
      </td>
      <td class="my_content">
        우리 회사
      </td>
      <td class="sub_title_right">
        <strong>상호(법인명) : </strong>
      </td>
      <td class="my_content">
        협력사
      </td>
    </tr>
    <tr>
      <td class="sub_title_left">
        <strong>사업장 주소 : </strong>
      </td>
      <td class="my_content">
        우리 회사 주소
      </td>
      <td class="sub_title_right">
        <strong>사업장 주소 : </strong>
      </td>
      <td class="my_content">
        협력사 주소
      </td>
    </tr>
    <tr>
      <td class="sub_title_left">
        <strong>전화번호 : </strong>
      </td>
      <td class="my_content">
        031-000-0000
      </td>
      <td class="sub_title_right">
        <strong>전화번호 : </strong>
      </td>
      <td class="my_content">
        031-111-1111
      </td>
    </tr>
    <tr>
      <td class="sub_title_left">
        <strong>인수자 : </strong>
      </td>
      <td class="my_content">
        <input type="text">
      </td>
      <td class="sub_title_right">
        <strong>담당자 성명 : </strong>
      </td>
      <td class="my_content">
        협력사 담당자
      </td>
    </tr>
    <tr>
      <td>
      </td>
      <td>
        
      </td>
      <td class="sub_title_right">
        <strong>담당자 e-mail : </strong>
      </td>
      <td class="my_content">
        aaa@aaa.com
      </td>
    </tr>
  </table>
  
  <table class="line-items-container">
    <thead>
      <tr>
        <th class="heading-description" style="font-size: medium;">품목명</th>
        <th class="heading-quantity" style="font-size: medium; text-align: center;">수량</th>
        <th class="heading-price" style="font-size: medium; text-align: center;">공급가격</th>
        <th class="heading-subtotal" style="font-size: medium; text-align: center;">합계금액</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td >Blue large widgets</td>
        <td style="text-align: center;">2</td>
        <td class="right"  style="text-align: center;">$15.00</td>
        <td class="bold" style="text-align: center;">$30.00</td>
      </tr>
      <tr>
        <td>Green medium widgets</td>
        <td style="text-align: center;">3</td>
        <td class="right" style="text-align: center;">$10.00</td>
        <td class="bold" style="text-align: center;">$40.00</td>
      </tr>
      <tr>
        <td>Red small widgets with logo</td>
        <td style="text-align: center;">10</td>
        <td class="right" style="text-align: center;">$7.00</td>
        <td class="bold" style="text-align: center;">$35.00</td>
      </tr>
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
          <div><input type="date"></div>
        </td>
        <td class="payment-info" style="font-size: medium;">
          <div>2,000</div>
        </td>
        <td class="payment-info" style="font-size: medium;">
          <div>10%</div>
        </td>
        <td class="large">
          <div>222,000</div>
        </td>
      </tr>
    </tbody>
  </table>
  
  <div class="footer">
    <div class="footer-info">
      <button onclick="location.href='mailto:aa@aaa.com'">협력사 통보</button> |
      <button onclick="return window.print()">출력</button> |
      <button>저장</button>
    </div>
    <div class="footer-thanks">
      <img src="https://github.com/anvilco/html-pdf-invoice-template/raw/main/img/heart.png" alt="heart">
      <span>Thank you!</span>
    </div>
  </div>

</div>



</body></html>
