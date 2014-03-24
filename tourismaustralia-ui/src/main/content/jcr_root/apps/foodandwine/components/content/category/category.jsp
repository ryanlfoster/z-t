<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.category.Category"%>

<c:set var="category" value="<%=new Category(slingRequest) %>" />
<html>
<head>
</head>
<body>
	<h3 class="faw-article-quotes">Category Component with Text</h3>
	<br />
	<div class="video-table">
		<table>
			<tr>
				<c:forEach items="${category.items}" var="item">
					<td>
						<div class="video-table-cell">
							<div class="imagewithdescription-inner">
								<img src="${item.imagePath}" alt="">
								<div class="imagewithdescription-description">
									<p class="imagewithdescription-description-head">
										<strong><em>${item.caption}</em></strong>
									</p>
								</div>
							</div>
						</div>
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>

