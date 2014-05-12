<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.explore.Explore" %>
<c:set var="explore" value="<%=new Explore(slingRequest) %>"/>

<div class="explore-container">
	<div class="section-intro">
		<div class="l-center-900">
			<h3 class="type-h1-responsive">
				<fmt:message key="EXPLORE BEYOND THE CITY LIMITS"/>
			</h3>
		</div>
		<div class="l-center-640 type-center">
			<p class="type-intro">
				Make Sydney where your adventure begins. World-heritage natural wonders, world-class wine regions, and the world’s most stunning beaches are just over the horizon.
			</p>
		</div>
	</div>
	<div class="l-h-center section-buttons">
		<!-- Select List For Mobile -->
		<div class="section-buttons-mobile">
			<div class="dropdown-select">
				<hr>
					<div class="dropdown-select-style">
						<select>
							<c:forEach items="${explore.tabs}" var="tab">
								<c:if test="${tab.hasTitle}">
									<option><c:out value="${tab.title}"/> </option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				<hr>
			</div>
		</div>
			<!-- Buttons -->
		<div class="section-buttons-desktop">
			<c:forEach items="${explore.tabs}" var="tab">
				<c:if test="${tab.hasTitle}">
					<a href="#" class="btn-bubble btn-bubble-min-width btn-category-extra-space">
						<span class="btn-bubble-button">
							<img class="btn-bubble-std" src="<c:url value='${tab.iconImagePath}'/>" alt=""/>
							<img class="btn-bubble-active" src="<c:url value='${tab.selectedImagePath}'/>" alt=""/>
						</span>
						<span class="type-below-btn">
							<c:out value="${tab.title}"/>
						</span>
					</a>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="carousel-center-container">
	<div class="carousel-owl-mobile-fill">
	<div id="carousel" class="owl-carousel owl-theme">

<%-- Tab 1 Carousel --%>
	<%-- Card 1 --%>
	<c:set var="card" value="${explore.tabs[0].cards[0]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 2 --%>
	<c:set var="card" value="${explore.tabs[0].cards[1]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 3 --%>
	<c:set var="card" value="${explore.tabs[0].cards[2]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

<%-- Tab 2 Carousel --%>
	<%-- Card 1 --%>
	<c:set var="card" value="${explore.tabs[1].cards[0]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 2 --%>
	<c:set var="card" value="${explore.tabs[1].cards[1]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 3 --%>
	<c:set var="card" value="${explore.tabs[1].cards[2]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

<%-- Tab 3 Carousel --%>
	<%-- Card 1 --%>
	<c:set var="card" value="${explore.tabs[2].cards[0]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 2 --%>
	<c:set var="card" value="${explore.tabs[2].cards[1]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 3 --%>
	<c:set var="card" value="${explore.tabs[2].cards[2]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

<%-- Tab 4 Carousel --%>
	<%-- Card 1 --%>
	<c:set var="card" value="${explore.tabs[3].cards[0]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 2 --%>
	<c:set var="card" value="${explore.tabs[3].cards[1]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 3 --%>
	<c:set var="card" value="${explore.tabs[3].cards[2]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

<%-- Tab 5 Carousel --%>
	<%-- Card 1 --%>
	<c:set var="card" value="${explore.tabs[4].cards[0]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 2 --%>
	<c:set var="card" value="${explore.tabs[4].cards[1]}" scope="request"/>
	<cq:include script="explorecard.jsp" />

	<%-- Card 3 --%>
	<c:set var="card" value="${explore.tabs[4].cards[2]}" scope="request"/>
	<cq:include script="explorecard.jsp" />
	</div>
	</div>
	</div>

</div>