<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="css/login.css" type="text/css"></link>
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/black/easyui.css">
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/icon.css">
    <script type="text/javascript" src="EasyUI/jquery.min.js"></script>
    <script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="EasyUI/form.validator.rules.js"></script>
    <script type="text/javascript" src="EasyUI/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        $(function () {
            <!--点击更换验证码-->
            $("#captchaImage").click(function () {
                $("#captchaImage").attr("src", "${pageContext.request.contextPath}/CreateVcodeController/getVcode?t=" + Math.random())
            })

        });

        function log() {
            $("#loginForm").form('submit', {
                url: "${pageContext.request.contextPath}/admin/selectAdmin",
                success: function (date) {
                    if (date == null || date == "") {
                        location.href = "${pageContext.request.contextPath}/main/main.jsp"
                    } else {
                        var json = $.parseJSON(date);
                        $("#h4").html(json.text);
                    }
                }

            });

        }


    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input id="name" type="text" name="name" class="text" value="xxx" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input id="password" type="password" name="password" class="text" value="xxx" maxlength="20"
                           autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage"
                         src="${pageContext.request.contextPath}/CreateVcodeController/getVcode" title="点击更换验证码"/>
                    <h4 style="color: #0b93d5" id="h4"></h4>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value=""><input onclick="log()" type="button"
                                                                            class="loginButton" value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
        0
    </form>
</div>
</body>
</html>