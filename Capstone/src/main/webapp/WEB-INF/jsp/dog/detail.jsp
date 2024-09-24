<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Dog Profile Detail</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-3">
            <div class="col-12">
                <h2>${dogProfile.name}</h2>
                <p><strong>Breed:</strong> ${dogProfile.breed}</p>
                <p><strong>Age:</strong> ${dogProfile.age}</p>
                <p><strong>Description:</strong> ${dogProfile.description}</p>
                <p><strong>Owner:</strong> ${dogProfile.owner.name}</p>
                <p><strong>Categories:</strong>
                    <c:forEach var="category" items="${dogProfile.categories}">
                        ${category.name}
                    </c:forEach>
                </p>
                <p><strong>Image:</strong><br />
                    <img src="${dogProfile.imageUrl}" alt="${dogProfile.name}" style="max-width: 100%; height: auto;" />
                </p>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
