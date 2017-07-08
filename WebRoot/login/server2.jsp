<%@ page language="java" import="java.util.*,com.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'server2.jsp' starting page</title>
    
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
        
        String name = request.getParameter("us");
        String passwd = request.getParameter("p");
        
        System.out.println(name);
        int flag = User.log(name,passwd);
        User a= User.search(name);
        if(flag == 1){
        	session.setAttribute("user", a);//add user
           out.println("<script>alert(\"登录成功！\");top.location='blog/index.jsp';</script>");
        }else{
           out.println("<script>alert(\"登录失败！\");top.location='login/index.jsp';</script>");
        }
     %>
  </body>
</html>
