<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.other.Other"%>

<c:set var="other" value="<%=new Other(slingRequest) %>" />
<html>
<head>
<style>
	.post-content {
	    background: none repeat scroll 0 0 #FFffff;
	    opacity: 0.5;
	    margin: 0 auto;
	    margin-top: -54px;
	    text-align:center
	    position: relative;
	    width:40%;

    
	}
	.thumbnail {
	    margin:0 auto;
	    text-align:center;
	}
	.wrapper {
	    text-align:left;
	}
</style>
</head>
<body>
		<c:forEach items="${other.tagArticles}" var="tagArticle">
	<div class="video-table">
			<table>
			<tr>
    			<h3 class="faw-article-quotes">${tagArticle.tag}</h3>
			</tr>
			<tr>
				<c:forEach items="${tagArticle.articles}" var="article">
				<td>
					<div class="thumbnail">
							<img src="${article.imagePath}" alt=""/>
				           <div class="wrapper">
				    <div class="caption post-content">
				
				                <h3>${article.largeText}</h3>
				                <p>${article.smallText}</p> 
				
				            </div>
				        </div>
				    </div>				
				</td>
				</c:forEach>		
			</tr>			
		</table>				
	</div>
		</c:forEach>
</body>
</html>

