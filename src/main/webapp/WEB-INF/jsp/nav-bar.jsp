<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elmatthw
  Date: 25.11.18
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="/events">Festivals</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.authorities" var="authorities" />
                <c:forEach items="${authorities}" var="authority" varStatus="vs">
                    <c:if test="${authority=='ADMIN'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/performers/admin/add-performer">Add Performer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/performers">All Performers</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#">Add Places</a>
                        </li>
                    </c:if>
                    <c:if test="${authority=='USER'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/my-festivals">My Festivals</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">My account</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
                    </li>
                </c:forEach>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/my-festivals">My Festivals</a>
                </li>
                <li>
                    <a class="nav-link" href="/login">Login</a>
                </li>
            </sec:authorize>

        </ul>
    </div>
</nav>
