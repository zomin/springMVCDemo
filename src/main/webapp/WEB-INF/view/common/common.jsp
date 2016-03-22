<%--
  Created by IntelliJ IDEA.
  User: zhan005
  Date: 2016-03-22
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()
            +":"+request.getServerPort()+path+"/";
%>
<c:set var="base" value="<%=basePath%>"/>
