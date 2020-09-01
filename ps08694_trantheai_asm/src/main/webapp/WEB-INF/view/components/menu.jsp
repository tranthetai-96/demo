<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="list-group">
	   <div class="list-group-item list-group-item-action list-group-item-success d-inline-flex">
	   		<i class="material-icons text-success">perm_identity</i>&nbsp;
	   		<s:message code="global.menu.user" /> 
	   </div>
       <div class=" border-right border-left">
       	<a href="user/user-form.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.user.add" /></a>
       	<a href="user/user-mgr.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.user.users" /></a>
       </div>
       
       <div class="list-group-item list-group-item-action list-group-item-primary d-inline-flex">
       		<i class="material-icons text-primary">people_alt</i>&nbsp;
       		<s:message code="global.menu.staff" />
       </div>
       <div class="border-right border-left">
       	<a href="staff/staff-form.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.staff.add" /></a>
       	<a href="staff/staff-mgr.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.staff.staffs" /></a>
       </div>
       
       <div class="list-group-item list-group-item-action list-group-item-info d-inline-flex">
       		<i class="material-icons text-info">domain</i>&nbsp;
       		<s:message code="global.menu.depart" />
       </div>
       <div class="border-right border-left">
       	<a href="depart/depart-form.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.depart.add" /></a>
       	<a href="depart/depart-mgr.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.depart.departs" /></a>
       </div>
       
       <div class="list-group-item list-group-item-action list-group-item-danger d-inline-flex">
       		<i class="material-icons text-danger">emoji_events</i>&nbsp;
       		<s:message code="global.menu.record" />
       </div>
       <div class="border-right border-left">
       	<a href="record/record-form.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.record.add" /></a>
       	<a href="record/record-mgr.html" class="d-block  p-2 pl-3 bg-light"><s:message code="global.menu.record.records" /></a>
       </div>
</div>
