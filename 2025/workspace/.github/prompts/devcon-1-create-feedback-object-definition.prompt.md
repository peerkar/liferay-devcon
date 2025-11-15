---
name: 'Create an Object Definition for user feedbacks'
description: 'Creates an Object Definition for collecting user feedback in Liferay.'
mode: 'agent'
tools: ['liferay/*']
---

Your task is to generate and publish new Object Definition for user feedback in Liferay using the tools provided. Use the object-admin API for this task.

# Requirements

- Use company scope.
- The name should be "Feedback".
- The must start with uppercase.
- The panelCategoryKey value should be control_panel.object.
- The definition should have only one string field for receiving the feedback.
- The field name should be "feedback".
- The field label should be "What should be fixed in Liferay?".
- The field should be required.
- For object definition and field labels and plural labels use a json like: {en_US: ...}.
- Publish the Object Definition.

# Example payload

{
  "name": "Feedback",
  "panelCategoryKey": "control_panel.object",
  "scope": "company",
  "objectFields": [
        {
          "DBType": "String",
          "businessType": "Text",
          "defaultValue": "null",
          "label": {
            "en_US": "What should be fixed in Liferay?"
          },
          "localized": false,
          "name": "feedback",
          "required": true,
          "type": "String",
          "unique": false
        }
          ],
  "label": {
    "en_US": "Feedback"
  },
  "pluralLabel": {
    "en_US": "Feedbacks"
  }
}

# Exceptional Cases

- If an Object Definition with the name "Feedback" already exists, ask the user to create a new one with a different name. Don't do the lookup upfront, but only if you get an error when creating definition.