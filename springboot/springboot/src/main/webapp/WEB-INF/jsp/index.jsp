<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

<div class="container">
	<h1>Index Page ${name}</h1>

    <form method="get" action="/">
        Course Name : <input type="text" name="courseName" value="${courseNameKey}" style="margin-bottom:10px">
        <br>
        Instructor Name : <input type="text" name="instructorName" value="${instructorNameKey}" style="margin-bottom:10px">
        <br>
        <button type="submit">Search</button>
    </form>
    
    <br><br>

    <table border="1" cellpadding="5">
        <tr>
            <td><B>ID</B></td>
            <td><b>Course Name</b></td>
            <td><b>Instructor</b></td>
            <td><b>Edit</b></td>
        </tr>
        <c:forEach items="${courses}" var="course">
            <tr>      
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td><a href="/course/edit?id=${course.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="include/footer.jsp" />