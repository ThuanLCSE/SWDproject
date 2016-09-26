<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My blog</title>
</head>
<body>
    <h2>Login your account</h2>
    <form action="/login" modelAttribute="user" method="post">
        <input type="text" path="username"/><br/>
        <input type="text" path="password"/><br/>
        <input type="submit" value="Log in"/>
    </form>
    <a href="/signup">Create a new account</a>

</body>
</html>