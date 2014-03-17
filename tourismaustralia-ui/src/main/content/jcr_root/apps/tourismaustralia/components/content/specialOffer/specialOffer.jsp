<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.specialoffer.SpecialOffer" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="specialOffer" value="<%=new SpecialOffer(slingRequest) %>"/>

altText = ${specialOffer.altText}
price = ${specialOffer.price}
pricePerText = ${specialOffer.pricePerText}
text = ${specialOffer.text}
title = ${specialOffer.title}
viewMoreInformationLink = ${specialOffer.viewMoreInformationLink}
viewTermsAndConditionLink = ${specialOffer.viewTermsAndConditionLink}
