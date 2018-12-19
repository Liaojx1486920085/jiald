<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    $(function () {
        $("#name").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#score").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//数字验证
        });
        $("#brodecast").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#author").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#description").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入状态1或2...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#status").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });

    });
</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="fl" method="post" enctype="multipart/form-data">
            <div style="margin-top:10px">
                专辑名称: <input id="name" name="name"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                专辑分数: <input id="score" name="score"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                播音人 : <input id="brodecast" name="brodecast"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                作 者: <input id="author" name="author"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                简 介: <input id="description" name="description"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片状态: <input id="status" name="status"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                上传封面: <input onchange="view_photo()" name="picPathUpdate" id="file" type="file"
                             name="file"/><br/><span></span>
            </div>
            <div style="margin-top:10px" id=im>
                图片预览: <img id="img"/>
            </div>

        </form>
    </center>
</div>
 