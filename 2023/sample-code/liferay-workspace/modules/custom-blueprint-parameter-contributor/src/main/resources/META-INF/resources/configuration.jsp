<%@ include file="/init.jsp" %>


<%

	PortletPreferences preferences = renderRequest.getPreferences();
	
	String federatedSearchKey = preferences.getValue("federatedSearchKey", "");

%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />
                                                        
<liferay-frontend:edit-form
        action="<%= configurationActionURL %>"
        method="post"
        name="fm">
        
        <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
        <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
                        
        <liferay-frontend:edit-form-body>   
                     <aui:fieldset>
             
             	<aui:input label="federated-search-key" name="preferences--federatedSearchKey--" type="text" value="<%= federatedSearchKey %>" />
             
        
                              
                              </aui:fieldset>
                                    </liferay-frontend:edit-form-body>
                                                    
                                    <liferay-frontend:edit-form-footer>
                                            <liferay-frontend:edit-form-buttons />
                                    </liferay-frontend:edit-form-footer>
                                    </liferay-frontend:edit-form>
