<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!-- Phần nội dung -->
<span class="text-danger"><s:message code="${message}" text=" "/></span>
<div class="p-2">
<table class="table table-hover">
	<thead class="bg-danger text-light">
		<tr>
			<th>Record_Id</th>
			<th>Record_Type</th>
			<th>Staff</th>
			<th>Record_date</th>
			<th>Reason</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="rec" items="${records}">
		<tr>
			<td>${rec.recordId}</td>
			<td class=""><i class="material-icons ${rec.recordType==0?'text-primary':'text-danger'}">flag</i></td>
			<td>${rec.staff.fullname}</td>
			<td>${rec.recordDate}</td>
			<td>${rec.reason}</td>
		<td>
			<a href="record/record-form/${rec.recordId}.html" class="btn btn-danger d-inline-flex" title="Edit this record">
				<i class="material-icons">edit</i>
			</a>
			|
		 	<a href="record/delete/${rec.recordId}.html" class="btn btn-danger d-inline-flex" title="Delete this record">
				<i class="material-icons">delete_forever</i>
			</a>
		</td>
			
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
