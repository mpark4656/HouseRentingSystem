<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="Create New Rental Posting" />
    <jsp:param name="stylesheets" value="default.css" />
</jsp:include>
<body>
<jsp:include page="/templates/navigation-bar.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <h1>Create New Rental</h1>
    </div>
    <form id="rental-create-form">
        <div class="form-group row">
            <label for="num-of-rooms" class="col-md-2 col-form-label">Number of Rooms:</label>
            <div class="col-md-2">
                <input id="num-of-rooms"
                       name="num-of-rooms"
                       type="number"
                       class="form-control"
                       min="1"
                       max="300"
                       step="1"
                       required>
            </div>
        </div>
        <div class="form-group row">
            <label for="rent" class="col-md-2 col-form-label">Rent per Month:</label>
            <div class="col-md-2">
                <input id="rent"
                       name="rent"
                       type="number"
                       min="0"
                       step="any"
                       class="form-control"
                       required>
            </div>
        </div>
        <div class="form-group row">
            <label for="locality" class="col-md-2 col-form-label">Locality:</label>
            <div class="col-md-5">
                <input id="locality"
                       name="locality"
                       type="text"
                       class="form-control"
                       required>
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-md-2 col-form-label">Description:</label>
            <div class="col-md-10">
                <textarea id="description"
                       name="description"
                       class="form-control"
                       required></textarea>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <button type="reset" class="btn btn-warning">Reset</button>
    </form>
<div>
<jsp:include page="/templates/scripts.jsp">
    <jsp:param name="scripts" value="owner/create-rental.js" />
</jsp:include>
</body>
</html>