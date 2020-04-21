<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/21
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.3.3/themes/default/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        function saveUser(){

        }
    </script>

    <title>Title</title>
</head>
<body>
<div id="dlg" class="easyui-dialog">
    <form id="userForm" method="post" action="/library/user/insert">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input id="username" name="username" type="text" class="easyui-validatebox" required="true"></td>
            </tr>
            <tr>
                <td>密  码：</td>
                <td><input id="password" name="password" type="password" class="easyui-validatebox" required="true"></td>
            </tr>
        </table>
    </form>
</div>
<div id="dialog-button">
    <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
</div>

</body>
</html>
