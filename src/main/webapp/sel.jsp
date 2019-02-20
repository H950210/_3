<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-01-19
  Time: 上午 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<div id="mm">${m}</div>
<form action="select">
    <table border="1">
    <div>
        <tr>
            <td colspan="6">俱乐部会员信息</td>
        </tr>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>家庭住址</td>
            <td>电子邮箱</td>
        </tr>
        <c:forEach items="${list}" var="f">
        <tr>
            <td><a href="update?type=sel&id=${f.mid}">${f.mid}</a></td>
            <td>${f.mname}</td>
            <td>${f.mgender}</td>
            <td>${f.mage}</td>
            <td>${f.maddress}</td>
            <td>${f.memail}</td>
        </tr>
        </c:forEach>
    </div>
    </table>
</form>
</body>
</html>
