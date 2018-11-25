<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 21.11.18
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Add Performer</title>
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
    <form class="form-control" method="post">
        <select name="performerList" class="form-control">
            <c:forEach items="${performerList}" var="performer" varStatus="count">
                <option value="${performer.id}">${performer.performerName}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-primary btn-medium">Submit</button>
        <sec:csrfInput/>
    </form>
</div>


<%--
    <form:form method="POST" modelAttribute="performers" class="form-signin">
        <div class="container">
            <form:select path="performers">&lt;%&ndash; class="form-control"&ndash;%&gt; method="POST" modelAttribute="performers" >
                <c:forEach items="${performers}" var="performer" varStatus="vs">
                    <form:options value="<c:out value='${performer.performerName}' />"/>
                        <c:if test="${param.selectValue == performer.performerName})"> selected </c:if>  >
                        <c:out value="${performer.performerName}" />
                </c:forEach>
            </form:select>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </div>
    </form:form>

</div>--%>

</body>
</html>
