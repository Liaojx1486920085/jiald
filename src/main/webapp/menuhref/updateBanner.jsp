<%@ page language="java" pageEncoding="utf-8" %>


<script type="text/javascript">
    $(function () {
        $("#picName").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });

        $("#status").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入状态1或2...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });
        $("#description").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            //validType: 'CHS',//密码验证
        });
        $("#createTime").datebox({
            required: true,		//不为空验证
            iconAlign: 'left',  //图标靠左
            width: 300,		   //图标宽
            height: 40,		   //图标高
            iconWidth: 35,	   //图标宽度
            prompt: '请选择日期...',//请输入用户名
            panelWidth: 200,
        });

        var ss = $("#pg").edatagrid("getSelected");
        $('#fq').form('load', {
            id: ss.id,
            picName: ss.picName,
            picPath: ss.picPath,
            description: ss.description,
            status: ss.status,
            createTime: ss.createTime,
            url: ss.url
        });
    })

</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="fq" method="post" enctype="multipart/form-data">

            <input style="display: none" id="id" name="id"/><br/><span></span>
            <div style="margin-top:10px">
                图片名称: <input id="picName" name="picName" value="阿111111"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片状态: <input id="status" name="status"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片描述: <input id="description" name="description"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                上传时间: <input type="date" id="createTime " name="createTime "/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                上传图片: <input onchange="view_photo()" name="picPathUpdate" id="file" type="file"
                             name="file"/><br/><span></span>
            </div>
            <div style="margin-top:10px" id=im>
                图片预览: <img id="img"/>
            </div>

        </form>
    </center>
</div>
 