<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<title>医生主界面</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" type="text/css" href="css/folding_menu.css"/>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
</head>

<body>
	<div id="wrap">
		<div class="top_corner"></div>
		<div id="main_container">
			<div id="header">
				<div id="logo">
					<img src="picture/logo1.png"></img>
				</div>
				<div id="menu">
					<ul>
						<li><a href="#l" title="">首页</a></li>
						<li><a href="doctor/updateDoctorInfo.do" title="" target="_black">修改信息</a></li>
						<li><a href="#" title="">注销</a></li>
					</ul>
				</div>
			</div>



			<hr
				style="height:5px;border:none;margin-right:30px;border-top:5px ridge black;" />
			<span class="tip">${doctor.hospital.name}协同诊治平台</span>
			<img style="margin-left:5px" src="picture/slider_photo1.png"
				width="965" height="150" alt="" />


			<div class="center_content">
				<div class="home_section_left">
					<section id="conter"> <section id="help-left">
					<details class="menu" open> <summary>首页</summary>
					<ul>
						<li><a href="index_doctor/index.jsp" target="mainframe">首页</a></li>
					</ul>
					</details> <details class="menu" open> <summary>个人信息</summary>
					<ul>
						<li><a href="doctor/getDoctorInfo.do" target="mainframe">个人信息</a></li>
					</ul>
					</details> <details class="menu" open> <summary>综合查询</summary>
					<ul>
						<li><a href="doctor/seo.do" target="mainframe">综合查询</a></li>
					</ul>
					</details> <details class="menu" open> <summary>辅助诊治</summary>
					<ul>
						<li><a href="warning_setting/warning_search.jsp" target="mainframe">预警设置</a></li>
						<li><a href="warning_setting/warning_monitor.jsp" target="mainframe">预警监控</a></li>
					</ul>
					</details>
				</div>
				<iframe name="mainframe" src="index_doctor/index.jsp" 
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight"> </iframe>
			</div>

			<div class="footer">
				<div class="copyright">
					<a href="http://www.stu.edu.cn/" target="_blank">汕头大学</a> | <a href="http://www.baidu.com/" target="_blank">百度</a>
				</div>

				<div class="footer_links">
					<a class="current" href="#" title="">首页</a> <a href="#" title="">关于</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
