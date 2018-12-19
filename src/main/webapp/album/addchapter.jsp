<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript">
    $(function () {

        $("#sel").combobox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入图片描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#picPathUpdate").filebox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请选择专辑描述...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            accept: '.mp3'
        });

    });
</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="fv" method="post" enctype="multipart/form-data">
            <div style="margin-top:10px">
                &nbsp;&nbsp;专辑选择：
                <select id="sel" class="easyui-combobox" style="width: 300px;height: 40px " name="AlbumId">
                    <c:forEach items="${sessionScope.albums}" var="var">
                        <center>
                            <option class='easyui-linkbutton' data-options="iconCls:man ;plain:true"
                                    style='margin:5px 0px 5px 0px; border:1px #0b93d5 solid;width:90%;align-content: center'
                                    value='${var.id}'>${var.name}</option>
                            <br/></center>
                    </c:forEach>
                </select>
            </div>
            <div style="margin-top:10px">
                上传音乐: &nbsp;&nbsp;&nbsp;&nbsp;<input name="picPathUpdate" id="picPathUpdate"
                                                     type="text"/><br/><span></span>
            </div>


        </form>
    </center>
</div>
 