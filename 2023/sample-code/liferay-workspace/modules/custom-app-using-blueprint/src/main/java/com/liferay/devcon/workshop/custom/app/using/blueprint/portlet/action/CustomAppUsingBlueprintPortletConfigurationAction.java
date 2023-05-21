package com.liferay.devcon.workshop.custom.app.using.blueprint.portlet.action;

import com.liferay.devcon.workshop.custom.app.using.blueprint.constants.CustomAppUsingBlueprintPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Petteri Karttunen
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + CustomAppUsingBlueprintPortletKeys.CUSTOM_APP_USING_BLUEPRINT,
	service = ConfigurationAction.class
)
public class CustomAppUsingBlueprintPortletConfigurationAction
	extends DefaultConfigurationAction {
}