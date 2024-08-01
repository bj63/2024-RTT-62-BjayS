<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="page-title">Employee Detail Page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Employee ${employee.firstname} ${employee.lastname}</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <table class="table table-success table-striped table-bordered table-responsive" style="width: 750pt">
            <tr>
                <td style="font-weight: bolder;">Employee ID:</td>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Office ID:</td>
                <td>${employee.office.city}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Full Name:</td>
                <td>${employee.firstname} ${employee.lastname}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Extension:</td>
                <td>${employee.extension}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Email:</td>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Job Title:</td>
                <td>${employee.jobTitle}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Vacation Hours:</td>
                <td>${employee.vacationHours}</td>
            </tr>
        </table>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Customers Found (${customers.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table table-striped table-bordered table-responsive" style="width: 750pt">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contact Name</th>
                        <th>State</th>
                        <th>Postal Code</th>
                        <th>Country</th>
                        <th>Details</th>
                    </tr>
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.customerName}</td>
                            <td>${customer.contactFirstname} ${customer.contactLastname}</td>
                            <td>${customer.state}</td>
                            <td>${customer.postalCode}</td>
                            <td>${customer.country}</td>
                            <td><a href="/customer/details?id=${customer.id}" class="btn btn-primary">View Details</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
