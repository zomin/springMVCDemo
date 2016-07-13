<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()
            +":"+request.getServerPort()+path+"/";
%>
<c:set var="base" value="<%=basePath%>"/>
<script src="//g.alicdn.com/tmapp/tida2/2.0.141/tida.js?appkey=23405122"></script>
<script>
    Tida.ready({
       // interactId:"", // 互动实列ID type string 若无抽奖模块，此参数无须传入。给错误的实例ID会走错误流程
       // module: [] // 应用所需要的模块。非必选，默认加载所有模块。支持的模块见注释。
       sellerNick: "cfybwc",
       shopId:371812181 // 店铺ID 从url中取 可选
       },
       function(){
        alert(1);

    });




</script>
<html>
<body>

<h2>Hello World!</h2>
<c:out value="/login?userId=1"></c:out>
base:${base}
<a href="/login?userId=1">Login</a>
</body>
</html>
