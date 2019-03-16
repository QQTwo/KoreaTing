layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var newsData = '';
	$.ajax({
		url : "../../json/newsList.json",
		type : "get",
		dataType : "json",
		success : function(data){
			newsData = data;
			if(window.sessionStorage.getItem("addLinks")){
				var addLinks = window.sessionStorage.getItem("addLinks");
				newsData = JSON.parse(addLinks).concat(newsData);
			}
			//执行加载数据的方法
			memberCheckList();
		}
	})
	
	//查询
	$(".search_btn").click(function(){
		var newArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "../../json/newsList.json",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addNews")){
							var addNews = window.sessionStorage.getItem("addNews");
							newsData = JSON.parse(addNews).concat(data);
						}else{
							newsData = data;
						}
						for(var i=0;i<newsData.length;i++){
							var newsStr = newsData[i];
							var selectStr = $(".search_input").val();
		            		function changeStr(data){
		            			var dataStr = '';
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//文章标题
		            		if(newsStr.newsName.indexOf(selectStr) > -1){
			            		newsStr["newsName"] = changeStr(newsStr.newsName);
		            		}
		            		//发布人
		            		if(newsStr.newsAuthor.indexOf(selectStr) > -1){
			            		newsStr["newsAuthor"] = changeStr(newsStr.newsAuthor);
		            		}
		            		//审核状态
		            		if(newsStr.newsStatus.indexOf(selectStr) > -1){
			            		newsStr["newsStatus"] = changeStr(newsStr.newsStatus);
		            		}
		            		//浏览权限
		            		if(newsStr.newsLook.indexOf(selectStr) > -1){
			            		newsStr["newsLook"] = changeStr(newsStr.newsLook);
		            		}
		            		//发布时间
		            		if(newsStr.newsTime.indexOf(selectStr) > -1){
			            		newsStr["newsTime"] = changeStr(newsStr.newsTime);
		            		}
		            		if(newsStr.newsName.indexOf(selectStr)>-1 || newsStr.newsAuthor.indexOf(selectStr)>-1 || newsStr.newsStatus.indexOf(selectStr)>-1 || newsStr.newsLook.indexOf(selectStr)>-1 || newsStr.newsTime.indexOf(selectStr)>-1){
		            			newArray.push(newsStr);
		            		}
		            	}
		            	newsData = newArray;
		            	memberCheckList(newsData);
					}
				})
            	
                layer.close(index);
            },2000);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	//编辑修改
	$("body").on("click",".memberCheck_edit",function(){  //编辑
		location.href="memberCheck_update.html"
	})
	//积分记录
	$("body").on("click",".score_record",function(){  //收藏.
		/*if($(this).text().indexOf("已收藏") > 0){
			layer.msg("取消收藏成功！");
			$(this).html("<i class='layui-icon'>&#xe600;</i> 收藏");
		}else{
			layer.msg("收藏成功！");
			$(this).html("<i class='iconfont icon-star'></i> 已收藏");
		}*/
		layer.alert('跳转至服务类型预约....',{icon:6, title:'服务类型预约'})
		location.href="../service/serviceOrder.html";
	})
	//评论
	$("body").on("click",".recommend",function(){  
		layer.alert('查看评论...',{icon:6, title:'评论区'});
		location.href="memberCheck_commend.html";
	})

	$("body").on("click",".news_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<newsData.length;i++){
				if(newsData[i].newsId == _this.attr("data-id")){
					newsData.splice(i,1);
					newsList(newsData);
				}
			}
			layer.close(index);
		});
	})

	function memberCheckList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = newsData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+'<td>'+(i+1)+'</td>'
			    	+'<td align="left">'+currData[i].newsName+'</td>'
			    	+'<td>'+currData[i].newsAuthor+'</td>'
			    	+'<td>会员组名称xxx</td>'
			    	+'<td>1017008965@qq.com</td>'
			    	+'<td>100</td>'
			    	+'<td>1010</td>';
			    	if(currData[i].newsStatus == "未验证"){
			    		dataHtml += '<td style="color:#f00">'+currData[i].newsStatus+'</td>';
			    	}else{
			    		dataHtml += '<td>'+currData[i].newsStatus+'</td>';
			    	}
			    	
			    	if(currData[i].isChecked == "0"){
			    		dataHtml += '<td style="color:#f00">未审核</td>';
			    	}else{
			    		dataHtml += '<td>审核通过</td>';
			    	}
			    	dataHtml += '<td>'
			    	
			    	+'<input type="checkbox" name="show" lay-skin="switch" lay-text="是|否" lay-filter="isShow"'+currData[i].isShow+'></td>'
			    	+'<td>开启</td>'
			    	+'<td>18596230152</td>'
			    	+'<td>2018-01-12 11:20</td>'
			    	+'<td>0</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini memberCheck_edit"><i class="iconfont icon-edit"></i> 编辑</a>'
					+  '<a class="layui-btn layui-btn-normal layui-btn-mini score_record"><i class="layui-icon layui-icon-survey">&#xe6b2;</i> 积分记录</a>'
					+  '<a class="layui-btn layui-btn-normal layui-btn-mini apply"><i class="layui-icon layui-icon-survey">&#xe6b2;</i> 申请鉴定</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini recommend" data-id="'+data[i].newsId+'"><i class="layui-icon layui-icon-reply-fill">&#xe611;</i> 评论</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 13; //每页出现的数据量
		if(that){
			newsData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(newsData.length/nums),
			jump : function(obj){
				$(".memberCheck_content").html(renderDate(newsData,obj.curr));
				$('.memberCheck_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
