<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-01-19
  Time: 上午 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
       $(function () {
           $("[type=submit]").click(function () {
               var xingming=$("#xingming").val();
               var xingbie=$("#xingbie").val();
               var xingbi=$("#xingbi").val();
               var nianling=$("#nianling").val();
               if (xingming=="" || xingbie=="" || xingbi=="" || nianling==""){
                   alert("不能为空");
                   return false;
               }
               return true;
           })
       })
    </script>
</head>
<body>
<form action="update?type=update" method="post">
    <table border="2">
        <div>
            <tr>
                <td colspan="2">会员信息</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" id="xingming" name="xingming" value="${info.mname}">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="xingbie" value="男" id="xingbie"
                           <c:if test="${info.mgender =='男'}">checked</c:if>/>男
                    <input type="radio" name="xingbie" value="女" id="xingbi"
                           <c:if test="${info.mgender =='女'}">checked</c:if>/>女
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <input type="text" id="nianling" name="nianling" value="${info.mage}">
                </td>
            </tr>
            <tr>
                <td>家庭住址</td>
                <td>
                    <input type="text" id="dizhi" name="dizhi" value="${info.maddress}">
                </td>
            </tr>
            <tr>
                <td>电子邮箱</td>
                <td>
                    <input type="text" id="youxiang" name="youxiang" value="${info.memail}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" value="${info.mid}" id="bianhao" name="bianhao">
                    <input type="submit" value="修改">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </div>
    </table>
</form>

</body>
</html>
