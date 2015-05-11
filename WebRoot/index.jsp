<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="hhm.zjicm.acgnavigationnets.database.impl.MenuImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page
	import="hhm.zjicm.acgnavigationnets.database.impl.IndexFrameImpl"%>
<%@page import="hhm.zjicm.acgnavigationnets.database.pojo.IndexFrame"%>
<%@page import="hhm.zjicm.acgnavitionnets.database.tool.ResultSetTool"%>
<%@page
	import="hhm.zjicm.acgnavigationnets.database.impl.IndexAccordionImpl"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<!-- jquert_1.9.1 -->
	<script type="text/javascript" src="jquery/jquery-1.9.1.js"></script>
	<script>
	var jquery1_9_1 = jQuery.noConflict(true);
</script>

	<!-- jquert_1.7.1 -->
	<script type="text/javascript" src="jquery/jquery-1.7.1.js"></script>
	<script>
	var jquery1_7_1 = jQuery.noConflict(true);
</script>

	<script type="text/javascript" src="jquery/jquery-1.4.2.js"></script>
	<script>
	var jquery1_4_2 = jQuery.noConflict(true);
</script>

	<!-- 导航栏的jquery -->
	<script type="text/javascript"
		src="jquery/IndexFrame/IndexFrameIcon.js"></script>
	<!-- 折叠导航栏的jquery -->
	<script type="text/javascript"
		src="jquery/IndexAccordion/IndexAccordion.js"></script>
	<!-- 菜单栏的jquery -->
	<script type="text/javascript"
		src="jquery/NavigationMenu/MenuNavigation.js"></script>







	<!-- 菜单栏的css -->
	<link rel="stylesheet" type="text/css"
		href="css/NavigationMenu/NavigationMenu_SAO.css">
	<!-- 百度搜索栏的css -->
	<link rel="stylesheet" type="text/css"
		href="css/SearchBar/SearchBar.css">
	<!-- 导航栏的css -->
	<link rel="stylesheet" type="text/css"
		href="css/IndexFrame/IndexFrame.css">
	<!-- 折叠导航栏的css -->
	<link rel="stylesheet" type="text/css"
		href="css/IndexAccordion/IndexAccordion.css">
	<%
		MenuImpl menuImpl = new MenuImpl();
		IndexFrameImpl indexFrameImpl = new IndexFrameImpl();
		IndexAccordionImpl indexAccordionImpl = new IndexAccordionImpl();
		ResultSetTool resultSetTool = new ResultSetTool();
	%>
	<body>

		<OBJECT WIDTH="600px" HEIGHT="300px">
			<PARAM NAME=movie VALUE="路径/文件名.swf">
			<EMBED src="flash/Trans-Am.swf" WIDTH="1000px" HEIGHT="500px"
				NAME="2" ALIGN=""></EMBED>
		</OBJECT>



		<!--  搜索栏 开始 -->
		<section id="SearchBar">
		<header id="SearchBar_LogoText"></header>
		<form action="http://www.baidu.com/baidu" target="_blank">
			<table>
				<tr>
					<td>
						<input name=tn type=hidden value=baidu>
						<input type=text name=word size=30 id="BaiduSearchInput">
						<input type="submit" class="BaiduSearchSubmit" value="">
					</td>
				</tr>
			</table>
		</form>
		</section>

		<!--  搜索栏 结束 -->












		<ul id="NavigationMenu_SAO">
			<%
				//在这里输入菜单名作为参数，读取出菜单名与MenuID
				int MenuID = menuImpl.GetMenuIDByName("SwordArtOnline");
				//再用MenuID作为参数,读取出menufirst的数据
				ResultSet rs_menufirst = menuImpl.GetMenuFirstByID(MenuID);
			%>

			<%
				while (rs_menufirst.next()) {
			%>
			<li>
				<a href="#"> <%=rs_menufirst.getString("MenuFirstName")%> </a>


				<%
					//在这里获取MenuFirstID作为参数，读取出menusecond的值
						int MenuFirstID = rs_menufirst.getInt("MenuFirstID");
						ResultSet rs_menusecond = menuImpl
								.GetMenuSecondByID(MenuFirstID);
				%>
				<ul style="display: none;">

					<%
						while (rs_menusecond.next()) {
					%>
					<li>
						<a> <%=rs_menusecond.getString("MenuSecondName")%> </a>
					</li>


					<%
						}
					%>
				</ul>

			</li>

			<%
				}
			%>





		</ul>















		<%
			int IndexFrameID = indexFrameImpl.GetIndexFrameIDByName("OnePiece");
			ResultSet rs_IndexFrameSecond = indexFrameImpl
					.GetIndexFrameSecondByID(IndexFrameID);
			//首先设置好表格的列数
			int column = 6;
			//设置好表格的行数
			int rows = 8;
			//定义一个二维数组
			IndexFrame IndexFrameArr[][] = resultSetTool.getIndexFrameArray(
					rs_IndexFrameSecond, 6, 8);
		%>

		<table class="IndexFrameTable">
			<%
				for (int i = 0; i < column; i++) {
			%>
			<tr class="">
				<%
					for (int j = 0; j < rows; j++) {
				%>
				<td class="IndexFrameName_<%=IndexFrameID%>_<%=i%>_<%=j%>">
					<%=IndexFrameArr[i][j].getIndexFrameName()%>
				</td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>




		</table>







		<div id="IndexAccordion">
			<%
				//获取导航ID
				int IndexAccordionID = indexAccordionImpl
						.GetIndexAccordionIDByName("Conan");

				ResultSet rs_accordionFirst = indexAccordionImpl.GetIndexAccordionFirstByID(IndexAccordionID);
			%>
			<ul class="accordion">

				<%
					while (rs_accordionFirst.next()) {
				%>



				<li id="one" class="files">
					<a href="#"><%=rs_accordionFirst.getString("IndexAccordionFirstName")%><span>495</span>
					</a>
					<ul class="sub-menu">

						<%
							int IndexAccordionFirstID = rs_accordionFirst
										.getInt("IndexAccordionFirstID");
								ResultSet rs_IndexAccordionSecond = indexAccordionImpl
										.GetIndexAccordionSecondByID(IndexAccordionFirstID);
						%>
						<%
							while (rs_IndexAccordionSecond.next()) {
						%>
						<li>
							<a href="#"><em>01</em><%=rs_IndexAccordionSecond
							.getString("IndexAccordionSecondName")%><span>42</span>
							</a>
						</li>
						<%
							}
						%>
					</ul>
				</li>


				<%
					}
				%>
			</ul>
		</div>






	</body>
</html>
