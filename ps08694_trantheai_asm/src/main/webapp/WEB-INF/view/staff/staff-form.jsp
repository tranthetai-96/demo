<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- Phần nội dung -->
<span class="text-danger"><s:message code="${message}" text=" "/></span>
<form:form action="staff/save.html" modelAttribute="staff" method="POST">
<fieldset class="border p-2">
	<legend class="w-auto"><s:message code="global.fieldset.legend.title" /></legend>
	<form:hidden path="staffId"/>
	<div class="row">
		<div class="col-6">
			<div class="form-group">
				<label class="font-weight-bold">Fullname</label>
				<form:input path="fullname" cssClass="form-control"/>
				<form:errors path="fullname"/>
			</div>
			<div class="form-group" style="margin-bottom:22px">
				<label class="font-weight-bold">Gender</label><br>
				<form:radiobutton path="gender" label="Male" value="false"/>
				<form:radiobutton path="gender" label="Female" value="true"/>
			</div>
			<div class="form-group">
				<label class="font-weight-bold">Email</label>
				<form:input path="email" cssClass="form-control" type="email"/>
				<form:errors path="email"/>
			</div>
		</div>
		<div class="col-6">
			<div class="form-group">
				<label class="font-weight-bold">Birthday</label>
				<form:input path="birthday" cssClass="form-control" type="date" />
				<form:errors path="birthday"/>
			</div>
			<div class="form-group">
				<label class="font-weight-bold">Salary</label>
				<form:input path="salary" cssClass="form-control" type="number"  />
				<form:errors path="salary"/>
			</div>
			
		</div>
	</div>	
	<div class="form-group">
				<label class="font-weight-bold">Status</label>
				<form:select path="deleted">
					<form:option value="false" label="Đang làm việc" />
					<form:option value="true" label="Ngừng làm việc"/>
				</form:select>
	</div>
	<div class="form-group">
		<label class="font-weight-bold">Notes</label>
		<form:textarea path="notes"  rows="3" cssClass="form-control"/>
	</div>

	<div>
		<button class="btn btn-info form-control" >Submit</button>
	</div>
</fieldset>
</form:form>
