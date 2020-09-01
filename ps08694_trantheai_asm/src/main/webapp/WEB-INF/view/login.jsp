<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<base href="${pageContext.servletContext.contextPath}/">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link href="https://fonts.googleapis.com/css?family=Sanchez&display=swap" rel="stylesheet">
	<title>login page</title>
	<style type="text/css">
		html, body{
			height: 100%;
			background: rgb(2,0,36);
			background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%);
		}
		.login-panel{
			height: auto;
			width: 800px;
			background-color: #fefefe;
		}
		.border-5 {
     		border-width:15px !important;
		}
		.zoom{
		  -webkit-animation-name: zoom; /* Safari 4.0 - 8.0 */
		  -webkit-animation-duration: 0.75s; /* Safari 4.0 - 8.0 */
		  animation-name: zoom;
		  animation-duration: 0.75s;
		}
		input[type="text"], input[type="password"]{
			
			width: 100%;
			border: none;
			outline: none;
			border-bottom: 2px solid #666666;
			border-radius: 2px;
		}
		.input-wrapper{
			position: relative;
			height: 28px;
			width: 100%;
		}
		.focus-input{
			position: absolute;
			top: 0px;
			left: 0px;
			width: 100%;
			height: 100%;
			pointer-events: none;
		}
		.focus-input::before{
			content: "";
			display: block;
			position: absolute;
			left: 0px;
			bottom: 0px;
			height: 2px;
			width: 0px;
			background: #faa719;
			transition: all 0.5s;
		}
		.focus-input::after{
			content: attr(data-placeholder);
			font-size: 18px;
			display: block;
			position: absolute;
			left: 0px;
			top: 0px;
			width: 100%;
			color: #888;
			transition: all 0.5s;
		}
		.has-val + .focus-input::after {
		  top: -20px;
		  font-size: 16px;
		}
		.textInput:focus + .focus-input::before{
			width: 100%;

		}
		.textInput:focus + .focus-input::after{
			top:-20px;
			font-size: 16px;
			color: #28a745;
		}
		.myQuote {
		  color: #666;
		  font-family: 'Roboto', serif;
		  font-weight: 100;
		  font-size: 1.2em;
		}
		blockquote::before{
			content: '\201C';
		}
		blockquote::after{
			content: '\201D';
		}
		@keyframes zoom{
			from{
				transform: scale(0);
			}
			to{
				transform: scale(1);
			}
		}
	</style>
</head>
<body>
<div class="container-fluid h-100">
	<div class="row h-100 d-flex justify-content-center">			
			<div class="col-md-12 col-lg-4 mt-lg-5 mt-md-0 mb-lg-5 mb-md-0 p-0">
				<div class="bg-light p-4 w-100 h-100">
				<div class="d-flex text-center justify-content-center align-items-end mb-4">
					<img src="images/icons/iconfinder_lock_299105.png"> 
					<span class="d-inline-block text-success text-uppercase font-weight-bold" style="font-size: 24px;">ĐĂNG NHẬP</span>
				</div>
				<form action="signin.html" method="POST">
					<div class="input-wrapper">
						<input type="text" name="username" class="textInput" required>
						<span class="focus-input" data-placeholder="Username" ></span>
					</div>
					<br /><br />
					<div class="input-wrapper">
						<input type="password" name="password" class="textInput" required>
						<span class="focus-input" data-placeholder="Password"></span>
					</div><br />
					<label class="float-right"><input type="checkbox" name="chkRemember"  /> Remember me</label>
					<br />
					<br />
					<button class="btn btn-success form-control">Đăng nhập</button><br /><br />
					<button class="btn btn-primary form-control">Tạo tài khoản mới</button>
					
				</form>
				<p class="text-danger mt-2">${message}</p>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function onBlur(element) {

		   if(element.value){
		   		element.classList.add('has-val');
		   }else{
		   		element.classList.remove('has-val');
		   }
		   
		};
		document.addEventListener("load",() => {
			var inputs = document.getElementsByClassName('textInput');
			[...inputs].forEach((input) => {
				input.onblur = () => {
					   if(input.value){
		   					input.classList.add('has-val');
					   }else{
					   		input.classList.remove('has-val');
					   }	
				};
			});
		}, true);
	</script>
</body>
</html>