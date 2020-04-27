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
    <link rel="shortcut icon" href="#" />
    <title>用户信息</title>
</head>
<body>
<table id="dg" title="用户信息" class="easyui-datagrid" style="width:400px;height:250px"
<%--          pagenation="true" rownums="true" fit="true" pageNumber="1" pageSize="10"
        data-options="method:'get',url:'${pageContext.request.contextPath}/user/selectByPage',fitColumns:true,singleSelect:true,pageSize:10,pageNumber:1" --%>
       toolbar="#tb">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:50">用户ID</th>
        <th data-options="field:'username',width:50">用户名</th>
        <th field="imagePath" width="50" formatter="formatPic">头  像</th>
        <th data-options="field:'password',width:50">密  码</th>
        <th data-options="field:'lastUpdateTime',width:50">最后更新时间</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
        <a href="javascript:openUserUpdateDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        姓名：<input id="str" type="text" onkeyup="selectUser()"/> <a
            href="javascript:selectUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width: 850px;height: 555px;padding: 10px 20px;position: relative;z-index: 1000"
     closed="true" buttons="#dig-buttons">
    <form id="fm" method="post">
        <input id="id" type="hidden" name="id">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input id="username" type="text" name="username" class="easyui-checkbox easyui-validatebox" required="true"><font color="red">*</font></td>
            </tr>
            <tr>
                <td>密  码：</td>
                <td><input id="password" type="password" name="password" class="easyui-checkbox easyui-validatebox" required="true"><font color="red">*</font></td>
            </tr>
            <tr>
                <td>头像</td>
                <td><input id="file" type="file" name="file" class="easyui-checkbox">
                    <a href="javascript:uploadPic()" class="easyui-linkbutton">上传</a><br/>
<%--                    <img id="img" src="${pageContext.request.contextPath}/images/1.png"/>--%>
                <input id="imagePath" type="text" style="display: none" name="imagePath"></td>
            </tr>
        </table>
    </form>
</div>
<div id="dig-buttons">
    <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="111" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<script type="text/javascript">

    $("#dg").datagrid({
        method: 'get',
        // width: 'auto',
        // height: 800,
        url: '${pageContext.request.contextPath}/user/selectByPage',
        fitColumns: true,
        fit: true,
        singleSelect: true,
        pagination: true,
        rownumbers: true
    });

    var page = $("#dg").datagrid('getPager');
    $(page).pagination({
        pageSize: 10,
        pageNumber: 1
    });

    var url;
    function openUserAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle","新增用户");
        url = "${pageContext.request.contextPath}/user/insert";
    }

    function saveUser(){
        $("#fm").form("submit",{
            url:url,
            onSubmit:function () {
                return $(this).form("validate");
            },
            success:function (result) {
                if (result = "1"){
                    $.messager.alert("系统提示","保存成功！");
                } else {
                    $.messager.alert("系统提示","保存失败！");
                }
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");

            }
        })
    }

    function openUserUpdateDialog() {
        var selectedRows = $('#dg').datagrid('getSelections');
        if (selectedRows.length != 1){
            $.messager.alert("系统提示","请选择一条需要修改的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle","修改用户");
        $("#fm").form("load",row);
        url="${pageContext.request.contextPath}/user/update";
    }
    
    function deleteUser() {
        var selectedRows = $("#dg").datagrid("getSelections");
        if (selectedRows.length != 1){
            $.messager.alert("系统提示","请选择一条需要删除的数据！");
            return
        }
        var id = selectedRows[0].id;
        var data = JSON.stringify({'id':111});
        $.messager.confirm("系统提示","确认要删除这条数据吗？",
            function (r) {
                if (r){
                    $.ajax({
                        url:'${pageContext.request.contextPath}/user/deleteById/'+ id,
                        contentType:'application/json',
                        data:{abc:id},
                        type:'POST',
                        success:function (result) {
                            if (result == "1"){
                                $.messager.alert("系统提示","删除成功！");
                                $("#dg").datagrid("reload");
                            }else {
                                $.messager.alert("系统提示","删除失败！");
                            }
                        }
                    });
                }
            })
    }

    function selectUser(){
        var username = $("#str").val();
        $("#dg").datagrid("load",{
            "username":username
        })
    }

    function formatPic(val,row){
        if (null != val){
            return "<img src='${pageContext.request.contextPath}"+ val +"' width=100 height=100>"
        }
    }

    function uploadPic() {
        var formData = new FormData($("#fm")[0]);
        console.log("formData:"+formData);
        if ("undefined" != typeof(formData) && formData != null){
            $.ajax({
                url:'${pageContext.request.contextPath}/uploadPic',
                type:'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                    if (data != "0"){
                        $("#imagePath").val(data);
                        $.messager.alert("系统提示","图片上传成功");
                    } else {
                        $.messager.alert("系统提示","图片上传失败");
                    }
                },
                error: function () {
                    $.messager.alert("系统提示","图片上传失败");
                }
                }
            )
        } else {
            $.messager.alert("系统提示","数据异常");
        }
    }


</script>
</body>
</html>
