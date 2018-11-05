<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register Page</title>
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet"></link>
	<link href="/resources/css/font-awesome.min.css" rel="stylesheet"></link>
	<link href="/resources/css/custom.css" rel="stylesheet"></link>
</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
            	<div class="login-form">
            		<form id="registerForm" action="/register" method="post" class="form-horizontal">
            			<div class="input-group input-sm">
				      		<label class="input-group-addon" for="username"><i class="fa fa-user fa-fw" aria-hidden="true"></i></label>
				            <input type="text" class="form-control" id="username" name="userName" placeholder="<spring:message code='register.username.placeholder'/>" required>
				        </div>
				        <div class="input-group input-sm">
				       		<label class="input-group-addon" for="password"><i class="fa fa-lock fa-fw" aria-hidden="true"></i></label> 
				       		<input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code='register.password.placeholder'/>" required>
				       	</div>
				       	<div class="input-group input-sm">
				       		<label class="input-group-addon" for="mobile-number"><i class="fa fa-phone-square fa-fw" aria-hidden="true"></i></label> 
				       		<input type="text" class="form-control" id="mobile-number" name="mobileNumber" placeholder="<spring:message code='register.mobile.placeholder'/>" required>
				       	</div>
				       	<div class="input-group input-sm">
				       		<input type="text" class="form-control" id="captcha" name="captcha" placeholder="<spring:message code='register.captcha.placeholder'/>" required>
				       		<span id="send-captcha" class="input-group-addon btn btn-primary"><spring:message code="register.captcha.button"/></span>
				       	</div>
				       	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />   
				        <div class="form-actions input-sm">
				        	<input type="submit" class="btn btn-block btn-primary btn-default" value="<spring:message code='register.button'/>">
				        </div>
				        <div class="input-sm text-right" style="margin-top:15px">
				        	<a href="/login"><spring:message code="register.login.link"/></a>
				        </div>
            		</form>
				</div><!--./login-form-->
			</div><!--./login-card-->
		</div><!--./login-contrainer-->
	</div><!--./mainWrapper-->
	<script src="/resources/js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="/resources/js/custom/register.js" type="text/javascript"></script>
</body>
</html>