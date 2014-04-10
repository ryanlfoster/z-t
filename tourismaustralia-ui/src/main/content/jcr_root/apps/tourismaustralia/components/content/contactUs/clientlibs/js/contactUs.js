$(function () {
    $('form[name="contactUs"]').submit(function (event) {
        event.preventDefault();
        $this = $(this);
        var data = {
            userName: $this.find('input[name="userName"]').val(),
            userEmail: $this.find('input[name="userEmail"]').val(),
            message: $this.find('input[name="message"]').val(),
            defaultRecipient: "admin@tourism.australia.com"
        }
        var action = $(this).attr("action");
        $.ajax({
            type: "POST",
            url: action.replace(".contactus.", ".contactemail."),
            data: data,
            success: function () {
                alert("Email Sent!");
            },
            error: function () {
                alert("error");
            }
        });
    });

});
