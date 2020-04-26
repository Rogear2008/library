<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/22
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>系统主页</title>
    <jsp:include page="views/jqueryHead.jsp"/>
    <jsp:include page="login_check.jsp"/>
    <script>
        function addTab(text,url,iconCls){
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"+ url +"'></iframe>";
            $("#tabs").tabs("add",{
                title:text,
                iconCls:iconCls,
                closable:true,
                content:content
            });
        }

        function openTab(text,url,iconCls){
            if ($("#tabs").tabs("exists",text)){
                $("#tabs").tabs("close",text);
            }
            addTab(text,url,iconCls);
            $("#tabs").tabs("select",text);
        }

    </script>

</head>
<body class="easyui-layout">
<div region="north" style="height:50px;background-color: #95B8E7">
    <table style="width:100%">
        <tr>
            <td style="width:50%"></td>
            <td valign="bottom" style="font-size:20px;color:#8B8B8B;font-family: 楷体;"align="right" whidth="50%">
                <font size="3"><strong>当前管理员：</strong> ${currentUser.username}</font><br/>
                <a href="${pageContext.request.contextPath}/logOut" class="easyui-linkbutton">退出</a>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div id="tabs" class="easyui-tabs" fit="true">
        <div title="主页" data-options="closable:true">
            <p>Hello World !</p>
        </div>
    </div>
</div>
<div region="west" style="width:200px;" title="导航菜单" split="true">
    <div class="easyui-accordin">
        <div title="用户管理" data-options="selected:true,iconCls:'icon-users'" style="height:10px">
            <a href="javascript:openTab(' 用户管理','user.jsp','icon-lxr')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-user'">查看用户</a>
        </div>
    </div>
</div>

</body>
</html>
