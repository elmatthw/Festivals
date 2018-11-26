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
        .event-additional-info{
            font-size: 13px;
        }

    </style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/nav-bar.jsp"/>

<div class="container">
    <h2>${events.eventName}</h2>
    ${events.summary}
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
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.authorities" var="authorities" />
        <c:forEach items="${authorities}" var="authority" varStatus="vs">
            <c:if test="${authority=='ADMIN'}">
                <button class="btn btn-default" onclick="location.href='admin/show-event/add-performer?id=${events.id}';">Edit Performers</button>
            </c:if>
        </c:forEach>
    </sec:authorize>
</div>


</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="${contextPath}/resources/js/jquery-slim.min.js"><\/script>')</script>
<script src="${contextPath}/resources/js/popper.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

</html>
