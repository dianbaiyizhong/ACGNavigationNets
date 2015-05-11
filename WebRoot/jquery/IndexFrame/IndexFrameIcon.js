//设置行数(需手动)
var column = 6;
// 设置列数(需手动)
var rows = 8;
// 设置导航ID(需手动)
var IndexFrameID = 2;
// 图片宽度
var picImageWidth;
// 图片长度
var picImageHeight;
// 图片地址(需手动)
var picPath = "/ACGNavigationNets/image/IndexFrame/bleach.jpg";

jquery1_4_2(document).ready(function() {

	LoadBG();
});

function LoadBG() {

	var image = new Image();
	image.src = picPath;

	picImageWidth = image.width;
	picImageHeight = image.height;

	SetBG();

}

/** 为表格中的td设置背景* */
function SetBG() {
	var everyWidth = picImageWidth / rows;

	var everyHeight = picImageHeight / column;

	for ( var i = 0; i < column; i++) {
		for ( var j = 0; j < rows; j++) {
			var Node_td = jquery1_9_1(".IndexFrameName" + "_" + IndexFrameID
					+ "_" + (column - i - 1) + "_" + (rows - j - 1));
			var url = "url(" + picPath + ")";

			var width = everyWidth * (j + 1) + "px";
			var height = everyHeight * (i + 1) + "px";
			Node_td.css("background-image", url).css("background-position",
					width + " " + height).css("width", everyWidth).css(
					"height", everyHeight);



		}

	}

}

/** 为表格中的td设置点击背景* */
function SetBG_HOVER() {

}
