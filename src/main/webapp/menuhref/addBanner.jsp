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
        // $("#file").filebox({
        //     width:300,		   //图标宽
        //     height:40,		   //图标高
        //     prompt:'                            请上传图片...',//请输入密码
        //     iconAlign:'left',  //图标靠左
        //     iconWidth:35,	   //图标宽度
        //     required: true,    //不为空验证
        //     validType: 'image',//密码验证
        // });
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
            validType: 'CHS',//密码验证
        });
        // $("#img").imgbox({
        //     width:300,		   //图标宽
        //     height:40,		   //图标高
        //     prompt:'请输入图片描述...',//请输入密码
        //     iconAlign:'left',  //图标靠左
        //     iconWidth:35,	   //图标宽度
        //     required: true,    //不为空验证
        //     validType: 'CHS',//密码验证
        // });
    });
    <%--function imges(thisObj,thisEvent) {--%>

    <%--var file = $("#file").val();--%>
    <%--var strFileName=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀--%>
    <%--var FileExt=file.replace(/.+\./,"");   //正则表达式获取后缀--%>
    <%--$("#img").attr("src",${pageContext.request.contextPath}+"/picture/"+strFileName+FileExt);--%>
    <%--}--%>
</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="fh" method="post" enctype="multipart/form-data">


            <div style="margin-top:10px">
                图片名称: <input id="picName" name="picName"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片状态: <input id="status" name="status"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                图片描述: <input id="description" name="description"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                上传图片: <input onchange="view_photo()" name="picPathUpdate" id="file" type="file"
                             name="file"/><br/><span></span>
            </div>
            <div style="margin-top:10px" id=im>
                图片预览: <img id="img" style="width: 100%;height: 100%"/>
            </div>

        </form>
    </center>
</div>
 