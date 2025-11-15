---
name: 'Add an Object widget to a page on Liferay site'
description: 'Adds an Object widget to a page on a Liferay site'
mode: 'agent'
tools: ['liferay/*']
---

Your task is add Object Definition widget a site page. Use the headless-admin-site/v1.0/sites/{siteExternalReferenceCode}/site-pages/{pageExternalReferenceCode}/widget-instances endpoint for this task.

If you don't already know the site external reference code for "DevCon2025", use the headless-admin-site/v1.0/sites API using the "search" parameter to find it by name.

If you don't already know the page external reference code for the "Feedback" page, use the headless-admin-site/v1.0/sites/{siteExternalReferenceCode}/site-pages API using the "search" parameter to find it by name.

If you don't already know the Object Definition ID for "Feedback", use the object-admin/v1.0/object-definitions API using the "search" parameter to find it by name.

# Requirements

- The widget name format is com_liferay_object_web_internal_object_definitions_portlet_ObjectDefinitionsPortlet_{ObjectDefinitionId}
- Set the widget position to 0.
- Set the widget permissions to allow the "Guest" role to have "VIEW" action.

# Example payload

{
      "position": 0,
      "widgetName": "com_liferay_object_web_internal_object_definitions_portlet_ObjectDefinitionsPortlet_F1L7",
  "widgetPermissions": [
    {
      "actionIds": [
        "VIEW"
      ],
      "roleName": "Guest"
    }
  ]      
}