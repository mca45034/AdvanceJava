<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserRagistractionCtl" method="post">
		<table>
		<tr>
				<th>UserID:</th>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<th>First name:</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>Last name:</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>Login Id:</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><button>submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>