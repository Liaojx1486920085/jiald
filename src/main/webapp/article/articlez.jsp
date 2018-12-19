<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    $(function () {
        $("#id").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#title").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//数字验证
        });
        $("#articlePic").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#content").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#publisTime").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入状态1或2...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#guruId").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });
        var r1 = $("#pl").edatagrid("getSelected");
        $('#pa').form('load', {
            id: r1.id,
            title: r1.title,
            articlePic: r1.articlePic,
            content: r1.content,
            publisTime: r1.publicTime,
            guruId: r1.guru.dharnaName,
        });

    });
</script>


<div id="articlezz">
    <center>
        <form id="pa">
            <div style="margin-top:10px">
                文章ID: <input id="id" disabled=“disabled” name="id"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                文章标题: <input id="title" disabled=“disabled” name="title"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                文章插图 : <input id="articlePic" disabled=“disabled” name="articlePic"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                文章内容: <input id="content" disabled=“disabled” name="content"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                文章日期: <input id="publisTime" disabled=“disabled” name="publisTime"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                所属上师: <input id="guruId" disabled=“disabled” name="guruId"/><br/><span></span>
            </div>
            <%--<div style="margin-top:10px" id = im>
                图片预览: <img id="img" src=""/>
            </div>--%>

        </form>
    </center>
</div>
 