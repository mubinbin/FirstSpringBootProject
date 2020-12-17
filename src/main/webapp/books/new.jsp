<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Book</title>
</head>
<body>
	<form:form action="/books" method="post" modelAttribute="book">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</p>
		
		<p>
			<form:label path="language">Language</form:label>
			<form:errors path="language"/>
			<form:input path="language"/>
		</p>
		
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages"/>
			<form:input path="numberOfPages"/>
		</p>
	
		<input type="submit" value="Submit"/>
	</form:form>

		<a href="/books"><button>Cancel</button></a>
</body>
</html>