<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 18.11.18
  Time: 20:38
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
    <title>Create Event</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/navbar-top.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .container{
            padding-top: 40px;
        }
    </style>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="/events">Festivals</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">My Festivals</a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="#">My account</a>
                </li>
                <li class="nav-item">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <a class="nav-link" onclick="document.forms['logoutForm'].submit()" <%--href="#"--%>>Logout</a>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a class="nav-link" href="/login">Login</a>
                </li>
            </sec:authorize>

        </ul>
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <form:form method="POST" modelAttribute="eventForm" class="form-signin">
        <h2 class="form-signin-heading">Create event</h2>
        <spring:bind path="eventName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="eventName" class="form-control" placeholder="Name of the Event"
                            autofocus="true"></form:input>
                <form:errors path="eventName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="date">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="date" class="form-control" placeholder="Date of the Event"></form:input>
                <form:errors path="date"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="deadlineDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="deadlineDate" class="form-control" placeholder="Deadline Date"></form:input>
                <form:errors path="deadlineDate"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="type">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="type" class="form-control" placeholder="Type of event"></form:input>
                <form:errors path="type"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="placeName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="placeName" class="form-control" placeholder="Place Name"></form:input>
                <form:errors path="placeName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="summary">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:textarea path="summary" class="form-control" rows="6" placeholder="Enter Event Summary"/>
                <%--<form:input type="text" path="summary" class="form-control" placeholder="sum"></form:input>--%>
                <form:errors path="summary"></form:errors>
            </div>
        </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="${contextPath}/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="${contextPath}/resources/js/popper.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
</html>
