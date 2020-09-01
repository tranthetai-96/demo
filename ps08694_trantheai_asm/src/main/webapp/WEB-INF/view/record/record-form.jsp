<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- Phần nội dung -->
<span class="text-danger"><s:message code="${message}" text=" "/></span>
<form:form action="record/save.html" modelAttribute="record" method="POST">
<fieldset class="border p-2">
	<legend class="w-auto"><s:message code="global.fieldset.legend.title" /></legend>
	<form:hidden path="recordId"/>
	<div class="form-group">
		<form:select path="staff.staffId">
	     <form:option value="-1" label="--Please Select a employee"/>
	     <form:options items="${staffs}" itemValue="staffId" itemLabel="fullname"/>
		</form:select>
		<br>
		<span class="text-danger"><s:message code="${error_choose}" text=" "/></span>
    </div>
    
    <div class="form-group">
		<label><strong>Record Date:</strong></label>
		<br>
		<form:input path="recordDate"  type="date"  cssClass="form-control"/>
		<form:errors  path="recordDate"/>
	</div>
    
	<div class="form-group">
		<label><strong>Record Type:</strong></label>
		<br>
		<label><form:radiobutton path="recordType" value="0" checked="true"/> Praise</label>
		<label><form:radiobutton path="recordType" value="1"/> Discipline</label>
	</div>

	<div class="form-group">
		<label><strong>Reason:</strong></label>
		<br>
		<form:textarea path="reason" rows="3" cols="20" cssClass="form-control"/>
		<form:errors  path="reason"/>
	</div>

	<div>
		<button class="btn btn-info form-control" >Submit</button>
	</div>
</fieldset>
</form:form>
