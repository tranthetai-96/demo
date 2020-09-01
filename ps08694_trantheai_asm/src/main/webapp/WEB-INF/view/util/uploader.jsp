<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Phần nội dung -->
<h2>NỘP ĐƠN XIN VIỆC</h2>
${message}
<form action="lab5/apply.html" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<div>Họ và tên ứng viên</div>
		<input type="text" name="txtName">
		</div>
		<div class="form-group">
		<div>Hình ảnh</div>
		<input type="file" name="photo">
		</div>
		<div class="form-group">
		<div>Hồ sơ xin việc</div>
		<input type="file" name="cv">
		</div>
		<div class="form-group">
		<button>Nộp</button>
	</div>
</form>	
