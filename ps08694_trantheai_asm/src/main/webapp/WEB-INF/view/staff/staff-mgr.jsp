<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<!-- Phần nội dung -->
<c:set var="currentPage" value="${pagination.currentPage}" />
<c:set var="endPage" value="${pagination.getPages()}" />
<hr>
<a href="staff/staff-mgr/edit.html?page=${currentPage }" class="btn btn-danger d-inline-flex"  title="Update a staff">
	<i class="material-icons" >edit</i>Edit
</a>
<a href="staff/staff-mgr/delete.html?page=${currentPage }" class="btn btn-danger d-inline-flex"  title="Delete a staff">
	<i class="material-icons" >delete_forever</i>Delete
</a>
<a href="staff/staff-mgr/profile.html?page=${currentPage }" class="btn btn-danger d-inline-flex"  title="Profile in detail">
	<i class="material-icons" >search</i>Detail
</a>
<hr>
<div class="table-responsive">
	<table class="table table-hover">
		<thead class="bg-primary text-light">
			<tr>
				<th>Staff_Id</th>
				<th>FullName</th>
				<th>Gender</th>
				<th>Birthday</th>
				<th>Email</th>
				<th>Salary</th>
				<th>Notes</th>
				<th>Photo</th>
				<c:choose>
					<c:when test="${action == 'edit'}"><th>Edit</th></c:when>
					<c:when test="${action == 'delete'}"><th>Delete</th></c:when>
					<c:when test="${action == 'profile'}"><th>Profile</th></c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="s" items="${staffs}">
			<tr>
				<td>${s.staffId}</td>
				<td>${s.fullname}</td>
				<td>${s.gender?'Nam':'Nữ'}</td>
				<td>${s.birthday}</td>
				<td>${s.email}</td>
				<td><f:formatNumber value="${s.salary}" type="currency" currencySymbol = "đ" maxFractionDigits="0"/></td>
				<td>${s.notes}</td>
				<td>${s.photo}</td>
				
				<c:choose>
				<c:when test="${action == 'edit'}">
				<td>
					<a href="staff/staff-form/${s.staffId}.html" class="btn btn-danger d-inline-flex mb-2" title="Update this staff">
						<i class="material-icons">edit</i>
					</a>
				</td>
				</c:when>
				<c:when test="${action == 'delete'}">
				<td>
					<a href="staff/delete/${s.staffId}.html" class="btn btn-danger d-inline-flex mb-2" title="Delete this staff">
						<i class="material-icons">delete_forever</i>
					</a>
				</td>
				</c:when>
				<c:when test="${action == 'profile'}">
				<td>
					<a href="staff/profile/${s.staffId}.html" class="btn btn-danger d-inline-flex mb-2" title="Detail">
						<i class="material-icons">search</i>
					</a>
				</td>
				</c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div>
		<ul class="pagination">
		  <li class="page-item ${currentPage == 1?'disabled':''}" ><a class="page-link" href="staff/staff-mgr?page=${currentPage - 1}" >Previous</a></li>
		  <c:forEach var="pageNumber" begin="1" end="${endPage}" step="1">
		  	<li class="page-item  ${currentPage == pageNumber?'active':''}"><a class="page-link" href="staff/staff-mgr?page=${pageNumber}">${pageNumber}</a></li>
		  </c:forEach>
		  <li class="page-item ${currentPage == endPage?'disabled':''}"><a class="page-link" href="staff/staff-mgr?page=${currentPage + 1}">Next</a></li>
		</ul>
	</div>
</div>
