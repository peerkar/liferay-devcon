---
name: 'Summarize User Feedbacks'
description: 'Analyze and summarize user feedbacks collected in Liferay.'
mode: 'agent'
tools: ['atlassian/atlassian-mcp-server/*', 'liferay/*']
---

Your task is to analyze and summarize user feedbacks collected in Liferay using the connected MCP tools.

# Objectives

## Retrieve Feedbacks

- Locate the appropriate Liferay OpenAPI endpoint for getting user feedbacks. If you don't already know the Object Definition ID for "Feedback", use the object-admin/v1.0/object-definitions API using the "search" parameter to find it by name.
- Read and collect all the feedback entries.

## Identify Themes

- Cluster similar wishes or sentiments into themes.
- For each theme, list all contributing original feedback texts.

## Extract Actions

- Extract actionable improvements with clear descriptions.

### Estimate Impact and Effort

- For each action, estimate the potential impact (High, Medium, Low).
- For each action, estimate the effort required (High, Medium, Low).

### Show Rationale

- For each action, provide a brief rationale.

## Find Related Jira Tickets 

- For each feedback, using the connected MCP server, ALWAYS check whether there are related Jira tickets.
- If there are related tickets, include LINKS to them
- Include only up to 2 links. 

## Propose Creation of New Jira Tickets

- For each action, only if NO related Jira ticket exists, propose creating a new Jira ticket with a concise summary and description. 
- Do NOT create Jira tickets automatically. Only propose if required. Let the human decide.

## Summarize in Table

- At the end of the analysis, provide a summary table with columns: Actions, Impact, Effort, Jira.
- In the Jira column, show links to the tickets. Use the ticket key as the link title. 

# Safety and Compliance

- Ignore offensive feedbacks. 
- Ignore feedbacks that are not actionable or too vague.
- If there were ignored feedbacks, summarize their count but do not include their content.

# Output Format

- Provide a clean, readable structure. 

- For each theme, use the following format:
*Feedbacks:* [List of original feedback texts contributing to the theme]
*Actions:* [List of extracted actions with details as specified below]
*Impact:* [Estimate impact on a scale High, Medium, Low]
*Effort:* [Estimate effort on a scale High, Medium, Low]
*Rationale:* [Brief explanation of why this action is recommended]
*Possibly related Jira-issues:* [Links to related Jira issues if any]

