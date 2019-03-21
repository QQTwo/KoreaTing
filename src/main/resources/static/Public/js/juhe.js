/*
 * 验证身份证
 * 参数：String cardno 身份证号码
 * */ 
function queryCard(cardno){
		$.getJSON("/http/cardno",{"cardno":cardno},function(json){
			if(json.error_code == "203801" || json.error_code == "203802" || json.error_code == "203803" || json.error_code == "203804"){
				layer.msg('身份证号输入有误，请重新输入！');
			}else {
				
			}
		});
 }
/*
 * 验证电话号
 * 参数：String phone 电话号码
 * */ 
function queryPhone(phone){
		$.getJSON("/http/phone",{"phone":phone},function(json){
			if(json.error_code == "201103" || json.error_code == "201101" || json.error_code == "201102"){
				layer.msg('电话号码输入有误，请重新输入！');
			}else {
				
			}
		});
 }