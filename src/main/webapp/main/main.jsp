<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../EasyUI/themes/ui-cupertino/easyui.css">
    <link rel="stylesheet" type="text/css" href="../EasyUI/themes/icon.css">
    <script type="text/javascript" src="../EasyUI/jquery.min.js"></script>
    <script type="text/javascript" src="../EasyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../EasyUI/form.validator.rules.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.js"></script>
    <script type="text/javascript" src="../js/message_zh_CN.js"></script>
    <script type="text/javascript" src="../EasyUI/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var m = null;
        var j = null;
        <!--菜单处理-->
        $(function () {
            $.post("${pageContext.request.contextPath}/menu/selectMenu", function (result) {
                console.log(result);
                <!--一级遍历-->
                $.each(result, function (idx, menu) {
                    var content = "<div style='text-align: center'>";
                    <!--二级遍历-->
                    $.each(menu.menus, function (idx, menu1) {//idx:遍历下标    menu1:遍历的对象
                        var j = JSON.stringify(menu1)//转换json串才能当参数传出
                        content += "<a onclick='addtabs(" + j + ")' class='easyui-linkbutton' data-options=\"iconCls:'" + menu1.iconCls + "',plain:true\" style='margin:5px 0px 5px 0px; border:1px #0b93d5 solid;width:90%;'>" + menu1.title + "</a></br>";
                    });
                    content += "</div>"
                    $('#aa').accordion('add', {//添加一级菜单
                        title: menu.title,//标题
                        iconCls: menu.iconCls,//图标
                        content: content,
                    });
                });
            }, "JSON");


            $(".aa").css({
                "background-image": "url(${pageContext.request.contextPath}/picture/6c42c40ed54f4bb5ea491894aff693878afa6580.png)",
                "background-size": "100% 100%"
            })
            $("#ab").css({
                "background-image": "url(${pageContext.request.contextPath}/picture/08f98bb10251bb89461c0f3d50c864327b1ac05d.png)",
                "background-size": "100% 100%"
            })
            <!--首页-->
            $("#ac").css({
                "background-image": "url(${pageContext.request.contextPath}/picture/2018-12-06_213544.png)",
                "background-size": "100% 100%"
            })


            <!--系统退出窗口-->
            $("#exit").click(function () {
                $("#win").dialog({
                    title: '退出系统',	 //窗口标题
                    width: 200,		 //窗口宽
                    height: 120,		 //窗口高
                    resizable: true,  //窗口可拉伸
                    buttons: '#bb',	 //登录注册按钮
                    draggable: true,  //可拖拽窗口
                });
            })
            //增加Banner效验规则
            $("ff").validate({
                rules: {
                    picName: {required: true, minlength: 1, maxlength: 20},
                    uploadingimg: {required: true, minlength: 5, maxlength: 10},
                    status: {required: true, min: 1, max: 1},
                    description: {required: true, minlength: 2, maxlength: 300},
                },
                errorPlacement: function (error, element) {
                    element.next().append(error);
                    //element.before(error);
                }
            });


        })

        <!--确认退出系统-->
        function exitOk() {
            $("#win").dialog('close');//关闭添加窗口
            location.href = "${pageContext.request.contextPath}/login.jsp"//跳转
        }

        //修改密码窗口
        function updateAdmin() {
            $("#win2").dialog({
                title: '添加人员',	 //窗口标题
                minimizable: true,//窗口最小化
                minimizable: true,//窗口最大化
                width: 400,		 //窗口宽
                height: 200,		 //窗口高
                resizable: true,  //窗口可拉伸
                buttons: '#bb2',	 //登录注册按钮
                draggable: true,  //可拖拽窗口
                href: '${pageContext.request.contextPath}/main/updatepassword.jsp'
            });
        }

        //修改密码确定
        function updateOk() {
            $("#ff").form('submit', {
                url: "${pageContext.request.contextPath}/admin/updateAdmin",
                novalidate: true,//是否验证表单的字段
                ajax: true,//使用ajax
                success: function (data) {
                    $("#win2").dialog('close');//关闭添加窗口
                    var json = $.parseJSON(data);
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: json.text,//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                }
            });
        }

        //增加选项卡
        function addtabs(j) {
            var ex = $("#tt").tabs("exists", j.title);//判断选项卡是否重复
            if (!ex) {
                $('#tt').tabs('add', {
                    title: j.title,//标题
                    icon: j.iconCls,//图标
                    selected: false,//是否初始化选中
                    href: '${pageContext.request.contextPath}/' + j.href + '.jsp',
                    closable: true,//选项卡关闭
                });
            }
        }


    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" class="aa" style="height:100px; width: 100%">
    <div id="ab" class="ab" style="width: 220px ;height: 105px ; position: absolute;"></div>
    <div style="margin-left: 10px ; padding-top: 50px ; color: #FAF7F7;font-family: 楷体;float:right">
        欢迎您:${sessionScope.admin.name} &nbsp;<a href="#" onclick="updateAdmin()" class="easyui-linkbutton"
                                                data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a id="exit"
                                                                                                          href="#"
                                                                                                          class="easyui-linkbutton"
                                                                                                          data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 1px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">
    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div id="ac" title="主页" data-options="iconCls:'icon-neighbourhood'"></div>
    </div>
</div>
<div id="win" style="display: none">
    <h3>
        <center>确认退出本系统？</center>
    </h3>
</div>
<div id="bb" style="display: none">
    <a class="easyui-linkbutton" onclick="exitOk()">退出</a>
    <a href="javascript:;" class="easyui-linkbutton" onclick="closeWindow()">关闭</a>
</div>
<div id="win2" style="display: none">
</div>
<div id="bb2" style="display: none">
    <a class="easyui-linkbutton" onclick="updateOk()">确认</a>
    <a href="javascript:;" class="easyui-linkbutton" onclick="closeWindow2()">关闭</a>
</div>

</body>
</html>