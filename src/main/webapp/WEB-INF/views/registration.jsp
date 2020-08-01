<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Users: SergejK
  Date: 30-Jul-20
  Time: 09:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/JS/jquery.1.10.2.min" />"></script>
    <script src="<c:url value="/resources/JS/registration.js"/>"></script>
    <title>hi</title>
</head>
<body>
<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>


<nav>
    <a href="${pageContext.request.contextPath}/">
        <span>HOME</span>
    </a>
    <a href="#!">
        <span>A</span>
    </a>
    <a href="#!">
        <span>C</span>
    </a>
    <a href="#!">
        <span>F</span>
    </a>
</nav>


<div class="wrapper">
    <h1>Register For An Account</h1>
    <p>To sign-up for a free basic account please provide us with some basic information using
        the contact form below. Please use valid credentials.</p>

    <form class="form" method="post" action="${pageContext.request.contextPath}options/create">
        <input type="text" class="name" placeholder="Name" autocomplete="off" id="name" name="name">
        <div>
            <p class="name-help">Please enter your name.</p>
        </div>

        <input type="email" class="email" placeholder="Email" id="email" autocomplete="off" name="email">
        <div>
            <p class="email-help">Please enter your current email address.</p>
        </div>

        <input type="password" class="password" placeholder="password" id="password" autocomplete="off" name="password">
        <div>
            <p class="email-help">Please enter your password.</p>
        </div>

        <textarea hidden  name="regTime" type="text" id="current_date_time_block"></textarea>
        <input type="submit" class="submit" value="Register">

    </form>
    <%--<output name="regDate" style="color: #1A878F" id="current_date_time_block"></output>--%>
</div>
<p class="optimize">
    Optimized for Chrome & Firefox!
</p>
</body>
</html>
