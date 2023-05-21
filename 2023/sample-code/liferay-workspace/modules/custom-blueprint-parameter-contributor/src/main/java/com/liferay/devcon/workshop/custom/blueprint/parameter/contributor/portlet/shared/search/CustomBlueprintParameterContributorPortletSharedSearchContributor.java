package com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.portlet.shared.search;

import com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.constants.CustomBlueprintParameterContributorPortletKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import java.util.Optional;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author Petteri Karttunen
 */
@Component(
	property = "javax.portlet.name=" + CustomBlueprintParameterContributorPortletKeys.CUSTOM_BLUEPRINT_PARAMETER_CONTRIBUTOR,
	service = PortletSharedSearchContributor.class
)
public class CustomBlueprintParameterContributorPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {
		
		Optional<PortletPreferences> portletPreferencesOptional = portletSharedSearchSettings.getPortletPreferencesOptional();
		
		PortletPreferences portletPreferences = portletPreferencesOptional.get();
		
		SearchRequestBuilder searchRequestBuilder =
				portletSharedSearchSettings.getFederatedSearchRequestBuilder(
						portletPreferences.getValue("federatedSearchKey", ""));

		if (searchRequestBuilder == null) {
			return;
		} 
		
		ThemeDisplay themeDisplay =
				portletSharedSearchSettings.getThemeDisplay();
		
			searchRequestBuilder.withSearchContext(
				searchContext -> {
					searchContext.setAttribute(
						"search.experiences.user.id", themeDisplay.getUserId());
				}
			);
	}
}
				