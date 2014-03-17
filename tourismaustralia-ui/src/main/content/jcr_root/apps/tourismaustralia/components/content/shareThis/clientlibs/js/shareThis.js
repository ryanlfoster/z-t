CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function (e) {
    var telize = CQ_Analytics.StoreRegistry.getStores().telize;

    var country = "NZ";
    if (telize && telize.data) {
        var data = telize.data;
        country = data.country;
        if (country === "United States") {
            country = "United States Of America";
        }
        var state = data.state;
        var city = data.city;
    }
	$('.shareThisHolder').each(function () { 
	    $.getJSON("/bin/favorites/share/guid", function (data) {
	    	$('#showdata').html("<p>shareId=" + data.shareId+"</p>");
	    	$(this).attr('data-shareUrl', data.shareId);
	    });
	});    	
    
});

