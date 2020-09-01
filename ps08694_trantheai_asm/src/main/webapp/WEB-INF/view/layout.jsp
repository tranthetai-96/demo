<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <base href="${pageContext.servletContext.contextPath}/">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style type="text/css">
		*[id$=errors]{
			color:red;
			font-style: italic;
		}
		.list-group a{
			text-decoration: none;
		}
		.disabled {
		    pointer-events:none; 
		    opacity:0.6;         
		}
	</style>
</head>
<body>
    <div class="container-fluid">
    <!-- Phần menu trên cùng -->
   	  <%@include file="/WEB-INF/view/components/navbar.jsp" %>

      <div class="row">
        <div class="col-3 ">
        	<!-- Phần menu đứng bên phải -->
            <%@include file="/WEB-INF/view/components/menu.jsp" %>
        </div>
        <div class="col-9 pl-0">
        	<!-- Phần nội dung -->
        	 
        	 <article class="">
        		<jsp:include page="${param.view}" />
        	</article>
        </div>
      </div>
    </div>
</body>
</html>