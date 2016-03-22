<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()
            +":"+request.getServerPort()+path+"/";
%>
<c:set var="base" value="<%=basePath%>"/>
<html>
<body>

<h2>Hello World!</h2>
<c:out value="/login?userId=1"></c:out>
base:${base}
<a href="/login?userId=1">Login</a>
</body>
</html>
