function downImage(){
	const w = $('#content').outerWidth(),
        		h = $('#content').outerHeight();
	var imgWidth = 595.28;//A4纸宽度
    var imgHeight = 592.28/w * h;
	 html2canvas($("#content"), {
		allowTaint: true,//允许跨域
		taintTest: false,
		background:'#FFFFFF',//设置背景色，页面中有图片不设置这个图片周围会出现细线
		 width: w,
		 height: h,
		 dpi: 230,				//设置分辨率，数值越大图片越清晰，生成文件越大300以上就没啥区别了
	 	onrendered: function (canvas) {
		 var url = canvas.toDataURL("image/png",1.0);//一定不能设置JPEG！
		  //以下代码为下载此图片功能
		  var triggerDownload = $("#downPng").attr("href", url).attr("download", "图片名.png");
		 	//triggerDownload[0].click();//下载图片
			//@param  p :竖版   l:横版
			//@param  pt:单位长度像素，mm:毫米
			//@param  a4:纸张大小
			//@param   还有一个可选参数 press，压缩属性，查了各种API都没有详细介绍的，都一带而过，没整明白怎么用
			var pdf = new jsPDF('p', 'pt', 'a4');
			//@param  url:64文件流
			//@param  png:文件流后缀
			//@param 20 :PDF左间距，另一个20就是右间距了
			//@param imgWidth: PDF宽度，另一个就是高度
			pdf.addImage(url, 'png', 20, 20, imgWidth-40,imgHeight-40);
			//文件名
			pdf.save(id+'.pdf'); 
			
	   }
});
}
