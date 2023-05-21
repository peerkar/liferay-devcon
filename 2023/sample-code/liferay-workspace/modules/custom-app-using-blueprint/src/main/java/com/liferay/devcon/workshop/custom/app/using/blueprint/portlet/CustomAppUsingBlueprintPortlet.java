package com.liferay.devcon.workshop.custom.app.using.blueprint.portlet;

import com.liferay.devcon.workshop.custom.app.using.blueprint.constants.CustomAppUsingBlueprintPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.legacy.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
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
		"javax.portlet.display-name=CustomAppUsingBlueprint",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomAppUsingBlueprintPortletKeys.CUSTOM_APP_USING_BLUEPRINT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomAppUsingBlueprintPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		SearchResponse searchResponse = _getSearchResponse(renderRequest);

		if (searchResponse != null) {
			SearchHits searchHits = searchResponse.getSearchHits();

			if (searchHits.getTotalHits() > 0) {
				renderRequest.setAttribute(
					"results", searchHits.getSearchHits());
			}
		}

		super.doView(renderRequest, renderResponse);
	}

	private SearchResponse _getSearchResponse(RenderRequest renderRequest) {
		long sxpBlueprintId = _getSXPBlueprintId(renderRequest);

		if (sxpBlueprintId == 0) {
			return null;
		}

		SearchRequestBuilder searchRequestBuilder =
			_searchRequestBuilderFactory.builder(
				SearchContextFactory.getInstance(
					PortalUtil.getHttpServletRequest(renderRequest)));

		searchRequestBuilder.emptySearchEnabled(
			true
		).from(
			0
		).size(
			10
		).withSearchContext(
			searchContext -> {
				searchContext.setAttribute(
					"search.experiences.blueprint.id",
					_getSXPBlueprintId(renderRequest));

				// Demonstrates passing a custom parameter to a Blueprint
				// Requires declaring the parameter in the Blueprint parameter configuration

				searchContext.setAttribute("is_vip", Boolean.TRUE);
			}
		);

		return _searcher.search(searchRequestBuilder.build());
	}

	private long _getSXPBlueprintId(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();

		return GetterUtil.getLong(
			portletPreferences.getValue("sxpBlueprintId", "0"));
	}

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;

}