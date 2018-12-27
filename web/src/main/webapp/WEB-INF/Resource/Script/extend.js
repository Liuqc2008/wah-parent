
function OpenFrame(title, url, width, height, SuccessBack, EndCallBack) {
    layer.open({
        type: 2,
        shadeClose: false,
        title: [title, 'background:#336699;color:#ffffff;font-weight:bolder;text-align:center;padding-left:80px;font-size:18px;font-family:微软雅黑'],
        closeBtn: 0,
        shade: [0.6, '#000'],
        border: [0],
        area: [width + 'px', height + 'px'],
        content: url,
        success: function (layero, index) {
            if (SuccessBack != null) {
                if (typeof (SuccessBack) == "function") {
                    SuccessBack();
                }
            }
        },
        end: function () {
            if (EndCallBack != null) {
                if (typeof (EndCallBack) == "function") {
                    EndCallBack();
                }
            }
        }
    });
}

String.prototype.replaceAll = function (oldStr, newStr) {
    return this.replace(new RegExp(oldStr, "gm"), newStr);
}
String.prototype.toJson = function () {
    return JSON.parse(this);
}

//json转为字符串  JSON.stringify(this)
//$("#State").is(":checked") 复选框是否被选中
//layer.confirm('保存成功！', { btn: ['确定'] }, function () {
//    window.location.href = "/Console/VideoInfo/VideoTypeList";
//});
