<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Customer</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <form action="${pageContext.request.contextPath}/customer/createSubmit" method="get">
            <div class="form-group">
                <label for="customerName">Customer Name</label>
                <input type="text" class="form-control" id="customerName" name="customerName" value="${form.customerName}">
                <c:if test="${bindingResult.hasFieldErrors('customerName')}">
                    <span class="text-danger">${bindingResult.getFieldError('customerName').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="contactFirstname">Contact First Name</label>
                <input type="text" class="form-control" id="contactFirstname" name="contactFirstname" value="${form.contactFirstname}">
                <c:if test="${bindingResult.hasFieldErrors('contactFirstname')}">
                    <span class="text-danger">${bindingResult.getFieldError('contactFirstname').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="contactLastname">Contact Last Name</label>
                <input type="text" class="form-control" id="contactLastname" name="contactLastname" value="${form.contactLastname}">
                <c:if test="${bindingResult.hasFieldErrors('contactLastname')}">
                    <span class="text-danger">${bindingResult.getFieldError('contactLastname').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                <c:if test="${bindingResult.hasFieldErrors('phone')}">
                    <span class="text-danger">${bindingResult.getFieldError('phone').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="addressLine1">Address Line 1</label>
                <input type="text" class="form-control" id="addressLine1" name="addressLine1" value="${form.addressLine1}">
                <c:if test="${bindingResult.hasFieldErrors('addressLine1')}">
                    <span class="text-danger">${bindingResult.getFieldError('addressLine1').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="addressLine2">Address Line 2</label>
                <input type="text" class="form-control" id="addressLine2" name="addressLine2" value="${form.addressLine2}">
                <c:if test="${bindingResult.hasFieldErrors('addressLine2')}">
                    <span class="text-danger">${bindingResult.getFieldError('addressLine2').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" value="${form.city}">
                <c:if test="${bindingResult.hasFieldErrors('city')}">
                    <span class="text-danger">${bindingResult.getFieldError('city').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" class="form-control" id="state" name="state" value="${form.state}">
                <c:if test="${bindingResult.hasFieldErrors('state')}">
                    <span class="text-danger">${bindingResult.getFieldError('state').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="postalCode">Postal Code</label>
                <input type="text" class="form-control" id="postalCode" name="postalCode" value="${form.postalCode}">
                <c:if test="${bindingResult.hasFieldErrors('postalCode')}">
                    <span class="text-danger">${bindingResult.getFieldError('postalCode').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="country">Country</label>
                <input type="text" class="form-control" id="country" name="country" value="${form.country}">
                <c:if test="${bindingResult.hasFieldErrors('country')}">
                    <span class="text-danger">${bindingResult.getFieldError('country').defaultMessage}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="creditLimit">Credit Limit</label>
                <input type="text" class="form-control" id="creditLimit" name="creditLimit" value="${form.creditLimit}">
                <c:if test="${bindingResult.hasFieldErrors('creditLimit')}">
                    <span class="text-danger">${bindingResult.getFieldError('creditLimit').defaultMessage}</span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-primary">Create Customer</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
