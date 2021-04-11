<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="Create New Rental Posting" />
    <jsp:param name="stylesheets" value="form-validation.css,create-user.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div id="success-alert" class="alert alert-success" role="alert">
    <p id="alert-message" class="text-center"></p>
</div>
<div class="container">
    <div class="row justify-content-center">
        <h1>Create New Rental Posting</h1>
    </div>
    <form id="rental-create-form" class="validation-form">
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="username">Username:</label>
            <div class="col-md-10">
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="password">Password:</label>
            <div class="col-md-10">
                <input type="password"
                    id="password"
                    name="password"
                    class="form-control password-popover-reset password"
                    required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="password-confirm">Confirm Password:</label>
            <div class="col-md-10">
                <input
                    type="password"
                    id="password-confirm"
                    class="form-control password-popover-reset password-confirm"
                    data-toggle="popover"
                    title="Password Confirmation"
                    data-content="Passwords do not match."
                    placeholder="Re-enter Password"
                    required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="first-name">First Name:</label>
            <div class="col-md-10">
                <input type="text" id="first-name" name="firstname" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="last-name">Last Name:</label>
            <div class="col-md-10">
                <input type="text" id="last-name" name="lastname" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="email">Email:</label>
            <div class="col-md-10">
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
        </div>
        <span class="checkbox-validation-message">You must select at least one role for this user.</span>
        <div class="form-check row">
            <input id="input-user-administrator"
                type="checkbox"
                name="user-roles"
                value="administrator"
                class="checkbox-validation">
            <label for="input-user-administrator">Administrator</label>
        </div>
        <div class="form-check row">
            <input id="input-user-owner"
                type="checkbox"
                name="user-roles"
                value="owner"
                class="checkbox-validation">
            <label for="input-user-owner">Owner</label>
        </div>
        <div class="form-check row">
            <input id="input-user-customer"
                type="checkbox"
                name="user-roles"
                value="customer"
                class="checkbox-validation">
            <label for="input-user-customer">Customer</label>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <button type="reset" class="btn btn-warning">Reset</button>
    </form>
<div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="rental-form-validation.js,create-user.js" />
</jsp:include>
</body>
</html>