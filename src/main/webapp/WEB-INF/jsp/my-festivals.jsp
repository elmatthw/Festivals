<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 25.11.18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>My festivals</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/navbar-top.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .festivals{
            padding-top: 60px;
            padding-left: 40px;
            width: 700px;
        }
    </style>
</head>
<body>

<jsp:include page="nav-bar.jsp"/>
<sec:authorize access="isAuthenticated()">
    <form method="GET" class="festivals">
        <c:forEach items="${events}" var="event" varStatus="vs">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">${event.eventName}</div>
                    <div class="col-sm-4">${event.date}</div>
                </div>
                <br>
                <button class="btn btn-default" onclick="location.href='#';">Cancel</button>
            </div>
            <hr>
        </c:forEach>

    </form>
</sec:authorize>


<sec:authorize access="!isAuthenticated()">
    <form method="POST" class="form-signin">
        <h2 class="form-heading">Enter your email</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </div>

    </form>
</sec:authorize>
</body>
</html>
