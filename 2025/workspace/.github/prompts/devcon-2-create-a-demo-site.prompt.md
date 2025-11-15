---
name: 'Create a site in Liferay'
description: 'Creates a site in Liferay'
mode: 'agent'
tools: ['liferay/*']
---

Your task is to create a Liferay site. Use the headless-admin-site/v1.0/sites endpoint for this task.

# Requirements

- The site name is "DevCon2025".
- Use only the 'name' field in the payload when creating the site.

# Exceptional Cases

- If a site with the name "DevCon2025" already exists, ask the user to create a new one with a different name.