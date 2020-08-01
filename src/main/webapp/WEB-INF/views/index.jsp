<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 25-Jul-20
  Time: 08:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
    <title>hi</title>
</head>
<body>

<div class="login">
    <h1>Login</h1>
    <form method="post">
        <input type="text" name="u" placeholder="Username" required="required" />
        <input type="password" name="p" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
        <%--<button type="submit" class="btn btn-primary btn-block btn-large">Let me up.</button>--%>

    </form>
    <button onclick="location.href='/registration'" class="btn-primary btn-block btn-large">Registration</button>
</div>
</body>
</html>
