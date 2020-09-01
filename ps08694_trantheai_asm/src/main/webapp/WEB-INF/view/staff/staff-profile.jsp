<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<!-- Phần nội dung -->

<div class="row mb-2">
	<div class="col-3">
		<div class="text-center w-100 h-auto p-4" >
			<c:choose>
			  <c:when test="${staff.photo.length() > 0}">
			    <img class="rounded" alt="Avatar" src="images/avatar/${staff.photo}" width="128px" height="128px">
			  </c:when>
			  <c:otherwise>
			    <i class="material-icons text-info" style="font-size: 128px">account_box</i>
			  </c:otherwise>
			</c:choose>
		</div>
		<form action="employee/upload/${staff.staffId}" id="form" method="post" enctype="multipart/form-data">
			<input id="file" class="d-none" type="file" name="photo" accept="image/png, image/jpeg" onchange="document.getElementById('form').submit()">
			<button type="button" class="btn btn-primary form-control mt-2" onclick="document.getElementById('file').click()" >
				<i class="material-icons" >add_a_photo</i>
			</button>
		</form>
	</div>
	<fieldset class="border p-2 col-9" >
	<legend class="w-auto">Profile</legend>		
	<div class=" row">
		<div class="col-6">
			<p><strong>Id:</strong> ${staff.staffId}</p>
			<p><strong>FullName:</strong> ${staff.fullname}</p>
			<p><strong>Gender:</strong> ${staff.gender?'Nam':'Nữ'}</p>
		</div>
		<div class="col-6">
			<p><strong>Birthday:</strong> ${staff.birthday}</p>
			<p><strong>Salary:</strong><f:formatNumber value="${staff.salary}" type="currency" currencySymbol = "đ" maxFractionDigits="0"/></p>
			<p><strong>Email:</strong> ${staff.email}</p>
		</div>
	</div>
	<p><strong>Notes:</strong> ${staff.notes}</p>
	</fieldset>	
</div>

<div class="table-responsive">
   	<table class="table table-hover">
	     <thead class="bg-info text-light">
			<tr>
				<th>Record_Id</th>
				<th>Record_Type</th>
				<th>Record_Date</th>
				<th>Reason</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="r" items="${records}">
			<tr>
				<td>${r.recordId}</td>
				<td>${r.recordType?'khen thưởng':'kỷ luật'}</td>
				<td>${r.recordDate}</td>	
				<td>${r.reason}</td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
