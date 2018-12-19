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
        $("#count").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });
        $("#publicTime").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });
        var row = $('#al').treegrid('getSelected');
        $('#pp').form('load', {
            name: row.name,
            score: row.score,
            brodecast: row.brodecast,
            author: row.author,
            description: row.description,
            publicTime: row.publicTime,
            count: row.count,
            status: row.status,
        });

    });
</script>


<div id="albumb">
    <center>
        <form id="pp">
            <div style="margin-top:10px">
                专辑名称: <input id="name" disabled=“disabled” name="name"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                专辑分数: <input id="score" disabled=“disabled” name="score"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                播音人 : <input id="brodecast" disabled=“disabled” name="brodecast"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                作 者: <input id="author" disabled=“disabled” name="author"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                简 介: <input id="description" disabled=“disabled” name="description"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                发布日期: <input id="publicTime" disabled=“disabled” name="publicTime"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                集 数: <input id="count" disabled=“disabled” name="count"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片状态: <input id="status" disabled=“disabled” name="status"/><br/><span></span>
            </div>
            <%--<div style="margin-top:10px" id = im>
                图片预览: <img id="img" src=""/>
            </div>--%>

        </form>
    </center>
</div>
 