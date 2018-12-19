<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript">
    $(function () {
        $("#title").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入文章名称...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
        $("#content").textbox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请输入文章内容...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
            validType: 'number',//密码验证
        });
        $("#file").filebox({
            width: 300,		   //图标宽
            height: 40,		   //图标高
            prompt: '请上传文件...',//请输入密码
            iconAlign: 'left',  //图标靠左
            iconWidth: 35,	   //图标宽度
            required: true,    //不为空验证
        });
    })

    /**
     * 预览图片
     */
    function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
        //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
        var allowExtention = ".jpl,.bmp,.gif,.png";
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
</script>


<div id="d1" style="margin-top: 20px">
    <center>
        <form id="fl" method="post" enctype="multipart/form-data">
            <div style="margin-top:10px">
                文章标题: <input id="title" type="text" name="title"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                文章内容: <input id="content" type="text" name="content"/><br/><span></span>
            </div>
            <div style="margin-top:10px">
                &nbsp;&nbsp;上师选择：
                <select class="easyui-combobox" style="width: 300px;height: 40px " id="gurnId" name="gurnId">
                    <c:forEach items="${sessionScope.gurus}" var="var">
                        <center>
                            <option class='easyui-linkbutton' value='${var.id}'>${var.dharnaName}</option>
                            <br/></center>
                    </c:forEach>
                </select>
            </div>
            <div style="margin-top:10px">
                上传封面: <input onchange="view_photo()" name="picPathUpdate" id="picPathUpdate"
                             type="text"/><br/><span></span>
            </div>
            <div style="margin-top:10px" id=im>
                图片预览: <img id="img"/>
            </div>

        </form>
    </center>
</div>
 