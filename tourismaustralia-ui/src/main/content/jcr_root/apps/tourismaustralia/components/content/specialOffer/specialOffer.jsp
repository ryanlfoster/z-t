<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.specialoffer.SpecialOffer" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="specialOffer" value="<%=new SpecialOffer(slingRequest) %>"/>
<c:if test="${not empty specialOffer.image && not empty specialOffer.altText }">
<div class="l-padding-between-item-fill-white">
    <div class="specialoffer">
        <div class="row">
            <div class="col-xs-12 col-sm-7">
                <c:if test="${not empty specialOffer.image && not empty specialOffer.altText }">
                <div class="specialoffer-image">
                    <img src="${specialOffer.image}.img.png" alt="${specialOffer.altText}" />
                </div>
                </c:if>
            </div>
            <div class="col-xs-12 col-sm-5">
                <div class="specialoffer-content">
                    <c:if test="${not empty specialOffer.title}">
                    <h3 class="specialoffer-title">${specialOffer.title}</h3>
                    </c:if>
                    <c:if test="${not empty specialOffer.text}">
                    <div class="specialoffer-text">
                        <p>${spacialOffer.text}</p>
                    </div>
                    </c:if>
                    <c:if test="${not empty specialOffer.price && specialOffer.price != 0 && not empty specialOffer.pricePerText}">
                    <div class="specialoffer-price">
                        <c:if test="${not empty specialOffer.price && specialOffer.price != 0}">
                            <span class="specialoffer-currency">$</span>
                            <span class="specialoffer-value">${specialOffer.price}</span>
                        </c:if>
                        <c:if test="${not empty specialOffer.pricePerText}">
                            <span class="specialoffer-per">/${specialOffer.pricePerText}</span>
                        </c:if>
                    </div>
                    </c:if>
                    <c:if test="${not empty specialOffer.price || not empty specialOffer.pricePerText}">
                    <div class="specialoffer-links">
                        <c:if test="${not empty specialOffer.viewMoreInformationLink}">
                        <a href="#">View More Information</a>
                        </c:if>
                        <c:if test="${not empty specialOffer.viewMoreInformationLink}">
                        <a href="#">View Terms and condition</a>
                        </c:if>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</c:if>