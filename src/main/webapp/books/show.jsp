<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Detail</title>
</head>
<body>
	<h1><c:out value="${currentBook.title}"/></h1>
	<p><a href="/books">Return to Homepage</a></p>
	<p><b>Language: </b><c:out value="${currentBook.language}"/></p>
	<p><b>Pages: </b><c:out value="${currentBook.numberOfPages}"/></p>
	<p><b>Description: </b></p>
	<p><c:out value="${currentBook.description}"/></p>
	
	<a href="/books/edit/${currentBook.id}">Edit</a>
	
	<form action="/books/${currentBook.id}" method = "post">
		<input type="hidden" name="_method" value="delete" />
		<input type="submit" value="Delete"/>
	</form>
</body>
</html>