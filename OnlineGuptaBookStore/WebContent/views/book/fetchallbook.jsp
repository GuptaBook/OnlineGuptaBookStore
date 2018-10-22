<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fetch all books</title>
</head>
<body>
 <c:if test = "${booklis == null}">
 <p>No match found</p>
</c:if>
	<ul>
		<c:forEach items="${booklist}" var="lb">
		<img src="<c:url value='resources/images/uploadDir/${lb.getBookid()}.png'/>" alt="noimg">
			<li><a href="FetchBookByIdServlet?id=${lb.bookid}"> ${lb.bookname}<br>${lb.price}<br>
			</a><br></li>
		</c:forEach>
	</ul>
</body>
</html>