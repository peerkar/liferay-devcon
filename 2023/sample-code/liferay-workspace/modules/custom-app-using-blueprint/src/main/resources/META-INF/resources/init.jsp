<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.search.document.Document" %><%@
page import="com.liferay.portal.search.hits.SearchHit" %>

<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();

String sxpBlueprintId = preferences.getValue("sxpBlueprintId", "");
%>