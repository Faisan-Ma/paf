<%@page import="com.Unit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%
 if (request.getParameter("unitid") != null)
{
 PowerUnit unitObj = new PowerUnit();
 
 String stsMsg = unitObj.insertItem(request.getParameter("unitid"),
		 request.getParameter("accountNo"),
		 request.getParameter("CusName"),
		 request.getParameter("unit"));
          request.getParameter("month");
          request.getParameter("amount");
          
 
		 session.setAttribute("statusMsg", stsMsg);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Power Usage</title>
</head>
<body>
	<h1>Power Usage</h1>
	<form method="post" action="unit.jsp">
		Unit Id: <input name="unitId" type="text" ><br>
 		Power Unit: <input name="powerUnit" type="text" ><br>
 		User Name: <input name="userName" type="text" ><br>
		Unit Amount: <input name="unitAmount" type="text" ><br>
		Account Number: <input name="accountNumber" type="text" ><br>
		Month: <input name="month" type="text" ><br>
		<input name="btnSubmit" type="submit" value="Save">
	</form>
	<br>
	
	<table border="1">
 		<tr>
 			<th>Unit Id</th>
			<th>Power Unit</th>
			<th>User Name</th>
			<th>Unit Amount</th>
			<th>Account Number</th>
			<th>Month</th>
			<th>Update</th>
			<th>Remove</th>
 		</tr>
 		<tr>
 			<td><%out.print(session.getAttribute("unitId")); %></td>
 			<td><%out.print(session.getAttribute("powerUnit")); %></td>
 			<td><%out.print(session.getAttribute("userName")); %></td>
			<td><%out.print(session.getAttribute("unitAmount")); %></td>
			<td><%out.print(session.getAttribute("accountNumber")); %></td>
			<td><%out.print(session.getAttribute("month")); %></td>
 			<td><input name="btnUpdate" type="button" value="Update"></td>
			<td><input name="btnRemove" type="button" value="Remove"></td>
 		</tr>
	</table>
</body>
</html>