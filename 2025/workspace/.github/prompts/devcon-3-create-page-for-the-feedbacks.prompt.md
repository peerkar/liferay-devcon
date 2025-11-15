---
name: 'Create a page on a Liferay site'
description: 'Creates a page on a Liferay site'
mode: 'agent'
tools: ['liferay/*']
---

Your task is to create a page on the Liferay site. Use the headless-admin-site/v1.0/sites/{siteExternalReferenceCode}/site-pages endpoint for this task.

If you don't know the site external reference code for "DevCon2025", use the headless-admin-site/v1.0/sites API using the "search" parameter to find it by name.

# Requirements

- Use "Feedback" as the name.
- The page type should be "WidgetPage".
- The page layout should be "1_column".
- The page should be created under the site "DevCon2025".

# Example payload

{
  "name_i18n": {
    "en_US": "Feedback"
  },
  "type": "WidgetPage",
  "pageSettings": {
    "type": "WidgetPageSettings",
    "layoutTemplateId": "1_column"
  }
}
