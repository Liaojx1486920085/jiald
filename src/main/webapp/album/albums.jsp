<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
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


    $('#al').treegrid({
        url: '${pageContext.request.contextPath}/album/selectAlbum',
        idField: 'id',
        treeField: 'name',
        align: "left",
        fit: true,//组件自适应父容器
        fitColumns: true,//自适应网格宽度
        autoRowHeight: true,//根据内容自定适应行的高度
        striped: true,//斑马线效果
        loadMsg: '正在加载数据，请稍后....',//加载数据时显示的信息
        pagination: true,//显示分页工具栏，加入分页，要求JSON字符串必须要有两个Key值  rows:当前页数据 ,也就是当前页要遍历的集合数据，total:数据库数据的总条数
                         //后台处理数据 String Page 当前页    rows：每页显示的数据  mysql:select * form user limit 起始条数（page-1）*rows ,rows
        singleSelect: true,//只允许选择一行
        pageSize: 2,//设置初始页每页显示的行数  注意此值设置的值必须是pageList的子集
        pageList: [2, 4, 6, 8, 10, 12],//在设置分页属性的时候 初始化页面大小选择列表。
        pageNumber: 1,//设置初始页的页码
        //双击播放音乐
        onDblClickRow: function (row) {
            $('#music').dialog({
                width: 320,
                height: 90,
                title: '音乐播放'
            });
            var url = '${pageContext.request.contextPath}' + row.url;
            $('#audio').attr('src', encodeURI(url));
        },
        columns: [[
            {field: 'name', title: '名称', width: 100},
            {field: 'url', title: '音频路径', width: 80},
            {field: 'size', title: '音频大小', width: 80},
            {field: 'length', title: '音频时长', width: 80},
            {field: 'times', title: '集数', width: 80},
            {field: 'createTime', title: '上传日期', width: 80},
        ]],
        toolbar: [{
            iconCls: 'icon-reload',
            handler: function () {
                var row = $('#al').treegrid('getSelected');
                if (row == null) {
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: "请先选中专辑！",//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                } else {
                    if (row.author != null) {
                        //添加窗口
                        $("#albumz").dialog({
                            title: '专辑详情',	 //窗口标题
                            minimizable: true,//窗口最小化
                            minimizable: true,//窗口最大化
                            width: 600,		 //窗口宽
                            height: 500,		 //窗口高
                            resizable: true,  //窗口可拉伸
                            buttons: '#ba',	 //确认按钮
                            draggable: true,  //可拖拽窗口
                            href: "${pageContext.request.contextPath}/album/Albumz.jsp"
                        });
                    } else {
                        $.messager.show({//消息窗口
                            title: '提示消息',
                            msg: "请先选中专辑！",//信息文本
                            timeout: 5000,//持续时间
                            showType: 'slide'
                        });
                    }
                }

            },
            text: '专辑详情'
        }, '-', {
            text: '增加',
            iconCls: 'icon-add',
            handler: function () {
                $('#add').dialog({
                    minimizable: true,//窗口最小化
                    minimizable: true,//窗口最大化
                    width: 150,		 //窗口宽
                    height: 150,		 //窗口高
                    resizable: true,  //窗口可拉伸
                    draggable: true,  //可拖拽窗口
                    buttons: [{
                        text: '添加专辑',
                        handler: function () {
                            $("#add").dialog('close');
                            //添加窗口
                            $("#addalbum").dialog({
                                title: '添加专辑',	 //窗口标题
                                minimizable: true,//窗口最小化
                                minimizable: true,//窗口最大化
                                width: 600,		 //窗口宽
                                height: 500,		 //窗口高
                                resizable: true,  //窗口可拉伸
                                buttons: '#bk',	 //确认按钮
                                draggable: true,  //可拖拽窗口
                                href: '${pageContext.request.contextPath}/album/addAlbum.jsp'
                            });
                        }
                    }, {
                        text: '添加音乐',
                        handler: function () {
                            $("#add").dialog('close');
                            //添加窗口
                            $("#addchapter").dialog({
                                title: '添加专辑',	 //窗口标题
                                minimizable: true,//窗口最小化
                                minimizable: true,//窗口最大化
                                width: 600,		 //窗口宽
                                height: 200,		 //窗口高
                                resizable: true,  //窗口可拉伸
                                buttons: '#bn',	 //确认按钮
                                draggable: true,  //可拖拽窗口
                                href: '${pageContext.request.contextPath}/album/addchapter.jsp'
                            });

                        }
                    }]
                });

            },

        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                var row = $('#al').treegrid('getSelected');
                $.messager.confirm('确认对话框', '您想要删除该条数据吗？', function (r) {
                    if (r) {
                        if (row == null) {
                            $.messager.show({//消息窗口
                                title: '提示消息',
                                msg: "请先选中专辑！",//信息文本
                                timeout: 5000,//持续时间
                                showType: 'slide'
                            });
                        } else {
                            if (row.author != null) {
                                //删除专辑
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath}/album/deleteAlbum",
                                    data: "id=" + row.id,
                                    dataType: "JSON",
                                    success: function (result) {
                                        $("#al").treegrid('reload');
                                        $.messager.show({//消息窗口
                                            title: '提示消息',
                                            msg: result.text,//信息文本
                                            timeout: 5000,//持续时间
                                            showType: 'slide'
                                        });
                                    }
                                });
                            } else {
                                //删除音乐
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath}/chapter/deleteChapter",
                                    data: "id=" + row.id,
                                    dataType: "JSON",
                                    success: function (result) {
                                        $("#al").treegrid('reload');
                                        $.messager.show({//消息窗口
                                            title: '提示消息',
                                            msg: result.text,//信息文本
                                            timeout: 5000,//持续时间
                                            showType: 'slide'
                                        });
                                    }
                                });
                            }
                        }
                    }
                });
            },
            text: '删除'
        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                var row = $("#al").treegrid("getSelected");
                if (row.size == null) {
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: "请选择要下载的章节行",//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                } else {
                    location.href = "${pageContext.request.contextPath}/chapter/download?fileName=" + row.name;
                }
            },
            text: '下载音频'
        }],
    });

    function albumEr() {
        $("#addalbum").dialog('close');
    }

    function chapterEr() {
        $("#addchapter").dialog('close');
    }

    function aEr() {
        $("#albumz").dialog('close');
    }

    function AlnumOk() {
        $('#fl').form('submit', {
            url: "${pageContext.request.contextPath}/album/addAlbum",
            success: function (data) {
                $("#addalbum").dialog('close');
                $("#al").treegrid('reload');
                var json = $.parseJSON(data)
                $.messager.show({//消息窗口
                    title: '提示消息',
                    msg: json.text,//信息文本
                    timeout: 5000,//持续时间
                    showType: 'slide'
                });
            }
        });
    }

    function chapterOk() {
        $('#fv').form('submit', {
            url: "${pageContext.request.contextPath}/chapter/addChapter",
            success: function (data) {
                $("#addchapter").dialog('close');
                $("#al").treegrid('reload');
                var json = $.parseJSON(data)
                $.messager.show({//消息窗口
                    title: '提示消息',
                    msg: json.text,//信息文本
                    timeout: 5000,//持续时间
                    showType: 'slide'
                });
            }
        });

    }

</script>


<table id="al" style="height: 100%;width: 100%">
    <div id="add"></div>
    <div id="addalbum"></div>
    <div id="addchapter"></div>
    <div id="bk" style="display: none">
        <a class="easyui-linkbutton" onclick="AlnumOk()">确认添加</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="albumEr()">关闭</a>
    </div>
    <div id="bn" style="display: none">
        <a class="easyui-linkbutton" onclick="chapterOk()">确认添加</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="chapterEr()">关闭</a>
    </div>
    <div id="ba" style="display: none">
        <a href="javascript:;" class="easyui-linkbutton" onclick="aEr()">关闭</a>
    </div>
    <div id="albumz" style="display: none"></div>
    <%--双击播放音乐--%>
    <div id="music" style="display: none">
        <audio id="audio" controls="controls" src="" autoplay="autoplay"></audio>
    </div>
</table>