//查询当前登录人的应用列表（分页）
function queryMyAppList(pageIndex) {
	var _pageSize = new Number(10); //分页数量
	if (pageIndex == null || pageIndex == ""|| pageIndex <= 1) {
		pageIndex = new Number(1);
	}
	var appCode =  $("#appNameQuery").val();
	var sysLevel =  $("#sysLevelQuery").val();
	var devLanguage =  $("#devLanguageQuery").val();
	var pageCond = JSON.stringify({shdCount:true,pageSize:_pageSize,pageIndex:pageIndex});
	var queryCond = JSON.stringify(
			{
				"appCode":appCode,
				"sysLevel":sysLevel,
				"devLanguage":devLanguage,
				"querytype":"1",
			});
	var queryAjax = $.ajax( {  
	    url:'/appcenter/myapp/queryMyApp.do',   //ajax带json数据的异步请求
	    data:{pageCond  : pageCond , queryCond : queryCond },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',  
		success : function(data) {
			if( !data.success){
				layer.alert("提示，系统貌似有点问题 。 原因：" + data.msg);
				return;
			}
			var totalCount = data.content.result.pc.count;
			if( totalCount < 1 ){
				$('#contentBody').html('');
				createPagination(pageIndex,_pageSize,totalCount);
				return };
        	$('#contentBody').html('');
   			var dataList = data.content.result.list;
   			var toAddString = "";
   			var toAddString1 = "";
   			$.each(dataList, function(i, obj) {
   				var type="";
   				var level="";
   				var status="";
   				toAddString1='<a href="../appcenter_v2/platform_service.html?appCode='+dataList[i].appCode+'&appName='+dataList[i].appName+'">【平台服务】</a></td>'
   				if(dataList[i].sysType=="0"){
   					type="内部应用"
   				}
   				if(dataList[i].sysType=="1"){
   					type="外部应用"
   				}
   				if(dataList[i].sysLevel=="0"){
   					level="P0";
   				}
   				if(dataList[i].sysLevel=="1"){
   					level="P1";
   				}
   				if(dataList[i].sysLevel=="2"){
   					level="P2";
   				}
   				if(dataList[i].status=="1"){
   					status="申请";
   					toAddString1='<a href="#" onclick="tips()" style="color:#7d7d7d">【平台服务】</a></td>'
   				}
   				if(dataList[i].status=="2"){
   					status="发布";
   				}
   				if(dataList[i].status=="3"){
   					status="下线";
   				}
   				if(dataList[i].status=="4"){
   					status="删除";  					
   				}	
   				toAddString += 
   				"<tr>"+
   					"<td>"+(i+1)+"</td>"+
   					"<td>"+dataList[i].appCode+"</td>"+
   					"<td>"+dataList[i].appName+"</td>"+
   					"<td>"+dataList[i].orgDicName+"</td>"+
   					"<td>"+level+"</td>"+
   					"<td>"+dataList[i].devLanguageName+"</td>"+
   					"<td>"+status+"</td>"+
   					"<td>"+formatDateUtil(dataList[i].creatTime)+"</td>"+
   					"<td>"+dataList[i].owner1Name+"</td>"+
   					'<td style="text-align:center"><a href="#"><span  onclick="update(\''+dataList[i].id+'\',\''+dataList[i].appCode+'\',\''+dataList[i].appName+'\',\''+dataList[i].sysField+'\',\''+dataList[i].sysLevel+'\',\''+dataList[i].orgName+'\',\''+dataList[i].devLanguage+'\',\''+dataList[i].hostRestrict+'\',\''+dataList[i].devLanguageName+'\',\''+dataList[i].orgDicName+'\',\''+level+'\',\''+pageIndex+'\')">【修改】</span></a>'
						+toAddString1+
   				"</tr>";	
   			});
   			$('#contentBody').append(toAddString);
   			createPagination(pageIndex,_pageSize,totalCount,"queryMyAppList");		
	},		
		error : function(ex) {
			alert("系统异常信息：" + ex);
		}
	});
}


