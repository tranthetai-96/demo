<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!-- Phần nội dung -->

<span class="text-danger"><s:message code="${message}" text=" "/></span>
<table class="table table-hover">
	<thead class="bg-info text-light">
		<tr>
			<th>Depart_Id</th>
			<th>Depart_Name</th>
			<th>Status</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="d" items="${departs}">
		<tr>
			<td>${d.departId}</td>
			<td>${d.name}</td>
			<td>${d.status?'Ngừng hoạt động':'Đang hoạt động'}</td>
		<td>
			<a href="depart/depart-form/${d.departId}.html" class="btn btn-danger d-inline-flex" title="Update this department">
				<i class="material-icons">edit</i>
			</a>
			|
		 	<a href="depart/delete/${d.departId}.html" class="btn btn-danger d-inline-flex" title="Delete this department">
				<i class="material-icons">delete_forever</i>
			</a>

		</td>
			
		</tr>
	</c:forEach>
	</tbody>
</table>

