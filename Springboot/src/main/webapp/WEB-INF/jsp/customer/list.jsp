<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="page-title">Customer List</h1>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="${pageContext.request.contextPath}/customer/search" method="get">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="name" placeholder="Search by name" aria-label="Search by name">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contact Name</th>
                        <th>State</th>
                        <th>Postal</th>
                        <th>Country</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/customer/detail?customerId=${customer.id}">${customer.id}</a></td>
                            <td>${customer.customerName}</td>
                            <td>${customer.contactFirstname} ${customer.contactLastname}</td>
                            <td>${customer.state}</td>
                            <td>${customer.postalCode}</td>
                            <td>${customer.country}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
