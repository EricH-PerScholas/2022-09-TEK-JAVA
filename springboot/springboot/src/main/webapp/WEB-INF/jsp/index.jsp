<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
</head>

<body>
	<h1>Index Page ${name}</h1>

    <form method="get" action="/">
        Search : <input type="text" name="search" value="${search}">
        <button type="submit">Search</button>
    </form>
    
    <br><br>

    <table border="1" cellpadding="5">
        <tr>
            <td><B>ID</B></td>
            <td><b>Name</b></td>
        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>      
                <td>${course.id}</td>
                <td>${course.name}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>