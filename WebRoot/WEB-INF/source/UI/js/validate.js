//获得焦点取消提醒
$("input,select,a,textarea").on("click", function(e) {
	$(this).css({
		"border-color" : ""
	});
});
var validate = {};
// 红色边框提醒
validate.warning = function(inputId) {
	$("#" + inputId).css({
		"border-color" : "#AF0604"
	});
	$("#" + inputId).addClass("shake shake-constant shake-horizontal");
	function clearShake(){
		$("#" + inputId).removeClass("shake shake-constant shake-horizontal");
	}
	setTimeout(clearShake,500);
};
// 数据验证+值获取
validate.valifunc = function(inputIds) {
	var returnVar = {
		success : true,
		data : {

		}
	};
	for (inputId in inputIds) {
		var valiValue = $("#" + inputId).val();
		if (valiValue == null || trimStr(valiValue) == "") {
			returnVar.success = false;
			validate.warning(inputId);
		}
		if (inputIds[inputId]) {
			if (isNaN(valiValue) || valiValue < '0') {
				returnVar.success = false;
				validate.warning(inputId);
			}
		}
		returnVar.data[inputId] = valiValue;
	}
	return returnVar;
};
function trimStr(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
};