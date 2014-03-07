CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function (e) {
    var telize = CQ_Analytics.StoreRegistry.getStores().telize;

    if (telize && telize.data) {
        var data = telize.data;
        var country = data.country;
        if (country === "United States") {
            country = "United States Of America";
        }
        var state = data.state;
        var city = data.city;
    }
    $('.aspSearchHolder').each(function () {
        $this = $(this);
        $this.find('input[name="country"]').val(country);
        $this.find('input[name="state"]').val(state);
        $this.find('input[name="city"]').val(city);

        $this.find('form[name="aspSearch"]').submit(function (e) {
            e.preventDefault();
            var data = {
                country: $this.find('input[name="country"]').val(),
                state: $this.find('input[name="state"]').val(),
                city: $this.find('input[name="city"]').val()
            }
            var action = $(this).attr("action");
            $.getJSON(action, data, function (data) {
                var results = $this.find(".results");
                results.empty();
                data.forEach(function (spec) {
                    var result = results.append("<div><h3>" + spec.personName + "</h3><div>" + spec.companyName + "</div><div>" + spec.phone + "</div></div>");
                    var form = $('<form><label for="userName">Name:</label><input name="userName"/><label for="userEmail">Email:</label><input name="userEmail"/><label for="message">Message:</label><input name="message"/><button type="submit">Email</button></form>')
                    form.submit(function (e) {
                        e.preventDefault();
                        var data = {
                            userName: form.find('input[name="userName"]').val(),
                            userEmail: form.find('input[name="userEmail"]').val(),
                            message: form.find('input[name="message"]').val(),
                            agentName: spec.personName,
                            agentEmail: "mhodgdon@citytechinc.com"
                        }
                        $.ajax({
                            type: "POST",
                            url: action.replace(".aspsearch.", ".agentemail."),
                            data: data,
                            success: function () {
                                alert("Email Sent!");
                            },
                            error: function () {
                                alert("error");
                            }
                        });
                    });
                    result.append(form);
                });
            });
        });

        $this.find('form').submit();
    });
});
