<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    //表格
    $("#pl").edatagrid({
        fit: true,//组件自适应父容器
        fitColumns: true,//自适应网格宽度
        autoRowHeight: true,//根据内容自定适应行的高度
        striped: true,//斑马线效果
        //datagrid属性
        method: 'POST',//请求方式：GET或post
        loadMsg: '正在加载数据，请稍后....',//加载数据时显示的信息
        url: "${pageContext.request.contextPath}/article/selectArticle",//url:加载远程数据
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
            iconCls: 'icon-add',
            handler: function () {
                //添加窗口
                $("#addArticle").dialog({
                    title: '添加文章',	 //窗口标题
                    minimizable: true,//窗口最小化
                    minimizable: true,//窗口最大化
                    width: 600,		 //窗口宽
                    height: 500,		 //窗口高
                    resizable: true,  //窗口可拉伸
                    buttons: '#bh',	 //确认按钮
                    draggable: true,  //可拖拽窗口
                    href: '${pageContext.request.contextPath}/article/addArticle.jsp'
                });

            },
            text: '增加'
        }, {
            iconCls: 'icon-add',
            handler: function () {
                console.log("111111");
                var ro = $("#pl").edatagrid("getSelected");
                if (ro == null) {
                    $.messager.show({//消息窗口
                        title: '提示消息',
                        msg: "请先选中文章！",//信息文本
                        timeout: 5000,//持续时间
                        showType: 'slide'
                    });
                } else {
                    console.log("111111111111111");
                    //添加窗口
                    $("#adsas").dialog({
                        title: '文章详情',	 //窗口标题
                        minimizable: true,//窗口最小化
                        minimizable: true,//窗口最大化
                        width: 600,		 //窗口宽
                        height: 500,		 //窗口高
                        resizable: true,  //窗口可拉伸
                        buttons: '#qq',	 //确认按钮
                        draggable: true,  //可拖拽窗口
                        href: "${pageContext.request.contextPath}/article/articlez.jsp"
                    });
                }
            },
            text: '文章详情'
        }, '-', {
            iconCls: 'icon-add',
            handler: function () {
                var row = $("#pl").treegrid("getSelected");

            },
            text: '删除文章'
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
                title: '文章编号',
                field: 'id',
                width: 100,
                align: 'center',
                resizable: true,
                fixed: true,
                checkbox: false,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '文章标题',
                field: 'title',
                width: 80,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '插图路径',
                field: 'articlePic',
                width: 80,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '上传日期',
                field: 'publicTime',
                width: 140,
                align: 'center',
                resizable: true,
                editor: {type: 'validatebox', options: {required: true}}
            },
            {
                title: '所属上师', field: 'guru', formatter: function (value, row, index) {
                    return value.dharnaName;
                }
                , width: 140, align: 'center', resizable: true, editor: {type: 'validatebox', options: {required: true}}
            },
        ]],
        view: detailview,
        detailFormatter: function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="/jiald/picture/' + rowData.articlePic + '.png" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>文章内容: ' + rowData.content + '</p>' +
                '<p>Status: ' + rowData.field + '</p>' +
                '</td>' +
                '</tr></table>';
        },
        //双击文章详情
        onDblClickRow: function (row) {

        },
    });

    function addArticleOk() {
        $("#fl").form('submit', {
            url: '${pageContext.request.contextPath}/article/addArticle',
            success: function (data) {
                $("#pl").datagrid('reload');
                $("#addArticle").dialog('close');//关闭添加窗口
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

    function Articleerror() {
        $("#addArticle").dialog('close');//关闭添加窗口
    }

    function ArticlezEr() {
        $("#adsas").dialog('close');//关闭添加窗口
    }

</script>

<table id="pl" style="width:100% ;height: 100%">
    <div id="addArticle" style="display: none"></div>
    <div id="bh" style="display: none">
        <a class="easyui-linkbutton" onclick="addArticleOk()">确认添加</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="Articleerror()">关闭</a>
    </div>
    <div id="qq" style="display: none">
        <a href="javascript:;" class="easyui-linkbutton" onclick="ArticlezEr()">关闭</a>
    </div>
    <div id="adsas"></div>


</table>