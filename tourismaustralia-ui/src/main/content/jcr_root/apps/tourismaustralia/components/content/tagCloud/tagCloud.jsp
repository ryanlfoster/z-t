<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.tagCloud.TagCloud" %>
<c:set var="tagCloud" value="<%=new TagCloud(slingRequest)%>"/>

<div class="tagcloud">
	<span class="tagcloud-explore-by">Explore by type</span>
	<ul>
		<c:forEach items="${tagCloud.tags}" var="tag">
			<li><span class="btn-tag-item"><a href="${tag.href}">${tag.title}</a></span></li>
		</c:forEach>
	</ul>
</div>