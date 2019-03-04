layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var linksData = '';
	ReimburseVoFun();
	loadInfo(linksData);
//查询
	$(".search_btn").click(function(){
		ReimburseVoFun();
		var newArray = [];
		
		var index = layer.msg('更新中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
        	$.ajax({
				url : "/c/lzh/service/reimburseInfo",
				type : "post",
				dataType : "json",
				contentType:"application/json",
				data:JSON.stringify(layui.data('ReimburseVo')),
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
        },1000);
		
	})

	

	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].linksId == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								linksData.splice(i,1);
								linksList(linksData);
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },1000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
	})

	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		data.elem.checked;
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})
	
	
	//条件查询
	function ReimburseVoFun(){
		layui.data('ReimburseVo', {
			  key: 'refundid'
			  ,value: $("#refundid").val().trim()
		});
		layui.data('ReimburseVo', {
			  key: 'username'
			  ,value: $("#username").val().trim()
		});
		layui.data('ReimburseVo', {
			  key: 'refundstatus'
			  ,value: $("#refundstatus").val().trim()
		});
		layui.data('ReimburseVo', {
			  key: 'dateStart'
			  ,value: $("#dateStart").val().trim()
		});
		layui.data('ReimburseVo', {
			  key: 'dateEnd'
			  ,value: $("#dateEnd").val().trim()
		});
	}
	//查看
	$("body").on("click",".links_edit",function(){  //编辑
		window.sessionStorage.setItem("orderId",$(this).parents("tr").find(".links_del").attr("data-id"));
		window.location.href="../service/returnMoneyDetail.html";
	})

	//加载数据
	function loadInfo(linksData){
		$.ajax({
			url : "/c/lzh/service/reimburseInfo",
			type : "post",
			dataType : "json",
			contentType:"application/json",
			data:JSON.stringify(layui.data('ReimburseVo')),
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
			    	+'<td>'+currData[i].refundid+'</td>'
			    	+'<td align="center" valign="middle"><a href="/index.php/Admincp/order/info/id/100818/continue/aHR0cDovL3lwaHRpbmcuemdseGtqLmNvbS9pbmRleC5waHAvQWRtaW5jcC9PcmRlci9pbmRleC5odG1s.html">'+currData[i].orderid+'</a></td>'
			    	+'<td>'+currData[i].applicationtime+'</td>'
			    	+'<td>'+currData[i].username+'</td>'
			    	+'<td>'+currData[i].servicetitle+'</td>'
			    	+'<td>'+currData[i].applyrefundmoney+'</td>'
			    	+'<td style="color:'+(currData[i].refundstatus==3?'red':'')+';">'+(currData[i].refundstatus==1?'退款申请':currData[i].refundstatus==2?'不同意':currData[i].refundstatus==3?'申请管理员介入':currData[i].refundstatus==4?'管理员拒绝':currData[i].refundstatus==5?'退款完成':currData[i].refundstatus==6?'退款取消':'')+'  </td>'
			    	+'<td>'+(currData[i].audittime==null?"":currData[i].audittime)+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit links_del" data-id="'+data[i].orderid+'"><i class="iconfont icon-edit"></i> 查看</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="10">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 20; //每页出现的数据量
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
