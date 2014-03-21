<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.map.Map" %>

<c:set var="map" value="<%=new Map(slingRequest) %>"/>


<html>
  <head>
  <input type="hidden" name="latitude" id="latitude" value="${map.latitude}">
  <input type="hidden" name="longitude" id="longitude" value="${map.longitude}">
    <style>
      #map_canvas {
        width: 500px;
        height: 400px;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script>
      function initialize() {
        var map_canvas = document.getElementById('map_canvas');
        var latitude=document.getElementById('latitude').value;
        var longitude=document.getElementById('longitude').value;
//        console.log('latitude = ' + latitude + ' longitude = ' + longitude);
        var map_options = {
          center: new google.maps.LatLng(latitude, longitude),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        var map = new google.maps.Map(map_canvas, map_options)
      }
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </head>
  <body>
<h3 class="faw-article-quotes">${map.title}</h3>

    <div id="map_canvas"></div>
    

<p class="faw-article-quotes"><b>Phone: </b><em>${map.phone} </em></p>
<br/>

  </body>
</html>

