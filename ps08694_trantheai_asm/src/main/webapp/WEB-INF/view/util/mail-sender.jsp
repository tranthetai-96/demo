<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>

<!-- Phần nội dung -->
${message}
<form action="lab5/send-mail.html" method="post">
	<p><input name="to" placeholder="To"></p>
	<p><input name="subject" placeholder="Subject"></p>
	<p><textarea name="body" placeholder="Body" rows="3"
	cols="30"></textarea></p>
	<button>Send</button>
</form>
