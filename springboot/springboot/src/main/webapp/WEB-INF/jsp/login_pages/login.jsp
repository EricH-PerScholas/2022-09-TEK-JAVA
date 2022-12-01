<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

    <div class="container">
        <div class="row mt-3 mb-1">
            <h2>Login</h2>
        </div>

        <form action="" method="POST">
            <div class="mt-2 mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="username" name="username" class="form-control" id="username"
                    aria-describedby="usernameHelp">
                <div id="usernameHelp" class="form-text">Enter your username</div>
            </div>
            <div class="mt-2 mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password"
                    aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Enter your password</div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

<jsp:include page="../include/footer.jsp" />