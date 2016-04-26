<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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


<link rel="stylesheet" type="text/css" href="css/info_style.css">
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
</head>
<style>
	#help-left{width:680px;font-family:'microsoft YaHei';float:left}
	.menu input{width:150px}
</style>


<body>
	<section id="conter"> 
	<section id="help-left"> 
	<details class="menu" open> <summary>基本信息</summary>
		<div align="center">
		<table border="0" cellspacing="2px" cellpadding="6px">
		<tr>
						<td class="td_2">用户名</td>
						<td><input type="text" id="username" name="username" 
							readonly="readonly"/> 
						</td>
						<td class="td_2">姓名</td>
						<td class="td_3"><input type="text" id="realname"
							name="realname" readonly="readonly"/>
						</td>
						<td colspan="2" rowspan="4" align="center">
							<div id="preview">
            					<img id="imghead" width=100 height=120 border=0 src='<%=request.getContextPath()%>/picture/pic_user.gif'/>
        					</div>
						</td>
					</tr>
					<tr>
						<td class="td_2">ID</td>
						<td class="td_3"><input type="text" id="id2"
							name="id2" readonly="readonly"/>
						</td>
						<td class="td_2">民族</td>
						<td class="td_3"><input type="text" id="nation" name="nation"
							readonly="readonly"> 
						</td>
					<tr/>
					<tr>
						<td class="td_2">年龄</td>
						<td class="td_3"><input type="text" id="age" name="age"
							readonly="readonly">
						</td>
						<td class="td_2">性别</td>
						<td class="td_3"><input type="text" id="gender"
							name="gender" readonly="readonly"/>
						</td>
						</td>
					</tr>
					<tr>
						<td class="td_2">职业</td>
						<td class="td_3"><input type="text" id=profession
							name="profession" readonly="readonly">
						</td>
						<td class="td_2">身份证</td>
						<td class="td_3"><input type="text" id="id2" name="id2" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="td_2">医保号</td>
						<td class="td_3"><input type="text" id="hin" name="hin" readonly="readonly"></td>
						<td class="td_2">文化程度</td>
						<td class="td_3"><input type="text" id="education" name="education"
							readonly="readonly">
						<td class="td_2">医生</td>
						<td class="td_3"><input type="text" id="doctor_id" name="doctor_id"
							readonly="readonly">
						</td>
					</tr>
					<tr>
						<td class="td_2">婚姻状况</td>
						<td class="td_3"><input type="text" id="marriage" name="marriage"
							readonly="readonly">
						<td class="td_2">联系电话</td>
						<td class="td_3"><input type="text" id="tele" name="tele"
							readonly="readonly"> 
						</td>
						<td class="td_2">医院</td>
						<td class="td_3"><input type="text"name="Hospital" id="Hospital"
							readonly="readonly">
						</td>
					</tr>
		</table>
		</div>
	</details>
	<details class="menu" open> <summary>家庭信息</summary>
		<div align="center">
		<table border="0" cellspacing="2px" cellpadding="6px">
			<tr>
					<td class="td_2">家属姓名</td>
					<td class="td_3"><input type="text" id="fname1" name="fname1" readonly="readonly"> 
					</td>
					<td class="td_2">关系</td>
					<td class="td_3"><input type="text" id="relationship1" name="relationship1" readonly="readonly"> 
					</td>
					<td class="td_2">家属电话</td>
					<td class="td_3"><input type="text" id="tele1" name="tele1" readonly="readonly">
					</td>
			</tr>
			<tr>
					<td class="td_2">家属姓名</td>
					<td class="td_3"><input type="text" id="fname2" name="fname2" readonly="readonly"> 
					</td>
					<td class="td_2">关系</td>
					<td class="td_3"><input type="text" id="relationship2" name="relationship2" readonly="readonly"> 
					</td>
					<td class="td_2">家属电话</td>
					<td class="td_3"><input type="text" id="tele2" name="tele2" readonly="readonly">
					</td>
			</tr>
		</table>
		</div>
	</details>
	<details class="menu" open> <summary>病历信息</summary>
		<div align="center">
		<table border="0" cellspacing="2" cellpadding="6px">
			<tr>
					<td class="td_2">高血压</td>
					<td class="td_3"><input type="text" id="htnstate" name="htnstate" readonly="readonly">
					</td>
					<td>高血糖</td>
					<td><input type="text" id="glustate" name="glustate" readonly="readonly">
					</td>
					<td>高血脂</td>
					<td><input type="text" id="hplstate" name="hplstate" readonly="readonly"/>
					</td>
			</tr>
			<tr>
					<td id="class">患病史</td>
					<td colspan="5"><input style="width:500px" type="text" id="his_1"
						name="illnesshistory" readonly="readonly">
					</td>
			</tr>
			<tr>
					<td class="td_2">过敏史</td>
					<td colspan="5"><input style="width:500px" type="text" id="his_2"
						name="allergichistory" readonly="readonly">
					</td>
			</tr>
			<tr>
					<td class="td_2">家族病史</td>
					<td colspan="5"><input style="width:500px" type="text" id="his_3"
						name="familymedicalhistory" readonly="readonly">
					</td>
			</tr>
		</table>
		</div>
	</details>
	
	<details class="menu" before> <summary>临床数据</summary>
		<div align="center">
		<table border="0" cellspacing="2" cellpadding="6px">
		</table>
		</div>
	</details>
	<button class="fb" style="margin-left:580px;" 
			onclick="location.href='medical_manage/doctor_mmed.jsp'">添加医嘱</button>
	</section>
	</section>
</body>
</html>
