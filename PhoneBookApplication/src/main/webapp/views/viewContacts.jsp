<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view contact</title>

<script>
	function confirmdelete(){
		return confirm("are you sure you want to delete this contact?");
		}
	
</script>

</head>
<body>
	
	<h4>contact details</h4>
	<a href="loadForm">+Add New Contact</a><br/>
	<table border="1">
		<thead>
			<tr>
			<th>Contact Name</th>&nbsp;
			<th>Contact Number</th>&nbsp;
			<th>Contact Email</th>&nbsp;
			<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts }" var="c">
			<tr>
			<td>${c.contactName }</td>
			<td>${c.contactNumber }</td>
			<td>${c.contactEmail }</td>
			<td>
			<a href="edit?cid=${c.contactId}">Edit</a> &nbsp;
			<a href="delete?cid=${c.contactId}" onclick="return confirmdelete()">Delete</a> 
			</td>
			</tr>
			</c:forEach>
		</tbody>
		
		
	</table>
	
</body>
</html>