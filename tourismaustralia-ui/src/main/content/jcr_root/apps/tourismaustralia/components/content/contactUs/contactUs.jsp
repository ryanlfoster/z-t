<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<cq:includeClientLib js="ta-contact-us"/>

<div class="contactUsHolder">
    <form name="contactUs" action="${resource.path}.contactus.json">
        <label for="userName">Your name is</label><br/>
        <input name="userName" required="true">
        <br/><br/>
        <label for="userEmail">Your email is</label><br/>
        <input name="userEmail" required="true">
        <br/><br/>
        <label for="message">How can we help you?</label><br/>
        <input name="message">
        <br/><br/>
        <button type="submit">Send</button>
    </form>
</div>