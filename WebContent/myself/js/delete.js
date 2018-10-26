function p_del() { 
	var msg = "您真的确定要删除吗？\n\n删除后不能复原！"; 
	if (confirm(msg)==true){ 
		return true; 
	}else{ 
		return false; 
	}
}