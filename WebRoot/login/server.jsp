<%@ page language="java" import="java.util.*,com.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'server.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <%  
     	  User.read();
          String name = request.getParameter("user");
          String passwd = request.getParameter("passwd");
  		  int flag = User.reg(name,passwd);
          if(flag == 1){
             out.println("<script>alert(\"注册成功！\");top.location='index.jsp';</script>");
          }else{
             out.println("<script>alert(\"注册失败！\");top.location='index.jsp';</script>");
          }
     %>
  </body>
</html>
