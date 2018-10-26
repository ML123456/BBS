/*
 * 编辑个人资料
 */
$(".p-tc").click(function() {
	$(".b-center").show();
	$(".f-center").hide();//发帖框隐藏
	$(".up-center").hide();//修改帖子框隐藏
});
// 点击关闭按钮
$(".p-guanbi").click(function() {
	$(".b-center").hide();
})

/*
 * 发帖
 */
//点击登录class为tc 显示
$(".f-tc").click(function() {
	$(".f-center").show();
	$(".b-center").hide();//编辑个人资料框隐藏
	$(".up-center").hide();//修改帖子框隐藏
});
// 点击关闭按钮
$(".f-guanbi").click(function() {
	$(".f-center").hide();
})





























/*
 * 修改帖子
 */
/*//点击登录class为tc 显示
$(".xiugai").click(function() {
	$(".up-center").show();
	$(".f-center").hide();//发帖框隐藏
	$(".b-center").hide();//编辑个人资料框隐藏
});
// 点击关闭按钮
$(".up-guanbi").click(function() {
	$(".up-center").hide();
})*/