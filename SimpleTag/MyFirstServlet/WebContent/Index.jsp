<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>index page</title>
</head>
<body>
<h1>Hi! <%= request.getAttribute("myname") %>.</h1>   this is my first Servlet!!!
there have <%=request.getAttribute("cont") %> people online!!
   <!-- 新增logout button -->
	<form action='Logout'  method="post">
		<input name="button" type="submit" id="button" value="Logout">
	</form> 

</body>
</html>