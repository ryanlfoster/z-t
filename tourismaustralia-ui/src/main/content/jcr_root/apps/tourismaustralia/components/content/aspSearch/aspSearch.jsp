<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<cq:includeClientLib js="ta-asp-search"/>

<div class="aspSearchHolder">
	<form name="aspSearch" action="${resource.path}.aspsearch.json">
		<label for="country">Country</label>
		<input name="country">
		<label for="state">State</label>
		<input name="state">
		<label for="city">City</label>
		<input name="city">
		<button type="submit">Search</button>
		
		<div class="results"></div>
	</form>
</div>