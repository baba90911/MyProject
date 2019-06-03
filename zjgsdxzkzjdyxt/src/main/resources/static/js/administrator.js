var ip ="http://localhost:8080";
function importdata() {
	var formData = new FormData();
	formData.append('excelfile', document.getElementById("efile").files[0]);
	$.ajax({
			type: "POST",
			url: ip+"/v1/api/admin/import_student",
			data: formData,
			processData: false,
			contentType : false,
			Accept: "application/json",
			contentType: "multipart/form-data",
			success: function(data) {
				console.log("1111");
			},
			error: function(data) {
				console.log("0000");
			},
		});
}
function cetf(){
	console.log("123");
	/*$.ajax({
			type: "GET",
			url: ip+"/v1/api/admin/import_student",
			data:{
				number:
			}
			success: function(data) {
				console.log("1111");
			},
			error: function(data) {
				console.log("0000");
			},
		});*/
}
function cets(){
	console.log("456");
}
function change(){
	console.log("789");
	if ($("select").val()=="大学外语cet4等级考试准考证"){
		cetf();
	}
	else if($("select").val()=="大学外语cet6等级考试准考证"){
		cets();
	}
}
