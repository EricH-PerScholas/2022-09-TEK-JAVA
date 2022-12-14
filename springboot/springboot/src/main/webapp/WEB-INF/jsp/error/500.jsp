<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="container">
	<h1>500 error page</h1>
	
	<div style="margin-left:30px">

	    <c:if test="${not empty requestUrl}">
	      <p>${requestUrl}</p>
	    </c:if>
	    <h3>Stack Trace</h3>
	    <c:if test="${not empty message}">
	      <p>${message}</p>
	    </c:if>
	    <c:if test="${not empty stackTrace}">
	      <p>${stackTrace}</p>
	    </c:if>
	    <h3>Root Cause</h3>
	    <c:if test="${not empty rootcause}">
	      <p>${rootcause}</p>
	    </c:if>
	     <c:if test="${not empty rootTrace}">
	      <p>${roottrace}</p>
	    </c:if>
	</div>
    
</div>
	
	
	
</div>

<jsp:include page="../include/footer.jsp" />