<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>My First servlet</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<div>
			<table>
				<tr>
					<td>
						<h1>User Name:</h1>
						<input type="text" name="name" />
					</td>
				</tr>
				<tr>
					<td>
						<h2>Password:</h2>
						<input type="password" name="mypassword"> <input
						type="submit" value="submit">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>