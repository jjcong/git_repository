function parseTemplete(contentId, tmpId, data) {
	var dfd = $.Deferred();
	var d = {};
	if (data) {
		d = data;
	}

	$("#" + contentId).empty();
	var tpl = $("#" + tmpId).text();
	var tempFn = doT.template(tpl);
	$("#" + contentId).append(tempFn(d));
	dfd.resolve("parse finished!");
	return dfd.promise();
};

function parseTempleteObj(obj, tmpId, data) {
	var dfd = $.Deferred();
	var d = {};
	if (data) {
		d = data;
	}

	obj.empty();
	var tpl = $("#" + tmpId).text();
	var tempFn = doT.template(tpl);
	obj.append(tempFn(d));
	dfd.resolve("parse finished!");
	return dfd.promise();
};

function createForm(data){
	var form='';
	if(data == null || data == ""){
		return form;
	}
	
	var obj = JSON.parse(data);
	for(var p in obj){
		form += '<div class="form-group">'+
			'<label for="'+obj[p]+'" class="col-sm-2 control-label">'+p+'</label>'+
			'<div class="col-sm-9">'+
				'<input type="text" class="form-control" id="'+obj[p]+'">'+
			'</div></div>';
	}
	
	return form;
};

function createEmptyForm(obj){
	var num = Number($(obj).attr("count"));
	
	var form = '<div class="form-group">'+
		 '<div class="col-sm-2">'+
		 	'<input type="text" class="form-control" key id="property'+num+'">'+
		 '</div>'+
		 '<div class="col-sm-9">'+
		 	'<input type="text" class="form-control" property id="content'+num+'">'+
		 '</div>'+
	 '</div>';
	$("#forNewProperty").append(form);
	$(obj).attr("count",num+1);
};

//
function addMonthUtil(sDate, num) {

	var aYmd = sDate.split('-');
	var dt = new Date(aYmd[0], aYmd[1], aYmd[2]);

	dt.setMonth(dt.getMonth() + num);

	var y = dt.getFullYear();
	var m = dt.getMonth();
	var d = dt.getDate();
	//坑爹啊，月份是从0开始啊！！！！
	if (m == 0) {
		m = 12;
		y = y - 1;
	}

	if (m < 10)
		m = '0' + m;
	if (d < 10)
		d = '0' + d;
	return y + '-' + m + '-' + d;
};

function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate;
	return currentdate;
};

function addDayUtil(sDate, num) {

	var aYmd = sDate.split('-');
	var dt = new Date(aYmd[0], aYmd[1], aYmd[2]);

	dt.setDate(dt.getDate() + num);

	var y = dt.getFullYear();
	var m = dt.getMonth();
	var d = dt.getDate();

	if (m == 0) {
		m = 12;
		y = y - 1;
	}

	if (m < 10)
		m = '0' + m;
	if (d < 10)
		d = '0' + d;
	return y + '-' + m + '-' + d;
};

//日期格式化
function add0(m){return m<10?'0'+m:m }
function formatDateUtil(shijianchuo)
{
	//shijianchuo是整数，否则要parseInt转换
	var time = new Date(shijianchuo);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}

//url传值
UrlParm = function() { // url参数    
	  var data, index;    
	  (function init() {    
	    data = [];    
	    index = {};    
	    var u = window.location.search.substr(1);    
	    if (u != '') {    
	      var parms = decodeURIComponent(u).split('&');    
	      for (var i = 0, len = parms.length; i < len; i++) {    
	        if (parms[i] != '') {    
	          var p = parms[i].split("=");    
	          if (p.length == 1 || (p.length == 2 && p[1] == '')) {// p | p=    
	            data.push(['']);    
	            index[p[0]] = data.length - 1;    
	          } else if (typeof(p[0]) == 'undefined' || p[0] == '') { // =c | =    
	            data[0] = [p[1]];    
	          } else if (typeof(index[p[0]]) == 'undefined') { // c=aaa    
	            data.push([p[1]]);    
	            index[p[0]] = data.length - 1;    
	          } else {// c=aaa    
	            data[index[p[0]]].push(p[1]);    
	          }    
	        }    
	      }    
	    }    
	  })();    
	  return {    
	    // 获得参数,类似request.getParameter()    
	    parm : function(o) { // o: 参数名或者参数次序    
	      try {    
	        return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);    
	      } catch (e) {    
	      }    
	    },    
	    //获得参数组, 类似request.getParameterValues()    
	    parmValues : function(o) { //  o: 参数名或者参数次序    
	      try {    
	        return (typeof(o) == 'number' ? data[o] : data[index[o]]);    
	      } catch (e) {}    
	    },    
	    //是否含有parmName参数    
	    hasParm : function(parmName) {    
	      return typeof(parmName) == 'string' ? typeof(index[parmName]) != 'undefined' : false;    
	    },    
	    // 获得参数Map ,类似request.getParameterMap()    
	    parmMap : function() {    
	      var map = {};    
	      try {    
	        for (var p in index) {  map[p] = data[index[p]];  }    
	      } catch (e) {}    
	      return map;    
	    }    
	  }    
	}();   
	
	// 查询下拉列表框的字典数据
	function queryDicData(type,ID){
		$.ajax({
			type : 'post',
			url : "/appcenter/dic/queryDicData.do",
			dataType : "json",
			 data :{
	      	   "dicInfo":JSON.stringify ({
	      			"type" : type,
	      			})	      	   
	         },
			success : function(data) {
				var dataList = data.content.result;
				$(ID).empty();
				$(ID).append("<option value=''>--请选择--</option>");
				$.each(dataList, function(i, obj) {
					$(ID).append("<option value="+obj.code+">" + obj.name + "</option>");
				});
			},
			error : function() {
				layer.alert("网络错误");
			}
		});
	}
	
/*window.onload = function(){	if((!getCookieBySite("siteUserId"))|| (!getCookieBySite("siteToken"))){top.location.href = "http://site.haiziwang.com";}}
	var getCookieBySite = function(name) {
		if (document.cookie.length > 0) {
			start = document.cookie.indexOf(name + "=");
			if (start != -1) {
				start = start + name.length + 1;
				end = document.cookie.indexOf(";", start);
				if (end == -1)
					end = document.cookie.length;
				return unescape(document.cookie.substring(start, end));
			}
		}
		return "";
}*/