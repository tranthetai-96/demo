<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!-- Phần nội dung -->
<span class="text-danger"><s:message code="${message}" text=" "/></span>

	<form:form action="user/save.html" modelAttribute="user" method="POST">
		<fieldset class="border p-2">
			<legend class="w-auto"><s:message code="global.fieldset.legend.title" /></legend>
			<form:hidden path="img" />
			<div class="form-group">
				<label>Username</label>
				<form:input path="username" cssClass="form-control" readonly="${isEdit?true:false}" />
				<form:errors path="username"/>
			</div>
			<div class="form-group">
				<label>Password</label>
				<form:input path="password" cssClass="form-control"/>
				<form:errors path="password"/>
			</div>
			<div class="form-group">
				<label>Fullname</label>
				<form:input path="fullname" cssClass="form-control"/>
				<form:errors path="fullname"/>
			</div>
			<div>
				<button class="btn btn-info form-control" >Submit</button>
			</div>
		</fieldset>
	</form:form>