/*创建分页
**@ pageIndex  当前页
**@ pageSize   每页记录数量
**@ totalCount 总记录条数
*/
function createPagination(pageIndex,pageSize,totalCount,id) {
	var totalPage = Math.ceil(totalCount/pageSize);//总页数
	var showPageNum = 5 ;//页面显示页码的数量
	var pageNumString = '';
	var realPageIndex = pageIndex;
	if(totalPage <= showPageNum){ 
		pageIndex =1;
	}else if( (totalPage - pageIndex)  < (showPageNum - 1) ){
		pageIndex = (totalPage - showPageNum + 1);
	} 
	for(var i=0; i< totalPage ;i++ ){
		if( (pageIndex+i) > totalPage ){break;}
		if(i>=showPageNum){ break;}
	
		if( (pageIndex+i) == realPageIndex ){
			pageNumString += '<li class="active"><a href="javascript:void(0);"onclick="'+id+'('+(pageIndex+i)+')">'+(pageIndex+i)+'</a></li>';
		} 
		else{
			pageNumString += '<li><a href="javascript:void(0);"onclick="'+id+'('+(pageIndex+i)+')">'+(pageIndex+i)+'</a></li>';
		}
	}
	var pageIndexPre = (realPageIndex -1) <= 0? 1 : (realPageIndex -1);//前一页
	var pageIndexNext = (realPageIndex +1) >= totalPage? totalPage : (realPageIndex +1);//后一页
	var page = 
	"<nav>" +
	'<ul class="pagination"> ' +
		'<li><a><span aria-hidden="true">共 '+ totalCount +' 条</span></a></li>' +
		'<li><a href="javascript:void(0);" onclick="'+id+'(0);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'+
		'<li><a href="javascript:void(0);" onclick="'+id+'('+pageIndexPre+');" aria-label="Previous">'+
		'<span aria-hidden="true">&lsaquo;</span></a></li>' +
		pageNumString + 
		'<li><a href="javascript:void(0);" onclick="'+id+'('+pageIndexNext+');" aria-label="Next"> '+
		'<span aria-hidden="true">&rsaquo;</span></a></li>'+
		'<li><a href="javascript:void(0);" onclick="'+id+'('+totalPage+');" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>'+
	'</ul>'+
	'</nav>';
	$('#page').empty();
	$('#page').append(page);
}


//获取登录人可以访问的所有APP
function initappCodeInfo() {
	var queryAjax = $.ajax( {  
	    url:'/appcenter/comm/getMerberApps.do', //ajax带json数据的异步请求
	    type:'post',  
	    cache:false,  
	    dataType:'json',  
		success : function(jsonObj) {
			if(!jsonObj.success){
				return;
			}
			var optionstring = '<option value="">模糊查询</option>';
			var dataList = jsonObj.content.result;
			$.each(dataList, function(i, obj) {
				optionstring += "<option value=\""+ dataList[i].appCode +"\" >"+ dataList[i].appName +"</option>";
   			});
			jQuery("#appNameQuery").html(optionstring);
		},
		error : function(ex) {
			//layer.alert("提示，系统貌似有点问题 。 原因：" + ex);
		}
	});
}


function tips(){
	layer.alert("应用正在申请中，请审核后再试");
}



//查看签名
function viewSign(id) {

	$.ajax({
		type : 'post',
		url : "/appcenter/appmanager/getAppSign.do",
		dataType : "json",
		data : {
			"appId" : id
		},
		success : function(data) {
			var appSign = data.content.result.appSecInfo.appSign;
			$("#appSignUpdate").val(appSign);
		},
		error : function() {
			layer.alert("网络错误");
		}
	});
}

