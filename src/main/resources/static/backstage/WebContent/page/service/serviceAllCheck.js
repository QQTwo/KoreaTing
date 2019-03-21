layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','laydate'],function(){
var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	laydate = layui.laydate,
	$ = layui.jquery;

 /*laydate.render({
	    elem: '#timeM' //指定元素
});
 
 laydate.render({
	    elem: 'timeM' //指定元素
 });*/

serviceVoFun();
//加载页面数据
var linksData = '';
loadInfo(linksData);

//服务类别("[name=serviceID]")
$.ajax({
	url:"/c/lzh/service/primaryServiceType",
	type:"get",
	async:false,
	success:function(data){
		for (var i = 0; i < data.length; i++) {
			$("[name=serviceID]").append("<option value="+data[i].stid+">"+data[i].stname+"</option>");
			$.ajax({
				url:"/c/lzh/service/primaryServiceType/" +data[i].stid,
				type:"get",
				async:false,
				success:function(json){
					for (var i = 0; i < json.length; i++) {
						$("[name=serviceID]").append("<option value="+json[i].stid+">——"+json[i].stname+"</option>");
					}
				}
			})
		}
	}
})

//查询
$(".search_btn").click(function(){
	serviceVoFun();
	var newArray = [];
	var index = layer.msg('更新中，请稍候',{icon: 16,time:false,shade:0.8});
    window.setTimeout(function(){
    	$.ajax({
			url : "/c/lzh/service/servicesInfo",
			type : "post",
			dataType : "json",
			contentType:"application/json",
			data:JSON.stringify(layui.data('serviceVo')),
			success : function(data){
				if(window.sessionStorage.getItem("addLinks")){
					var addLinks = window.sessionStorage.getItem("addLinks");
					linksData = JSON.parse(addLinks).concat(data);
				}else{
					linksData = data;
				}
            	linksList(linksData);
			}
		})
    	
        layer.close(index);
    },2000);
	
})

//添加友情链接
$(".linksAdd_btn").click(function(){
	var index = layui.layer.open({
		title : "添加友情链接",
		type : 2,
		content : "linksAdd.html",
		success : function(layero, index){
			setTimeout(function(){
				layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			},500)
		}
	})
	//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
	$(window).resize(function(){
		layui.layer.full(index);
	})
	layui.layer.full(index);
})

//批量删除
$(".batchDel").click(function(){
	var text = this.value;
	var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
	var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
	var recommend;
	var shenhe;
	var business;
	var view;
	//判断更新什么操作
	var status = 1;
	if(text.indexOf("推荐") != -1){
		status = 1;
		recommend = $(".links_list input[name='is_recommend']:checked").val();
		shenhe = 0;
		business = 0;
		view = '0';
	}else if(text.indexOf("审核") != -1){
		status = 2;
		recommend = 0;
		shenhe = $(".links_list input[name=zt]:checked").val();
		business = 0;
		view = $(".links_list input[name='admin_reason']").val();
	}else{
		status = 3;
		recommend = 0;
		shenhe = 0;
		business = $(".links_list input[name='close']:checked").val();
		view = '0';
	}	
	if($checkbox.is(":checked")){
		var _isOk = true;
		if(status == 2){
			if(shenhe == 1)
				_isOk = false;
			else if(view == '')
				_isOk = false;
		}
		if(!_isOk){
			layer.msg("该服务被审核或者未写审核管理员意见");
		}{
			layer.confirm('确定'+text+'选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg(text+'中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//更新数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].serviceID == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								$.ajax({
									url:"/c/lzh/service/modifyServicesInfo/"+recommend+"/"+shenhe+"/"+business+"/"+view+"/"+linksData[i].serviceID+"/"+status,
									type:"get",
									datatype:"json",
									success:function(data){
										loadInfo(data);
									}
								})
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	linksList(linksData);
	            	form.render();
	                layer.close(index);
					layer.msg(text+"成功");
	            },2000);
	        })
		}
		
	
		
	}else{
		layer.msg("请选择需要"+text+"的文章");
	}
})

//全选
form.on('checkbox(allChoose)', function(data){
	var child = $(data.elem).parents('.links_list').find('tbody input[type="checkbox"]:not([name="show"])');
	child.each(function(index, item){
		item.checked = data.elem.checked;
	});
	form.render('checkbox');
	
});

