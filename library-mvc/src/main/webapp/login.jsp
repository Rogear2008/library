<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/26
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<%--<div>--%>
<%--    <form id="fm" action="${pageContext.request.contextPath}/login" method="post">--%>
<%--        <input id="username" name="username" type="text"><br/>--%>
<%--        <input id="password" name="password" type="password">--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>
<%--</div>--%>
<form id="login" method="post" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <th height="150">&nbsp;</th>
        </tr>
        <tr style="height: 154px">
            <td>
                <div style="width: 936px">
                    <img src="${pageContext.request.contextPath}/images/login_1.jpg">
                </div>
                <div style="background-color: #278296">
                    <div style="width: 936px">
                        <div style="background: url(${pageContext.request.contextPath}/images/login_2.jpg) no-repeat;height: 155px">
                            <div style="text-align: left;width: 265px;float: right;height: 125px;">
                                <table border="0" width="100%" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td height="45">
                                            <input id="username" type="text" name="username">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="password" type="password" name="password">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div style="height: 1px"/>
                            <div style="width: 380px;float: right;clear: both">
                                <table width="300">
                                    <tr>
                                        <td width="100" align="right">
                                            <input id="btnLogin" src="${pageContext.request.contextPath}/images/btn_login.jpg" type="image"
                                                   name="btnLogin" onclick="javascript:login()">
                                        </td>
                                        <td width="100">
                                            <input id="btnReset" src="${pageContext.request.contextPath}/images/btn_reset.jpg" type="image"
                                            name="btnReset" onclick="javascript:reset()">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <div style="width: 936px">
                    <img src="${pageContext.request.contextPath}/images/login_3.jpg">
                </div>

            </td>
        </tr>
    </table>
</form>
</body>
</html>
