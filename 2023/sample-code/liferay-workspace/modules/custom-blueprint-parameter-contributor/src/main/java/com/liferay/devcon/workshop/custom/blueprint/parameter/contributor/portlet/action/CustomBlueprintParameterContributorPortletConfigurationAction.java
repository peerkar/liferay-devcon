package com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.portlet.action;

import com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.constants.CustomBlueprintParameterContributorPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Petteri Karttunen
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + CustomBlueprintParameterContributorPortletKeys.CUSTOM_BLUEPRINT_PARAMETER_CONTRIBUTOR,
	service = ConfigurationAction.class
)
public class CustomBlueprintParameterContributorPortletConfigurationAction
	extends DefaultConfigurationAction {
}