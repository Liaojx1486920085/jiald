<%@ page language="java" pageEncoding="utf-8" %>

<script type="text/javascript">
    //表格
    $("#pg").edatagrid({
        updateUrl: "${pageContext.request.contextPath}/banner/updateBanner",
        destroyUrl: "${pageContext.request.contextPath}/banner/deleteBanner",
        fit: true,//组件自适应父容器
        fitColumns: true,//自适应网格宽度
        autoRowHeight: true,//根据内容自定适应行的高度
        striped: true,//斑马线效果
        //datagrid属性
        method: 'GET',//请求方式：GET或post
        loadMsg: '正在加载数据，请稍后....',//加载数据时显示的信息
        url: "${pageContext.request.contextPath}/banner/selectBanner",//url:加载远程数据
        pagination: true,//显示分页工具栏，加入分页，要求JSON字符串必须要有两个Key值  rows:当前页数据 ,也就是当前页要遍历的集合数据，total:数据库数据的总条数
                         //后台处理数据 String Page 当前页    rows：每页显示的数据  mysql:select * form user limit 起始条数（page-1）*rows ,rows
        singleSelect: true,//只允许选择一行
        pageSize: 2,//设置初始页每页显示的行数  注意此值设置的值必须是pageList的子集
        pageList: [2, 4, 6, 8, 10, 12],//在设置分页属性的时候 初始化页面大小选择列表。
        pageNumber: 1,//设置初始页的页码
        /* data:[ //加载本地数据
                 {"id":"1","name":"阿尔托莉雅","password":"123","address":"西城","age":"15","date":"2012-12-12"},
                 {"id":"2","name":"清姬","password":"124","address":"东城","age":"10","date":"2012-11-12"},
                 {"id":"3","name":"黑贞","password":"125","address":"北城","age":"4","date":"2013-09-12"},
            ], */
        remoteSort: false,//是服务器端排序失效
        toolbar: [{
            iconCls: 'icon-reload',
            handler: function () {
                var ss = $("#pg").edatagrid("getSelected");
                if (ss == null) {
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: "没有选中的列！",//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                } else {
                    //修改窗口
                    $("#updateBanner").dialog({
                        title: '修改人员',	 //窗口标题
                        minimizable: true,//窗口最小化
                        minimizable: true,//窗口最大化
                        width: 600,		 //窗口宽
                        height: 500,		 //窗口高
                        resizable: true,  //窗口可拉伸
                        buttons: '#bj',	 //确认按钮
                        toolbar: '#tb',	 //工具栏
                        draggable: true,  //可拖拽窗口
                        href: "${pageContext.request.contextPath}/menuhref/updateBanner.jsp"
                    });
                }

            },
            text: '修改'
        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                //添加窗口
                $("#addBanner").dialog({
                    title: '添加人员',	 //窗口标题
                    minimizable: true,//窗口最小化
                    minimizable: true,//窗口最大化
                    width: 600,		 //窗口宽
                    height: 500,		 //窗口高
                    resizable: true,  //窗口可拉伸
                    buttons: '#bq',	 //确认按钮
                    toolbar: '#tb',	 //工具栏
                    draggable: true,  //可拖拽窗口
                    href: '${pageContext.request.contextPath}/menuhref/addBanner.jsp'
                });
            },
            text: '增加'
        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                //var s = $("#pg").edatagrid("getSelected").val;
                var ss = $("#pg").edatagrid("getSelected");
                if (ss == null) {
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: "没有选中的列！",//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                } else {
                    $.messager.confirm('确认对话框', '您想要删除该条数据吗？', function (r) {
                        if (r) {
                            $('#pg').edatagrid('destroyRow'); //对应删除数据的方法
                            $.messager.show({//消息窗口
                                title: '提示消息',
                                msg: "删除成功！",//信息文本
                                timeout: 5000,//持续时间
                                showType: 'slide'
                            });
                        }
                    });
                }
            },
            text: '删除'
        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                $('#pg').edatagrid('saveRow'); //对应保存数据的方法
                //保存窗口
                $.messager.show({//消息窗口
                    title: '提示消息',
                    msg: "保存成功！",//信息文本
                    timeout: 5000,//持续时间
                    showType: 'slide'
                });
                $("#pg").datagrid('reload');//刷新
                $("#addBanner").dialog('close');
            },
            text: '保存'
        }],

        columns: [[//定义列属性
            /*title:列标题头 ，
              field:指定列与属性匹配与属性 ，
              ailgn:居中,
              sortable:true 使列属性具有排序功能,
              resizable:true:可以拖动列改变大小
              fixed:true:使 【fitColumns:true,//自适应网格宽度】 在此列失效
              hidden：true:是此列在页面上消失
              checkbox:true:复选框 但是会代替此列，原先的列会被代替
              formatter: function(value,row,index){//根据列的值，并取值value经过逻辑判断，来更改此列的值
                                    if (value<=5){
                                        return "<font>幼女</font>";
                                    } else if(value>5 && value<=10){
                                        return "<font>萝莉</font>";
                                    }else if(value>10){
                                        return"<font>少女</font>";
                                    }
                         }
              */
            {
                title: '图片编号',
                field: 'id',
                width: 100,
                align: 'center',
                resizable: true,
                fixed: true,
                checkbox: false,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '图片名称',
                field: 'picName',
                width: 80,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '图片路径',
                field: 'picPath',
                width: 80,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '图片描述',
                field: 'description',
                width: 140,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '图片状态',
                field: 'status',
                width: 140,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '上传时间',
                field: 'createTime',
                width: 140,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {title: '跳转路径', field: 'url', width: 140, align: 'center', resizable: true},
        ]],
        view: detailview,
        detailFormatter: function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="/jiald/picture/' + rowData.picPath + '.png" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>Attribute: ' + rowData.createTime + '</p>' +
                '<p>Status: ' + rowData.status + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });

    function addOk() {
        $("#fh").form('submit', {
            url: "${pageContext.request.contextPath}/banner/addBanner",
            success: function (data) {
                $("#pg").datagrid('reload');
                $("#addBanner").dialog('close');//关闭添加窗口
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

    function adderror() {
        $("#addBanner").dialog('close');//关闭添加窗口
    }

    function updateBannererror() {
        $("#addBanner").dialog('close');//关闭添加窗口
    }

    function uerror() {
        $("#updateBanner").dialog('close');//关闭修改窗口
    }

    /**
     * 预览图片
     */
    function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
        //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
        var allowExtention = ".jpg,.bmp,.gif,.png";
        //extention  接受上传图片的格式
        var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
        /*browserVersion
            window.navigator.userAgent    判断pc端浏览器的类别
            toUpperCase()   转换成小写字母
        */
        var browserVersion = window.navigator.userAgent.toUpperCase();
        /*判断上传文件 格式是否符合要求
            indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
            如果没有找到匹配的字符串则返回 -1。
        */
        if (allowExtention.indexOf(extention) > -1) {
            if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
                //判断浏览器是否支持FileReader
                //支持FileReader浏览器的用户可以通过一个file input选择一个图像文件将图片显示在页面中，而不用发送到后端
                if (window.FileReader) {
                    //将图片展示出来
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                    };
                    reader.readAsDataURL(fileObj.files[0]);
                } else if (browserVersion.indexOf("SAFARI") > -1) {
                    alert("不支持Safari6.0以下浏览器的图片预览!");
                }
            } else if (browserVersion.indexOf("MSIE") > -1) {
                if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
                    document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
                } else {//ie[7-9]
                    fileObj.select();
                    if (browserVersion.indexOf("MSIE 9") > -1)
                        fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                    var newPreview = document.getElementById(divPreviewId + "New");
                    if (newPreview == null) {
                        newPreview = document.createElement("div");
                        newPreview.setAttribute("id", divPreviewId + "New");
                        newPreview.style.width = document.getElementById(imgPreviewId).width + "px";
                        newPreview.style.height = document.getElementById(imgPreviewId).height + "px";
                        newPreview.style.border = "solid 1px #d2e2e2";
                    }
                    newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                    var tempDivPreview = document.getElementById(divPreviewId);
                    tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
                    tempDivPreview.style.display = "none";
                }
            } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
                var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
                if (firefoxVersion < 7) {//firefox7以下版本
                    document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
                } else {//firefox7.0+
                    document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
                }
            } else {
                document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
            }
        } else {
            alert("仅支持" + allowExtention + "为后缀名的文件!");
            fileObj.value = "";//清空选中文件
            if (browserVersion.indexOf("MSIE") > -1) {
                fileObj.select();
                document.selection.clear();
            }
            fileObj.outerHTML = fileObj.outerHTML;
        }
    }

    //点击事件   上传时调用该方法
    function view_photo() {
        console.log($("input[id='fileInp']")[0]);
        console.log($("input[name='picPathUpdate']")[0]);
        /*
            Img是放置图片的img的id
            Imgdiv 是img外的div
        */
        PreviewImage($("input[name='picPathUpdate']")[0], 'img', 'im');
    }

    function uBannerOk() {
        $('#fq').form('submit', {
            url: "${pageContext.request.contextPath}/banner/updateBanner",
            success: function (data) {
                $("#pg").datagrid('reload');
                var json = $.parseJSON(data);
                $.messager.show({//消息窗口
                    title: '提示消息',
                    msg: json.text,//信息文本
                    timeout: 5000,//持续时间
                    showType: 'slide'
                });
                $("#updateBanner").dialog('close');//关闭修改窗口
            }
        });
    }
</script>

<table id="pg" style="width:100% ;height: 100%">
    <div id="addBanner"></div>
    <div id="updateBanner" style="margin-top: 20px ;display: none"></div>
    <div id="bq" style="display: none">
        <a class="easyui-linkbutton" onclick="addOk()">确认添加</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="adderror()">关闭</a>
    </div>
    <div id="bo" style="display: none">
        <a class="easyui-linkbutton" onclick="updateBannerOk()">确认编辑</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="updateBannererror()">关闭</a>
    </div>
    <div id="bj" style="display: none">
        <a class="easyui-linkbutton" onclick="uBannerOk()">确认编辑</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="uerror()">关闭</a>
    </div>


</table>