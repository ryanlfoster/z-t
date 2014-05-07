<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@ page import="com.australia.www.components.content.categorizediconlinks.CategorizedIconLinks" %>

<c:set var="categorizedIconLinks" value="<%= new CategorizedIconLinks(slingRequest) %>"/>

    <div class="categorylinks">
        <div class="row l-center-1200">
            <c:if test="${not empty categorizedIconLinks.title}">
                <div class="line-through-container line-categorylink-theme">
                    <div class="line-through-categorylink-theme"></div>
                    <h4 class="line-through-container-biline">
                            ${categorizedIconLinks.title}
                    </h4>
                </div>
            </c:if>
            <div class="col-xs-12 col-sm-4">
                <div class="categorylinks-item">
                    <c:if test="${not empty categorizedIconLinks.titleText1.title}">
                        <div class="categorylink-header">
                            <h5 class="categorylink-title">${categorizedIconLinks.titleText1.title}</h5>
                        </div>
                    </c:if>
                    <c:if test="${not empty categorizedIconLinks.titleText1.text}">
                        <div class="categorylink-body">
                            <p>${categorizedIconLinks.titleText1.text}</p>
                        </div>
                    </c:if>
                    <div class="categorylink-links">
                        <c:if test="${not empty categorizedIconLinks.titleText1.iconLink1 && ( not empty categorizedIconLinks.titleText1.iconImage1 || not empty categorizedIconLinks.titleText1.linkText1 )}">
                            <a href="${categorizedIconLinks.titleText1.iconLink1}" ${categorizedIconLinks.titleText1.iconLink1IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText1.iconImage1}">
                                    <img src="${categorizedIconLinks.titleText1.iconImage1}"
                                         alt="${categorizedIconLinks.titleText1.iconAltText1}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText1.linkText1}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText1.linkText1}</span>
                                </c:if>
                            </a>
                            <br>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText1.iconLink2 && ( not empty categorizedIconLinks.titleText1.iconImage2 || not empty categorizedIconLinks.titleText1.linkText2)}">
                            <a href="${categorizedIconLinks.titleText1.iconLink2}" ${categorizedIconLinks.titleText1.iconLink2IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText1.iconImage2}">
                                    <img src="${categorizedIconLinks.titleText1.iconImage2}"
                                         alt="${categorizedIconLinks.titleText1.iconAltText2}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText1.linkText2}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText1.linkText2}</span>
                                </c:if>
                            </a>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText1.iconLink3 && ( not empty categorizedIconLinks.titleText1.iconImage3 || not empty categorizedIconLinks.titleText1.linkText3)}">
                            <a href="${categorizedIconLinks.titleText1.iconLink3}" ${categorizedIconLinks.titleText1.iconLink3IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText1.iconImage3}">
                                    <img src="${categorizedIconLinks.titleText1.iconImage3}"
                                         alt="${categorizedIconLinks.titleText1.iconAltText3}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText1.linkText3}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText1.linkText3}</span>
                                </c:if>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="col-xs-12 col-sm-4">
                <div class="categorylinks-item">
                    <c:if test="${not empty categorizedIconLinks.titleText2.title}">
                        <div class="categorylink-header">
                            <h5 class="categorylink-title">${categorizedIconLinks.titleText2.title}</h5>
                        </div>
                    </c:if>
                    <c:if test="${not empty categorizedIconLinks.titleText2.text}">
                        <div class="categorylink-body">
                            <p>${categorizedIconLinks.titleText2.text}</p>
                        </div>
                    </c:if>
                    <div class="categorylink-links">
                        <c:if test="${not empty categorizedIconLinks.titleText2.iconLink1 && ( not empty categorizedIconLinks.titleText2.iconImage1 || not empty categorizedIconLinks.titleText2.linkText1 )}">
                            <a href="${categorizedIconLinks.titleText2.iconLink1}" ${categorizedIconLinks.titleText2.iconLink1IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText2.iconImage1}">
                                    <img src="${categorizedIconLinks.titleText2.iconImage1}"
                                         alt="${categorizedIconLinks.titleText2.iconAltText1}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText2.linkText1}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText2.linkText1}</span>
                                </c:if>
                            </a>
                            <br>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText2.iconLink2 && ( not empty categorizedIconLinks.titleText2.iconImage2 || not empty categorizedIconLinks.titleText2.linkText2)}">
                            <a href="${categorizedIconLinks.titleText2.iconLink2}" ${categorizedIconLinks.titleText2.iconLink2IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText2.iconImage2}">
                                    <img src="${categorizedIconLinks.titleText2.iconImage2}"
                                         alt="${categorizedIconLinks.titleText2.iconAltText2}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText2.linkText2}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText2.linkText2}</span>
                                </c:if>
                            </a>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText2.iconLink3 && ( not empty categorizedIconLinks.titleText2.iconImage3 || not empty categorizedIconLinks.titleText2.linkText3)}">
                            <a href="${categorizedIconLinks.titleText2.iconLink3}" ${categorizedIconLinks.titleText2.iconLink3IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText2.iconImage3}">
                                    <img src="${categorizedIconLinks.titleText2.iconImage3}"
                                         alt="${categorizedIconLinks.titleText2.iconAltText3}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText2.linkText3}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText2.linkText3}</span>
                                </c:if>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="col-xs-12 col-sm-4">
                <div class="categorylinks-item">
                    <c:if test="${not empty categorizedIconLinks.titleText3.title}">
                        <div class="categorylink-header">
                            <h5 class="categorylink-title">${categorizedIconLinks.titleText3.title}</h5>
                        </div>
                    </c:if>
                    <c:if test="${not empty categorizedIconLinks.titleText3.text}">
                        <div class="categorylink-body">
                            <p>${categorizedIconLinks.titleText3.text}</p>
                        </div>
                    </c:if>
                    <div class="categorylink-links">
                        <c:if test="${not empty categorizedIconLinks.titleText3.iconLink1 && ( not empty categorizedIconLinks.titleText3.iconImage1 || not empty categorizedIconLinks.titleText3.linkText1 )}">
                            <a href="${categorizedIconLinks.titleText3.iconLink1}" ${categorizedIconLinks.titleText3.iconLink1IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText3.iconImage1}">
                                    <img src="${categorizedIconLinks.titleText3.iconImage1}"
                                         alt="${categorizedIconLinks.titleText3.iconAltText1}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText3.linkText1}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText3.linkText1}</span>
                                </c:if>
                            </a>
                            <br>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText3.iconLink2 && ( not empty categorizedIconLinks.titleText3.iconImage2 || not empty categorizedIconLinks.titleText3.linkText2)}">
                            <a href="${categorizedIconLinks.titleText3.iconLink2}" ${categorizedIconLinks.titleText3.iconLink2IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText2.iconImage2}">
                                    <img src="${categorizedIconLinks.titleText3.iconImage2}"
                                         alt="${categorizedIconLinks.titleText3.iconAltText2}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText3.linkText2}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText3.linkText2}</span>
                                </c:if>
                            </a>
                        </c:if>
                        <c:if test="${not empty categorizedIconLinks.titleText3.iconLink3 && ( not empty categorizedIconLinks.titleText3.iconImage3 || not empty categorizedIconLinks.titleText3.linkText3)}">
                            <a href="${categorizedIconLinks.titleText3.iconLink3}" ${categorizedIconLinks.titleText3.iconLink3IsExternal == true ? 'target="_blank"': ''}>
                                <c:if test="${not empty categorizedIconLinks.titleText3.iconImage3}">
                                    <img src="${categorizedIconLinks.titleText3.iconImage3}"
                                         alt="${categorizedIconLinks.titleText3.iconAltText3}">
                                </c:if>
                                <c:if test="${not empty categorizedIconLinks.titleText3.linkText3}">
                                    <span class="categorylink-linktext">${categorizedIconLinks.titleText3.linkText3}</span>
                                </c:if>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>

        </div>
    </div>


