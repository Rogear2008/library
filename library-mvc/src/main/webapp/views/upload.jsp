<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/24
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <jsp:include page="jqueryHead.jsp"/>
</head>
<body>
<div>
    <form method="post" id="file" action="" enctype="multipart/form-data">
            <h3>选择一个文件:</h3>
            <input id="excelFile" type="file" name="file" />
            <br/><br/>
        <a href="javascript:uploadFiles()" class="easyui-linkbutton">上传</a>
    </form>
</div>
</body>
<script type="text/javascript">
    function uploadFiles(){
// 	var uploadFile = $('#excelFile').get(0).files[0];
        var uploadFile = new FormData($("#file")[0]);
        console.log(uploadFile);
        if("undefined" != typeof(uploadFile) && uploadFile != null && uploadFile != ""){
            $.ajax({
                url:'${pageContext.request.contextPath}/uploadPic',
                type:'POST',
                data:uploadFile,
                async: false,
                cache: false,
                contentType: false, //不设置内容类型
                processData: false, //不处理数据
                success:function(data){
                    console.log(data);
                    alert(data);
                },
                error:function(){
                    alert("上传失败！");
                }
            })
        }else {
            alert("选择的文件无效！请重新选择");
        }
    }
</script>
</html>
