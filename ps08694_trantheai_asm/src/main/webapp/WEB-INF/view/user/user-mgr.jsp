<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!-- Phần nội dung -->

<span class="text-danger"><s:message code="${message}" text=" "/></span>
<table class="table table-hover p-0 rounded">
	<thead class="bg-success text-light">
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.username}</td>
		<td>${u.password}</td>
		<td>${u.fullname}</td>
		<td>
			<a href="user/user-form/${u.username}.html" class="btn btn-danger d-inline-flex" title="Update this user">
				<i class="material-icons">edit</i>
			</a>
			|
		 	<a href="user/delete/${u.username}.html" class="btn btn-danger d-inline-flex" title="Delete this user">
				<i class="material-icons">delete_forever</i>
			</a>
		</td>
			
		</tr>
	</c:forEach>
	</tbody>
</table>

