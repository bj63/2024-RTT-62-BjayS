<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>


<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center"><c:choose>
                <c:when test="${not empty form.id}">Edit Dog Profile</c:when>
                <c:otherwise>Create Dog Profile</c:otherwise>
            </c:choose></h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row justify-content-center pt-5 pb-3">
            <div class="col-8">
                <%--@elvariable id="form" type=""--%>
                <form:form modelAttribute="form" action="/dog/createSubmit" method="post">
                    <div class="mb-3">
                        <form:hidden path="id" />
                        <form:label path="name">Name</form:label>
                        <form:input path="name" class="form-control" />
                        <form:errors path="name" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="breed">Breed</form:label>
                        <form:input path="breed" class="form-control" />
                        <form:errors path="breed" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="age">Age</form:label>
                        <form:input path="age" class="form-control" />
                        <form:errors path="age" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="description">Description</form:label>
                        <form:textarea path="description" class="form-control" />
                        <form:errors path="description" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="imageUrl">Image URL</form:label>
                        <form:input path="imageUrl" class="form-control" />
                        <form:errors path="imageUrl" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="ownerId">Owner</form:label>
                        <form:select path="ownerId" class="form-control">
                            <form:options items="${users}" itemValue="id" itemLabel="name" />
                        </form:select>
                        <form:errors path="ownerId" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="categoryIds">Categories</form:label>
                        <form:select path="categoryIds" multiple="true" class="form-control">
                            <form:options items="${categories}" itemValue="id" itemLabel="name" />
                        </form:select>
                        <form:errors path="categoryIds" cssClass="text-danger" />
                    </div>

                    <button type="submit" class="btn btn-success">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
