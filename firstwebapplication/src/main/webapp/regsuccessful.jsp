<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% Integer empno = (Integer) request.getAttribute("empno");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="regs.css">
<title>Registration Successful </title>
</head>
<body>
    <nav class="navbar" id="nav">
		<form class="container-fluid justify-content-start">
		 <a href="./welcome"><button class="btn" id="home" type="button">Home</button></a> 
		  
		</form>
	  </nav>
 <form action="./login.html" id="form">
 <div>
        <h1>You are Successfully Registered !<br>
            Welcome to our Family...
                    </h1>
    </div>
    <div>
    <h1>Your Employee Id is : <%= empno %></h1>
    </div>
    <div>
        <input class="btn" id="log" type="submit" value="Login">
    </div>
    </form>
</body>
</html>