<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- Phần nội dung -->
<span class="text-danger"><s:message code="${message}" text=" "/></span>

<form:form class=""  action="depart/save.html" modelAttribute="department" method="POST">
		<fieldset class="border p-2" style="border-width: 2px;">
			<legend class="w-auto"><s:message code="global.fieldset.legend.title" /></legend>
			<div class="form-group">
				<label>Department Id:</label>
				<form:input path="departId" cssClass="form-control" readonly="${isEdit?true:false}"/>
				<form:errors path="departId"/>
			</div>
			<div class="form-group">
				<label>Department Name:</label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name"/>
			</div>
			<div class="form-group">
				<label>Status:</label>
				<form:select path="status">
					<form:option value="0" >Đang hoạt động</form:option>
					<form:option value="1">Ngừng hoạt động</form:option>
				</form:select>
			</div>
			<div>
				<button class="btn btn-info form-control" >Submit</button>
			</div>
		</fieldset>
</form:form>
