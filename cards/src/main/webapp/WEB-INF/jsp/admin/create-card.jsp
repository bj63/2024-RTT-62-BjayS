<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp" />

<!-- Page header -->
<section class="custom-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center raleway-normal" style="color:white">Create Card</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <form action="${pageContext.request.contextPath}/admin/createCard" method="post" enctype="multipart/form-data">
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger">
                                ${errorMessage}
                        </div>
                    </c:if>

                    <div class="mb-3">
                        <label for="playerName" class="form-label">Player Name</label>
                        <input type="text" class="form-control" id="playerName" name="playerName" value="${form.playerName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="teamName" class="form-label">Team</label>
                        <input type="text" class="form-control" id="teamName" name="teamName" value="${form.teamName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="buyPrice" class="form-label">Price</label>
                        <input type="number" step="0.01" class="form-control" id="buyPrice" name="buyPrice" value="${form.buyPrice}" required>
                    </div>
                    <div class="mb-3">
                        <label for="availableCopies" class="form-label">Available Copies</label>
                        <input type="number" class="form-control" id="availableCopies" name="availableCopies" value="${form.availableCopies}" required>
                    </div>
                    <div class="mb-3">
                        <label for="image" class="form-label">Image</label>
                        <input type="file" class="form-control" id="image" name="image">
                    </div>
                    <div class="row justify-content-center ">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Create Card</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp" />
