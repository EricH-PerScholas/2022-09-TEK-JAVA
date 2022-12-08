<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="container">
	<div class="row mt-3 mb-1">
		<c:if test="${empty form.id}">
			<h2>Create Course</h2>
		</c:if>
		<c:if test="${not empty form.id}">
			<h2>Edit Course</h2>
		</c:if>
	</div>

    <c:if test="${bindingResult.hasErrors()}">
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mb-0" style="color:red">${error.getDefaultMessage()}</p>
        </c:forEach>
    </c:if>

    <form action="/course/save" method="POST"> 
        <input type="hidden" name="id" value="${form.id}"/>

        <div class="row">
            <div class="mb-3 col-6">
                <label for="courseName" class="form-label">Course Name</label>
                <input type="text" value="${form.courseName}" name="courseName" class="form-control" id="courseName" aria-describedby="courseNameHelp">
                <div id="courseNameHelp" class="form-text">Please give us your course name</div>
            </div>

            <div class="mb-3 col-6">
                <label for="instructor" class="form-label">Instructor</label>
                <input type="text" value="${form.instructor}" name="instructor" class="form-control" id="instructor" aria-describedby="instructorHelp">
                <div id="instructorHelp" class="form-text">Please give us your last name</div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="../include/footer.jsp" />
