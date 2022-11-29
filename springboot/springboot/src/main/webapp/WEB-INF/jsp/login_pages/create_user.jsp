<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div class="container">
	<div class="row mt-3 mb-1">
		<h2>Create User</h2>
	</div>

    <form action="/user/createuser">        
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        
        <div class="row">
            <div class="mb-3 col-6">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1">
            </div>

            <div class="mb-3 col-6">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" name="confirmPassword" class="form-control" id="confirmPassword">
            </div>
        </div>

        <div class="row">
            <div class="mb-3 col-6">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
                <div id="fristNameHelp" class="form-text">Please give us your first name</div>
            </div>

            <div class="mb-3 col-6">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text">Please give us your last name</div>
            </div>
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" name="address" class="form-control" id="address" aria-describedby="addressHelp">
            <div id="addressHelp" class="form-text">We want to send you physical advertisements every day</div>
        </div>

        <div class="row">
            <div class="mb-3 col-4">
                <label for="city" class="form-label">City</label>
                <input type="text" name="city" class="form-control" id="city" aria-describedby="cityHelp">
                <div id="cityHelp" class="form-text"></div>
            </div>

            <div class="mb-3 col-4">
                <label for="state" class="form-label">State</label>
                <input type="text" name="state" class="form-control" id="state" aria-describedby="stateHelp">
                <div id="stateHelp" class="form-text"></div>
            </div>

            <div class="mb-3 col-4">
                <label for="zip" class="form-label">Zip</label>
                <input type="text" name="zip" class="form-control" id="zip" aria-describedby="zipHelp">
                <div id="zipHelp" class="form-text"></div>
            </div>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" name="phone" class="form-control" id="phone" aria-describedby="phoneHelp">
            <div id="phoneHelp" class="form-text">We will send you text messages even if you unsubscribe</div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="../include/footer.jsp" />
