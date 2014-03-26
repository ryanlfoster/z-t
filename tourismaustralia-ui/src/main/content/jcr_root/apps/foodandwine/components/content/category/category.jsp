<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.category.Category"%>

<c:set var="category" value="<%=new Category(slingRequest) %>" />
<html>
<head>
</head>
<body>
	<table>
	<tr>
		<c:forEach items="${category.items}" var="item">
				   <td>
			<input id="category-restaurants" type="checkbox"
				class="category-input">
				   </td>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach items="${category.items}" var="item">
				   <td>
			<label for="category-restaurants">
				<div class="category-item">
					<span class="icon-round is-active"> <img
						class="category-image-light" src="${item.imagePath}" alt="">
				</span>
				</div>
				</label>
				   </td>
		</c:forEach>
	</tr>


	<tr>
		<c:forEach items="${category.items}" var="item">
				   <td>
					<span class="category-title"> ${item.caption} </span>
				   </td>
		</c:forEach>
	</tr>


</table>

</body>
</html>



