<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp">
    <jsp:param name="title" value="Create New User" />
</jsp:include>
<body>
<jsp:include page="templates/navigation-bar.html" />
<div class="container">
    <div class="row justify-content-center">
        <h1>Create New User</h1>
    </div>
    <form>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="username">Username:</label>
            <div class="col-md-10">
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-2 col-form-label" for="password">Password:</label>
            <div class="col-md-10">
                <input type="password" id="password" name="password" class="form-control" required>
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
                <input type="email" id="email" name="email" class="form-control">
            </div>
        </div>
        <div class="form-check row">
            <input id="input-user-administrator" type="radio" name="user-type" value="administrator" required>
            <label for="input-user-administrator">Administrator</label>
        </div>
        <div class="form-check row">
            <input id="input-user-owner" type="radio" name="user-type" value="owner">
            <label for="input-user-owner">Owner</label>
        </div>
        <div class="form-check row">
            <input id="input-user-customer" type="radio" name="user-type" value="customer" checked>
            <label for="input-user-customer">Customer</label>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <button type="reset" class="btn btn-warning">Reset</button>
    </form>
<div>
<jsp:include page="templates/scripts.html" />
</body>
</html>