//通过判断文章是否全部选中来确定全选按钮是否选中
form.on("checkbox(choose)",function(data){
	var child = $(data.elem).parents('.links_list').find('tbody input[type="checkbox"]:not([name="show"])');
	var childChecked = $(data.elem).parents('.links_list').find('tbody input[type="checkbox"]:not([name="show"]):checked')
	data.elem.checked;
	if(childChecked.length == child.length){
		$(data.elem).parents('.links_list').find('thead input#allChoose').get(0).checked = true;
	}else{
		$(data.elem).parents('.links_list').find('thead input#allChoose').get(0).checked = false;
	}
	form.render('checkbox');
	})
 
	//操作
$("body").on("click",".links_edit",function(){  //编辑
	window.sessionStorage.setItem("serviceID", $(this).parents("tr").find(".links_del").attr("data-id"));
	window.location.href="../service/serviceAllCheckUpdate.html";
})


//查询获得数据
function serviceVoFun(){
	layui.data('serviceVo', {
		  key: 'serviceTitle'
		  ,value: $("#title").val().trim()
	});
	layui.data('serviceVo', {
		  key: 'releaseTimeP'
		  ,value: $("#timeP").val().trim()
	});
	layui.data('serviceVo', {
		  key: 'releaseTimeM'
		  ,value: $("#timeM").val().trim()
	});
	layui.data('serviceVo', {
		  key: 'stid'
		  ,value: $("#serviceID").val().trim()
	});
	layui.data('serviceVo', {
		  key: 'auditStatus'
		  ,value: $("#auStatus").val().trim()
	});
}
//加载数
function loadInfo(linksData){
	$.ajax({
		url : "/c/lzh/service/servicesInfo",
		type : "post",
		dataType : "json",
		contentType:"application/json",
		data:JSON.stringify(layui.data('serviceVo')),
		success : function(data){
			linksData = data;
			
			if(window.sessionStorage.getItem("addLinks")){
				var addLinks = window.sessionStorage.getItem("addLinks");
				linksData = JSON.parse(addLinks).concat(linksData);
			}
			//执行加载数据的方法
			linksList(linksData);
		}
	})
}
function linksList(that){
	//渲染数据
	function renderDate(data,curr){
		var dataHtml = '';
		if(!that){
			currData = linksData.concat().splice(curr*nums-nums, nums);
		}else{
			currData = that.concat().splice(curr*nums-nums, nums);
		}
		if(currData.length != 0){
			for(var i=0;i<currData.length;i++){
				dataHtml += '<tr>'
		    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
		    	+'<td>'+currData[i].serviceID+'</td>'
		    	+'<td align="center" valign="middle">'+currData[i].stName+'</td>'
		    	+'<td>'+currData[i].serviceTitle+'</td>'
		    	+'<td>'+currData[i].userName+'</td>'
		    	+'<td style="color:'+(currData[i].auditStatus==1 ? 'blue' : currData[i].auditStatus==2 ? 'black':'red')+';">'+(currData[i].auditStatus==1 ? '待审核' : currData[i].auditStatus==2 ? '审核成功':'未通过')+'</td>'
		    	+'<td>'+(currData[i].shelfState==1 ? '上架' :'下架')+' </td>'
		    	+'<td>'+currData[i].releaseTime+'</td>'
		    	+'<td>'+(currData[i].recommendBool!=1?'不推荐':'推荐')+'</td>'
		    	+'<td>'+currData[i].sort+'</td>'
		    	+'<td>'
				+  '<a class="layui-btn layui-btn-mini links_edit links_del" data-id="'+currData[i].serviceID+'"><i class="iconfont icon-edit"></i> 修改</a>'
		        +'</td>'
		    	+'</tr>';
			}
		}else{
			dataHtml = '<tr><td colspan="12">暂无数据</td></tr>';
		}
	    return dataHtml;
	}
		
	//分页
	var nums = 5; //每页出现的数据量
	if(that){
		linksData = that;
	}
	laypage({
		cont : "page",
		pages : Math.ceil(linksData.length/nums),
		jump : function(obj){
			$(".links_content").html(renderDate(linksData,obj.curr));
			$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
