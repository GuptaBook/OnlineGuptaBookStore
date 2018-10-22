<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${bookdetail.bookname} details</title>
</head>
<body>
<ul>
			<li><a href="FetchBookByIdServlet?id=${bookdetail.bookid}"> ${bookdetail.bookname}<br>${bookdetail.bookdesc}
			<br>${bookdetail.price}<br><a href="" clas="btn btn-info">Add to cart</a>&nbsp; <a href="" class="btn btn-info">Buy Now</a>
			</a><br></li>
	</ul>
</body>
</html>