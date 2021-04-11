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

        <button type="submit" class="btn btn-primary">Create</button>
        <button type="reset" class="btn btn-warning">Reset</button>
    </form>
<div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="rental-form-validation.js,create-user.js" />
</jsp:include>
</body>
</html>