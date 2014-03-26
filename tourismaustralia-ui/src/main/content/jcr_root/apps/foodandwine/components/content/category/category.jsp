<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.category.Category"%>

<c:set var="category" value="<%=new Category(slingRequest) %>" />
 <div class="category-items">
 		<c:forEach items="${category.items}" var="item">
 			<div class="category-item category-item-center">
 				<p>
 					<span class="btn-round is-active"><img src="${item.imagePath}" alt=""></span>
 					<span class="category-title l-color-black">${item.caption}</span>
 				</p>
 			</div> 		
 		</c:forEach> 
 </div>



