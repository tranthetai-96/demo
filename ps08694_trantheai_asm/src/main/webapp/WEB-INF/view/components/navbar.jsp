<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<nav class="navbar navbar-expand-lg navbar-light bg-success position-relative border-bottom mb-1">
        <a class="navbar-brand" href="#"><img alt="logo" src="images/icons/logo.png" ></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link text-light" href="index.html"><s:message code="global.menu.home"/></a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="user/user-mgr.html"><s:message code="global.menu.user"/></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link text-light" href="staff/staff-mgr.html"><s:message code="global.menu.staff"/></a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="depart/depart-mgr.html"><s:message code="global.menu.depart"/></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link text-light" href="record/record-mgr.html"><s:message code="global.menu.record"/></a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="about.html"><s:message code="global.menu.about"/></a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
          	<div class="d-flex flex-column">
          		<div class="d-inline-flex mb-2">
          			<a class="text-light" href="index.html?lang=en">English</a>&nbsp; |&nbsp;
					<a class="text-light" href="index.html?lang=vi">Tiếng Việt</a>
          		</div>
          		<div class="d-inline-flex">
          			<input class="form-control mr-sm-2" type="search" placeholder="<s:message code="global.button.search"/>" aria-label="Search">
            		<button class="btn btn-primary my-2 my-sm-0" type="submit"><s:message code="global.button.search"/></button>
          		</div>
          	</div>
          </form>
          <div class="ml-3 " style="width: 64px; height: 66px;">
          	 <div class="w-100 h-100 btn-group">
				  <div class="position-relative btn  btn-group w-100 h-100 p-0 m-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <img alt="" src="images/avatar/${sessionScope.account.img}" class="position-absolute rounded-circle " style="width: 64px; height: 66px;left:0px;top:0px;">
				  </div>
				  <div class="dropdown-menu dropdown-menu-right mt-2">
				    <span class="dropdown-item bg-light"><s:message code="global.menu.dropdown.hello"/>, ${sessionScope.account.fullname}</span>
				    <a class="dropdown-item bg-light" href="user/profile/${sessionScope.account.username}.html"><s:message code="global.menu.dropdown.account"/> </a>
				    <div class="dropdown-divider"></div>
				    <a class="dropdown-item bg-light" href="signout.html"><s:message code="global.menu.dropdown.logout"/></a>
				  </div>
			  </div>
          </div>
        </div>
</nav>