<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet"></link>
	<link href="/resources/css/font-awesome.min.css" rel="stylesheet"></link>
	<link href="/resources/css/custom.css" rel="stylesheet"></link>
</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
            	<div class="login-form">
					<form action="/login" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
        					<div class="alert alert-danger">
            					<p>Invalid username and password.</p>
				        	</div>
				   		</c:if>
				   		<c:if test="${param.logout != null}">
				        	<div class="alert alert-success">
				            	<p>You have been logged out successfully.</p>
				        	</div>
				        </c:if>
				        <div class="input-group input-sm">
				      		<label class="input-group-addon" for="username"><i class="fa fa-user" aria-hidden="true"></i></label>
				            <input type="text" class="form-control" id="username" name="userName" placeholder="<spring:message code='login.username.placeholder'/>" required>
				        </div>
				        <div class="input-group input-sm">
				       		<label class="input-group-addon" for="password"><i class="fa fa-lock" aria-hidden="true"></i></label> 
				       		<input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code='login.password.placeholder'/>" required>
				       	</div>
				       	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				        <div class="form-actions input-sm">
				        	<input type="submit" class="btn btn-block btn-primary btn-default" value="<spring:message code='login.button'/>">
				        </div>
				        <div class="input-sm text-right" style="margin-top:15px">
				        	<a href="/register"><spring:message code="login.register.link"/></a>
				        </div>
					</form>
				</div><!--./login-form-->
			</div><!--./login-card-->
		</div><!--./login-contrainer-->
	</div><!--./mainWrapper-->
</body>
</html>