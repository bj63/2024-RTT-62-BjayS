<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

<!-- Page Header -->
<section class="custom-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h2 class="text-center raleway-bold" style="color:white; font-size: 60px">${card.playerName}</h2>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row justify-content-center custom-section raleway-normal">
            <!-- Column for the cover image -->
            <div class="col-md-4 d-flex align-items-center">
                <img src="${card.imageUrl}" alt="Card Image" class="img-fluid"/>
            </div>

            <!-- Column for the details -->
            <div class="col-md-8">
                <table class="table" style="color: white;">
                    <tr>
                        <td style="font-weight: bolder;">Card ID:</td>
                        <td>${card.id}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Player Name:</td>
                        <td>${card.playerName}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Team:</td>
                        <td>${card.teamName}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Price:</td>
                        <td>${card.buyPrice}</td>
                    </tr>
                    <tr>
                        <td style="font-weight: bolder;">Available Copies:</td>
                        <td>${card.availableCopies}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form action="/user/trade" method="post" class="text-center">
                                <input type="hidden" name="cardId" value="${card.id}">
                                <button type="submit" class="btn btn-light">Trade</button>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />


