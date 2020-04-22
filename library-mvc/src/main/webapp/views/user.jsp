<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/21
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <jsp:include page="jqueryHead.jsp"/>
    <script type="text/javascript">
        function saveUser(){

        }
    </script>

    <title>用户信息</title>
</head>
<body>
<table id="dg" title="用户信息" class="easyui-datagrid" pagenation="true" rownums="true" fit="true"
       data-options="method:'get'" url="${pageContext.request.contextPath}/user/selectByPage" >
    <thead>
    <tr>
        <td data-options="field:'ck',checkbox:true"></td>
        <td data-options="field:'id',width:50">用户ID</td>
        <td data-options="field:'username',width:50">用户名</td>
        <td data-options="field:'password',width:50">密  码</td>
        <td data-options="field:'lastUpdateTime',width:50">最后更新时间</td>
    </tr>
    </thead>
</table>

</body>
</html>
