<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@ page import="com.australia.www.components.content.categorizediconlinks.CategorizedIconLinks" %>

<c:set var="categorizedIconLinks" value="<%= new CategorizedIconLinks(slingRequest) %>"/>

Cat 1 title: ${categorizedIconLinks.titleText1.title} <br>
Cat 1 text: ${categorizedIconLinks.titleText1.text} <br>
Cat 1 image1: ${categorizedIconLinks.titleText1.iconImage1} <br>
Cat 1 Icon Link1: ${categorizedIconLinks.titleText1.iconLink1} <br>
Cat 1 Link Text1: ${categorizedIconLinks.titleText1.linkText1} <br>
Cat 1 Icon Alt Text1: ${categorizedIconLinks.titleText1.iconAltText1} <br>
Cat 1 image2: ${categorizedIconLinks.titleText1.iconImage2} <br>
Cat 1 Icon Link2: ${categorizedIconLinks.titleText1.iconLink2} <br>
Cat 1 Link Text2: ${categorizedIconLinks.titleText1.linkText2} <br>
Cat 1 Icon Alt Text2: ${categorizedIconLinks.titleText1.iconAltText2} <br>
Cat 1 image3: ${categorizedIconLinks.titleText1.iconImage3} <br>
Cat 1 Icon Link3: ${categorizedIconLinks.titleText1.iconLink3} <br>
Cat 1 Link Text3: ${categorizedIconLinks.titleText1.linkText3} <br>
Cat 1 Icon Alt Text3: ${categorizedIconLinks.titleText1.iconAltText3} <br>
<p>

Cat 2 title: ${categorizedIconLinks.titleText2.title} <br>
Cat 2 text: ${categorizedIconLinks.titleText2.text} <br>
Cat 2 image1: ${categorizedIconLinks.titleText2.iconImage1} <br>
Cat 2 Icon Link1: ${categorizedIconLinks.titleText2.iconLink1} <br>
Cat 2 Link Text1: ${categorizedIconLinks.titleText2.linkText1} <br>
Cat 2 Icon Alt Text1: ${categorizedIconLinks.titleText2.iconAltText1} <br>
Cat 2 image2: ${categorizedIconLinks.titleText2.iconImage2} <br>
Cat 2 Icon Link2: ${categorizedIconLinks.titleText2.iconLink2} <br>
Cat 2 Link Text2: ${categorizedIconLinks.titleText2.linkText2} <br>
Cat 2 Icon Alt Text2: ${categorizedIconLinks.titleText2.iconAltText2} <br>
Cat 2 image3: ${categorizedIconLinks.titleText2.iconImage3} <br>
Cat 2 Icon Link3: ${categorizedIconLinks.titleText2.iconLink3} <br>
Cat 2 Link Text3: ${categorizedIconLinks.titleText2.linkText3} <br>
Cat 2 Icon Alt Text3: ${categorizedIconLinks.titleText2.iconAltText3} <br>
<p>

Cat 3 title: ${categorizedIconLinks.titleText3.title} <br>
Cat 3 text: ${categorizedIconLinks.titleText3.text} <br>
Cat 3 image1: ${categorizedIconLinks.titleText3.iconImage1} <br>
Cat 3 Icon Link1: ${categorizedIconLinks.titleText3.iconLink1} <br>
Cat 3 Link Text1: ${categorizedIconLinks.titleText3.linkText1} <br>
Cat 3 Icon Alt Text1: ${categorizedIconLinks.titleText3.iconAltText1} <br>
Cat 3 image2: ${categorizedIconLinks.titleText3.iconImage2} <br>
Cat 3 Icon Link2: ${categorizedIconLinks.titleText3.iconLink2} <br>
Cat 3 Link Text2: ${categorizedIconLinks.titleText3.linkText2} <br>
Cat 3 Icon Alt Text2: ${categorizedIconLinks.titleText3.iconAltText2} <br>
Cat 3 image3: ${categorizedIconLinks.titleText3.iconImage3} <br>
Cat 3 Icon Link3: ${categorizedIconLinks.titleText3.iconLink3} <br>
Cat 3 Link Text3: ${categorizedIconLinks.titleText3.linkText3} <br>
Cat 3 Icon Alt Text3: ${categorizedIconLinks.titleText3.iconAltText3} <br>
