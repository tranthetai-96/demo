<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<!-- Phần nội dung -->
<fieldset class="border p-2" style="border-width: 2px;">
<legend class="w-auto">Account Profile</legend>
<div class="row">
	<div class="col-md-3 col-sm-12">
		<div class="p-2 d-flex flex-sm-column flex-sm-row align-content-center" >
			<div class="text-center w-100 h-auto" >
			<c:choose>
			  <c:when test="${user.img.length() > 0}">
			    <img class="rounded" alt="Avatar" src="images/avatar/${user.img}" width="128px" height="128px">
			  </c:when>
			  <c:otherwise>
			    <i class="material-icons text-info" style="font-size: 128px">account_box</i>
			  </c:otherwise>
			</c:choose>
			</div>
			<form action="account/upload/${user.username}" id="form" method="post" enctype="multipart/form-data">
				<input id="file" class="d-none" type="file" name="photo" accept="image/png, image/jpeg" onchange="document.getElementById('form').submit()">
				<button type="button" class="btn btn-primary form-control mt-2" onclick="document.getElementById('file').click()" >
					<i class="material-icons" >add_a_photo</i>
				</button>
			</form>
		</div>
	</div>
	<div class="col-md-9">
		<p><strong>Username:</strong> ${user.username}</p>
		<p><strong>Password:</strong> ${user.password}</p>
		<p><strong>Fullname:</strong> ${user.fullname}</p>
		<p><strong>Photo Name:</strong> ${user.img}</p>
	</div>
</div>
</fieldset>

