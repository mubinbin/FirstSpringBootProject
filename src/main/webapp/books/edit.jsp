<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Book Page</title>
</head>
<body>
	<h1>Edit Book</h1>
	
	<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put" />
		
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title"/>
			<form:input path="title" value="${book.title}"/>
		</p>
		
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description" value="${book.description}"/>
		</p>
		
		<p>
			<form:label path="language">Language</form:label>
			<form:errors path="language"/>
			<form:input path="language" value="${book.language}"/>
		</p>
		
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages"/>
			<form:input path="numberOfPages" value="${book.numberOfPages}"/>
		</p>
	
		<input type="submit" value="Submit"/>
	</form:form>
	
	<a href="/books/${book.id}"><button>Cancel</button></a>
</body>
</html>