function send(){
	 $.ajax({
	    type: "POST",
	    url: "http://localhost:8080/v1/api/admin/studentImages",
		enctype="multipart/form-data",
	});
]