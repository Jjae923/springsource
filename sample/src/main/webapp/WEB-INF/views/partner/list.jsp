<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="../includes/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <h1 class="page-header">Partner List</h1>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <button
            id="regBtn"
            type="button"
            class="btn btn-xs pull-right btn-success"
            onclick="location.href='register'"
          >
            Register Partner
          </button>
        </div>
        <div>&nbsp;</div>
        <div class="panel-body">
          <table class="table table-striped table-bordered table-hover">
            <thead>
              <tr class="text-center">
                <th>번 호</th>
                <th>회사명</th>
                <th>CEO</th>
                <th>연락처</th>
                <th>주 소</th>
                <th>등록일</th>
              </tr>
            </thead>
            <tbody>
              <!-- 파트너 리스트 반복문 -->
              <c:forEach var="vo" items="${list}">
	              <tr class="text-center">
	                <td>${vo.id}</td>
	                <td>${vo.name}</td>
	                <td>${vo.ceo}</td>
	                <td>${vo.contact}</td>
	                <td>${vo.address}</td>
	                <td>${vo.registered}</td>
	              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="../includes/footer.jsp" %>
