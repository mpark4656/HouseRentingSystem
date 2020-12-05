<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/templates/head.jsp">
    <jsp:param name="title" value="Home - House Rental System" />
</jsp:include>
<body>
    <jsp:include page="/templates/navigation-bar.jsp"/>
    <div class="container">
        <div id="main-carousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#main-carousel" data-slide-to="0" class="active"></li>
                <li data-target="#main-carousel" data-slide-to="1"></li>
                <li data-target="#main-carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="5000">
                    <img src="${pageContext.request.contextPath}/img/carousel1.jpg"
                        class="d-block w-100" alt="First Slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Convenience</h5>
                        <p>Easy way to search for your rental house</p>
                    </div>
                </div>
                <div class="carousel-item" data-interval="5000">
                    <img src="${pageContext.request.contextPath}/img/carousel2.jpg"
                        class="d-block w-100" alt="Second Slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Affordable Price</h5>
                        <p>Account creation is free for both owners and clients</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/img/carousel3.jpg"
                        class="d-block w-100" alt="Third Slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Easy</h5>
                        <p>User-friendly interface to post houses for rental or search for houses</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#main-carousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#main-carousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="jumbotron">
            <h1 class="display-4">House Rental System</h1>
            <p class="lead">
                This is a demo system that implements the below problem description.
                Created by Michael Park
            </p>
            <hr class="my-4">
            <p>
                House rental portal is a web-based java project where house owners, clients, customers can exchange
                information effectively and inexpensively. This system provides a user-friendly interface, satisfying
                the needs of the consumers. It also employs a new strategy that facilitates easy management of rental
                houses.
            </p>
            <p>
                There are three users in this system- Owner, Admin, and Customer. The owner is the user who owns the
                house and wants it to give it for rent. The owner will upload all the details of the house, including
                the number of rooms, locality, rent. Admin manages all the users of the system. Customer is the one
                who is looking for a rental house. He can search the house according to the requirements and get the
                results accordingly.
            </p>
            <a class="btn btn-primary btn-lg"
               href="https://github.com/mpark4656/HouseRentingSystem"
               role="button">Learn more</a>
        </div>
    </div>
    <jsp:include page="/templates/scripts.jsp"/>
</body>
</html>