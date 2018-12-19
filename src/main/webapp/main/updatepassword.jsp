<%@ page language="java" pageEncoding="utf-8" %>


<script type="text/javascript">
    $(function () {
        $("#password").passwordbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入密码...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'pwd',//密码验证
        });
        $("#passwordes").passwordbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请再次输入密码...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'cofirmPwd[$("#password")]',//密码验证
        });

    });

</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="ff" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;新密码: <input id="password" name="password"/><br/>
            <div style="margin-top:10px">
                确认密码: <input id="passwordes" name="passwordes"/><br/>
            </div>

        </form>
    </center>
</div>
 