<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 16.11.18
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${events.eventName}</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/navbar-top.css" rel="stylesheet">
    <style>
        .performer-style{
            color: #343a40;
            padding-left: 20px;
        }
        .performer-style:hover{
            color: black;
        }
        .performer-style a {
            text-decoration: none;
        }
        .container{
            padding-top: 40px;
        }
        .event-summary{
            font-size: 18px;
        }
        .event-additional-info{
            font-size: 13px;
        }
        .nav-link{
            padding: 0;
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
                    <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
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
    <h3>${events.eventName}</h3>
    <p class="event-summary">${events.summary}</p>
    <hr>
    <h4><small>Performers:</small></h4>
    <c:forEach items="${events.listOfPerformers}" var="performers" varStatus="vs">
        <a href="/performers/show-performer?id=${performers.id}" class="performer-style"> ${performers.performerName}</a>
        <br/>
    </c:forEach>
    <hr>
    <p class="event-additional-info">Where: ${events.place.placeName} <br/>
        Type: ${events.eventType.type} <br/>
        When: ${events.date} <br/>
        ${events.listOfParticipants.size()} have already signed up</p>
    <button class="btn btn-default" onclick="location.href='show-event/${events.id}/${pageContext.request.userPrincipal.name}';">Attend</button>
    <%--Для дисейблд кнопки
    <button type="button" class="btn btn-default disabled">Attend</button>--%>
    <sec:authentication property="principal.authorities" var="authorities" />
    <c:forEach items="${authorities}" var="authority" varStatus="vs">
        <c:if test="${authority=='ADMIN'}">
            <button class="btn btn-default" onclick="location.href='admin/show-event/add-performer?id=${events.id}';">Edit Performers</button>
        </c:if>
    </c:forEach>

</div>


</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="${contextPath}/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="${contextPath}/resources/js/popper.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

</html>
