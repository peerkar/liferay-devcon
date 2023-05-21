package com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.portlet;

import com.liferay.devcon.workshop.custom.blueprint.parameter.contributor.constants.CustomBlueprintParameterContributorPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.permission.PortletPermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Petteri Karttunen
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=DevCon 2023",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomBlueprintParameterContributor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomBlueprintParameterContributorPortletKeys.CUSTOM_BLUEPRINT_PARAMETER_CONTRIBUTOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomBlueprintParameterContributorPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (_hasConfigurationPermission(renderRequest)) {
			renderRequest.setAttribute(
				WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		}

		super.render(renderRequest, renderResponse);
	}
	
	private boolean _hasConfigurationPermission(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			return _portletPermission.contains(
				themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
				_portal.getPortletId(renderRequest), ActionKeys.CONFIGURATION);
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return false;
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CustomBlueprintParameterContributorPortlet.class);

	@Reference
	private Portal _portal;
	
	@Reference
	private PortletPermission _portletPermission;
}
