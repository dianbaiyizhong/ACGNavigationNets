//��������(���ֶ�)
var column = 6;
// ��������(���ֶ�)
var rows = 8;
// ���õ���ID(���ֶ�)
var IndexFrameID = 2;
// ͼƬ���
var picImageWidth;
// ͼƬ����
var picImageHeight;
// ͼƬ��ַ(���ֶ�)
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

/** Ϊ����е�td���ñ���* */
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

/** Ϊ����е�td���õ������* */
function SetBG_HOVER() {

}
