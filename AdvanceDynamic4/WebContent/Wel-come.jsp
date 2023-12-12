<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	width: 100px;
	height: 50px;
	background-color: rgb(11, 156, 11);
	color: white;
	font-size: 20px;
	border-style: none;
	border-radius: 10px;
}

button:hover {
	background-color: rgb(4, 99, 4);
}

b:hover {
	font-weight: normal;
}
 legend{
      background-color: aqua;
    }
    fieldset{
      height: 250px;
      width: 300px;
    }


</style>
</head>
<body>
	<h3 align="center">
		<font size="20px" color="red"><hr>Welcome to Servlet
			</hr> </font>
		<p>
		<hr>
		Welcome to Servlet
		</hr>
		</p>
		<button>click</button>
		<br> <b>Welcome to css session</b><br>	
	</h3>
	<center>
	<fieldset  >
      <legend><b>Details :</b></legend>
    <table align="center">
        <tr>
          <th style="color:blue;">First Name :</th>
          <td><input type="text" name="fname"></td>
        </tr>
        <tr>
          <th style="color: blue;">Last Name :</th>
          <td><input type="text" name="lname"></td>
        </tr>
        <tr>
          <th style="color: blue;" >Gender :-</th>
          <td style="color: aqua;"><input type="radio" name="fname">male
          <input type="radio" name="fname">female
          <input type="radio" name="fname">other</td>
        </tr>
        <tr>
          <th style="color: blue;">Email :</th>
          <td><input type="text" name="email"></td>
        </tr>
        <tr>
          <th style="color: blue;">password :</th>
          <td><input type="password" name="pass"></td>
        </tr>
        <tr>
          <th style="color: blue;"> DOB:</th>
          <td><input type="date" name="lname"></td>
        </tr>
        <tr>
          <th ></th>
          <td><a href="Student.txt"></a><button>Submit</button></td>
          <td></td>
        </tr>
        
    </table>
  </fieldset>
  </center>
</body>
</html>