// 更新签名
function updateSign() {
	var appSign = $("#appSignUpdate").val();
	var appId = $("#appId").val();
	layer.confirm('确定更新签名?', function() {
	$.ajax({		
		type : 'post',
		url : "/appcenter/appmanager/updateAppSign.do",
		dataType : "json",
		data : {		
				"appSign" : appSign,
				"appId" : appId				
		},
		success : function(data) {
			if (!data.success) {			
				layer.msg('出错了，原因：'+ data.msg, {icon: 2,time:6000});  
				return;			
			} 
			    layer.msg('更新成功', {icon: 1,time:2200}); 
			    var appSign = data.content.result.appSecInfo.appSign;
				$("#appSignUpdate").val(appSign);	
		},
		error : function(ex) {			
			layer.alert("系统错误："+ex.message);
		}
	});
  });
}

// 修改应用（弹出）
function update(id,appCode, appName, sysField, sysLevel, orgName, devLanguage,hostRestrict, devLanguageName, orgDicName, level, pageIndex) {
	// 首先把校验时的红色边框去掉
	$("#appNameUpdate").css({

		"border-color" : ""
	});
	$("#appCodeUpdate").css({

		"border-color" : ""
	});
	$("#sysFieldUpdate").css({

		"border-color" : ""
	});	
	viewSign(id);
	$("#pageIndex").val(pageIndex);
	$("#appId").val(id);
	$("#appCodeUpdate").val(appCode);
	$("#appNameUpdate").val(appName);
	$("#sysFieldUpdate").val(sysField);
	$("#hostRestrictUpdate").val(hostRestrict);
	$("#sysLevelUpdate").val(sysLevel).trigger("change");
	$("#orgNameUpdate").val(orgName).trigger("change");
	$("#devLanguageUpdate").val(devLanguage).trigger("change");
	$('#editModal').modal("show");
}

//修改应用信息（点击确定）
function updateApp() {
	var vali = validate.valifunc({
		"appNameUpdate" : false,
		"sysFieldUpdate" : false,
		"sysLevelUpdate" : false,
		"orgNameUpdate" : false,
		"devLanguageUpdate" : false	
	});
	if (!vali.success) {
		return;
	};
	var appCode = $("#appCodeUpdate").val();
	var appName = $("#appNameUpdate").val();
	var sysField = $("#sysFieldUpdate").val();
	var sysLevel = $("#sysLevelUpdate").val();
	var hostRestrict = $("#hostRestrictUpdate").val();
	var orgName = $("#orgNameUpdate").val();
	var devLanguage = $("#devLanguageUpdate").val();
	var pageIndex = $("#pageIndex").val();
	if(hostRestrict=="示例：127.0.0.0,127.0.0.1"){
		hostRestrict="";
	}
	// 校验ip地址 是否符合规范
	if (hostRestrict != "" && hostRestrict != null) {
		var isTrue = hostRestrict.split(',').every(function(ip) {
			return isIp(ip);// 先将字符串按照逗号分成数组，在校验就可以了
		});
		if (!isTrue) {
			layer.alert("IP地址格式有错，请检查后提交");
			return;
		}
	}	
	$.ajax({
		type : 'post',
		url : "/appcenter/myapp/updateApp.do",
		dataType : "json",
		data : {
			"appInfo" : JSON.stringify({
				"appCode" : appCode,
				"appName" : appName,
				"sysField" : sysField,
				"sysLevel" : sysLevel,
				"hostRestrict" : hostRestrict,
				"orgName" : orgName,
				"devLanguage" : devLanguage		
			})
		},
		success : function(data) {
			$('#editModal').modal("hide");
			if (!data.success) {				
				layer.msg('出错了，原因：'+ data.msg, {icon: 2,time:6000});  
				return;	
			} 
			    queryMyAppList(pageIndex);
			    layer.msg('修改成功', {icon: 1,time:2200}); 			    
		},
		error : function(ex) {
			$('#editModal').modal("hide");
			layer.alert("系统错误："+ex.message);
		}
	});
}



 
