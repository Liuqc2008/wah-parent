layui.use(['form', 'layedit'], function () {
    var form = layui.form,
        layedit = layui.layedit;

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        //系统自带 required（必填项）phone（手机号）email（邮箱）url（网址）
        //number（数字）  date（日期）identity（身份证）
        length: function (value, item) {
            var len = $.trim(value).length;
            var param = item.attributes["param"].value;
            var paramArray = param.split(",");
            if (!(len >= paramArray[0] && len <= paramArray[1])) {
                //item.focus();
                return "只能输入{0}-{1}个字符！".format(paramArray[0], paramArray[1]);
            }
        },
        maxLen: function (value, item) {
            var maxLength = item.attributes["param"].value;
            if (value.length > maxLength) {

                return "最大长度必须小于{0}个字符！".format(maxLength);
            }
        },
        TelePhone: [/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/, '请输入正确电话号码！'],
        Password: [/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/, "密码请输入不少于8个字符且至少包括字母、数字！"],
        EasyPassword: function (value) {
            if (value.length < 6)
                return '密码请输入不少于6个字符！';
        },
        QQ: [/^[1-9]*[1-9][0-9]*$/, '请输入正确的qq号码！'],
        English: [/^[A-Za-z]+$/, '只允许输入英文！'],
        EnglishNum: [/^[A-Za-z0-9]+$/, '只允许输入英文和数字！'],
        EnglishNumUnderline: [/^\w+$/, '只允许输入英文和数字和下划线！'],
        ChineseEnglishNum: [/[A-Za-z0-9\u4e00-\u9fa5]+$/, '只允许输入中文和字母和数字！'],
        Chinese: [/[\u4e00-\u9fa5]/, '只允许输入中文！'],
        Num: [/^(-?\d+)(\.\d+)?$/, '只允许输入数字！'],
        //Num1: [/^\d+(\.\d+)?$/, '只允许输入数字！'],
        Num2: [/^[0-9]+([.]{1}[0-9]{1,2})?$/, '只允许输入最多两位小数的正数！'],

        Decimal2: [/^-?\d+(\.\d{1,2})?$/, '只允许输入两位小数！'],
        Integer: function (value, item) {
            if (value.length != 0 && !(/^\d{1,9}$/).test(value)) {
                 
                return '只允许输入正整数！'
            }
        },
        RangeInteger: function (value, item) {
            var integer = value * 1;
            var len = value.length;
            var param = item.attributes["param"].value;
            var paramArray = param.split(",");
            var fromNum = paramArray[0] * 1;
            var toNum = paramArray[1] * 1;

            if (integer < fromNum || integer > toNum || len == 0 || !(/^\d+$/).test(value))
                return '只能输入{0}-{1}的整数！'.format(fromNum, toNum);
        },
        PostCode: [/^[1-9][0-9]{5}$/, '请输入有效的邮政编码！'],
        Percent: [/^(([0-9]|[0-9][0-9])(\.\d{1,2})?|100|100.0|100.00)$/, '比例应介于1-100之间,且只允许输入两位小数!'],
        Discount: [/^\d+(\.\d{1})?$/, '只允许输入大于0，小于等于10的一位小数！']

    });
});

String.prototype.format = function (args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg = new RegExp("({[" + i + "]})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
}
