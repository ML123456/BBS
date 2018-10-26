//窗口效果
//点击登录class为tc 显示
$("#tc").click(function() {
	$(".body-floor").show();
	$(".pinglun").show();
	// $("#popup").show();//查找ID为popup的DIV show()显示#gray
	// tc_center();
});
// 点击关闭按钮
$(".guanbi").click(function() {
	$(".body-floor").hide();
	$(".pinglun").hide();// 查找ID为popup的DIV hide()隐藏
})