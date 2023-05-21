<%@ include file="/init.jsp" %>

<%
if (Validator.isBlank(sxpBlueprintId)) {
%>

	<p>Please set the Blueprint ID in the configuration</p>

	<%
		return;
	}

	List<SearchHit> searchHitList = (List<SearchHit>)request.getAttribute("results");
	%>

<c:if test="<%= searchHitList != null %>">
	<h1><liferay-ui:message key="results" /></h1>

	<ul>

		<%
		for (SearchHit searchHit : searchHitList) {
			Document document = searchHit.getDocument();
		%>

				<li><%= document.getString("title_en_US") %>

				<%
				}
				%>

	</ul>
</c:if>