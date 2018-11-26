<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 23.11.18
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
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
<!DOCTYPE html>
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
<jsp:include page="/WEB-INF/jsp/nav-bar.jsp"/>

<div class="container">
    <form:form method="POST" modelAttribute="performerForm" class="form-signin">
        <h2 class="form-signin-heading">Create event</h2>
        <spring:bind path="performerName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="performerName" class="form-control" placeholder="Performer Name"
                            autofocus="true"></form:input>
                <form:errors path="performerName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="summary">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:textarea path="summary" class="form-control" rows="6" placeholder="Enter Performer Summary"/>
                <form:errors path="summary"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>

</body>
</html>

