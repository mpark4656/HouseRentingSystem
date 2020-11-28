<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp">
    <jsp:param name="title" value="House Rental System" />
</jsp:include>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <h1>House Rental System</h1>
        </div>
        <div class="row justify-content-center">
            <form action="login.jsp">
                <div class="form-group">
                    <label for="input-username">Username:</label>
                    <input type="text" id="input-username" name="username" class="form-control" required />
                </div>
                <div class="form-group">
                    <label for="input-password">Password:</label>
                    <input type="password" id="input-password" name="password" class="form-control" required>
                </div>
                <div class="form-group">
                    <p>Login As</p>
                    <div class="form-check">
                        <input id="radio-customer" class="form-check-input"
                               type="radio" name="login-type" value="customer" required />
                        <label for="radio-customer" class="form-check-label">Renter</label>
                    </div>
                    <div class="form-check">
                        <input id="radio-owner" class="form-check-input"
                               type="radio" name="login-type" value="owner" />
                        <label for="radio-owner" class="form-check-label">Home Owner</label>
                    </div>
                    <div class="form-check">
                        <input id="radio-administrator" class="form-check-input"
                               type="radio" name="login-type" value="administrator" />
                        <label for="radio-administrator" class="form-check-label">Administrator</label>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Sign In</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="templates/scripts.html" />
</body>
</html>