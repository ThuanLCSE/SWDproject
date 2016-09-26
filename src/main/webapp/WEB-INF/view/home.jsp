<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Blog</title>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<h3>Welcome to system ${sessionScope.fullname}</h3>
, xem profile user, xem blog của tôi, khung search blog + nút search blog,

<form action="/listBlog" method="get">
    <input type="submit" value="View all Blogs"/>
</form>

<form action="/listBlog" method="get">
    <input type="hidden" name="id" value="${sessionScope.userId}"/>
    <input type="submit" value="View my blogs"/>
</form>

<form action="/profile" method="get">
    <input type="hidden" name="id" value="${sessionScope.userId}"/>
    <input type="submit" value="View my profile"/>
</form>

<form action="/logout" method="get">
    <input type="submit" value="Log out"/>
</form>

<form action="/listBlog" method="post">
    Category
  <input type="submit" value="Search"/>
</form>

</body>
</html>