function toPage() {
    console.log("123")
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var type
    if ($("#sel option:selected").text() == "我是管理员") {
        type = 1
    }
    else if ($("#sel option:selected").text() == "我是学生") {
        type = 0
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/v1/api/user_login/login",
        async: true,
        Accept: "application/json",
        contentType: "application/json",
        data: JSON.stringify({
            "type": type,
            "username": username,
            "password": password,
        }),
        success: function (data) {
            console.log(data)
            if (data.code == 0) {
                if (type == 1) {
                    window.location.href = "administrator.html"
                }
                else if (type == 0) {
                    window.location.href = "student.html"
                }
            }
            else {
                alert("用户名或密码错误");
            }
        },
        //departmentID = data.data[0].departmentId
    });
}
