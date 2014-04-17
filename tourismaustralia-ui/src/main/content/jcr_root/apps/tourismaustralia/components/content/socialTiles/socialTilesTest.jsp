<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.socialTiles.SocialTiles" %>
<c:set var="socialTiles" value="<%=new SocialTiles(slingRequest)%>"/>


<div class="socialtiles">

    <div class="row l-center-1200">

		<div class="section-intro">
		    <div class="l-center-900">
		        <h3 class="type-h1-responsive">
					${socialTiles.title}
		        </h3>
		    </div>
		</div>
		
    <div class="mosaic">

	    <div class="row l-row-collapse">
	
	        <div class="row">
				<c:forEach items="${socialTiles.tilesList}" var="tile" begin="0" end="8"> 
				<c:choose>
				<c:when test="${status > 3 && status < 8 }">
						<cq:include script="smallTile.jsp"/>
				   <c:otherwise>
    					<cq:include script="bigTile.jsp"/>
				   </c:otherwise>
				</c:when>
				</c:choose>
				<c:if test="${status == 2}">
					</div><div class="row">
				</c:if>
				<c:if test="${status == 8}">
					</div>
				</c:if>
				</c:forEach>
	
	        </div>
	
	    </div>
	</div>
    	
    	
    	
    	
        <div class="socialtiles-linethrough">
			<div class="line-through-container">
			    <div class="line-through"><span class="line-through-hr"></span></div>
			    <div class="line-through-container-biline">
					${socialTiles.subTitle}
			    </div>
			    <div class="line-through"><span class="line-through-hr"></span></div>
			</div>
        </div>

        <div class="l-h-center">
            <a href="${socialTiles.link.path }" class="btn-primary">${socialTiles.link.title}</a>
        </div>

    </div>

</div>