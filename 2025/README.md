# Liferay DevCon 2025 Resources

Here are additional resources to the DevCon talk *Making Liferay "AI ready" through an MCP Server*. The slides and the presentation resources can be found [here](https://github.com/4lejandrito/liferay-devcon-2025-mcp).

The examples below are using the default test user account with Basic auth.

## Setting Up the Liferay MCP Server

1. Have at least the 2025.q4 release bundle or Docker image installed.
1. Enable the beta feature flag `LPD-63311`.

To verify that it’s running, go to: http://localhost:8080/o/mcp/sse

## Connecting VSCode Copilot to the Liferay MCP Server

1. Have the Liferay instance running
1. Create a file `.vscode/mcp.json` on the VSCode workspace with this content:
```
{
  "servers": {
    "liferay": {
      "url": "http://localhost:8080/o/mcp/sse",
      "type": "http",
      "headers": {
        "Authorization": "Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0"
      }
    }
  }
}
```

3. Click the tools button in the chat box:

![Tools Button](tools.png)

4. Check the `MCP Server: liferay`
5. Start chatting f.ex `list Liferay instances` 

To see alternative way of configuring MCP servers see the [VSCode documentation](https://code.visualstudio.com/docs/copilot/customization/mcp-servers)

## Connecting Gemini CLI to the Liferay MCP Server

1. Have the Liferay instance running
1. Follow the instructions [here](https://geminicli.com/docs/get-started/installation/) to install and run the Gemini CLI and to authenticate to Google
1. Open the `.gemini/settings.json` configuration file in your home folder
1. Configure the mcpServers like this:

```
{
  "security": {
    "auth": {
      "selectedType": "oauth-personal"
    }
  },
  "mcpServers": {
    "liferay": {
      "url": "http://localhost:8080/o/mcp/sse",
      "headers": {
        "Authorization": "Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0"
      },
      "timeout": 30000,
      "trust": true
    }
  }
}
```
5. If running the CLI, restart to refresh the configuration
6. Check the connection by entering `/mcp list`. You should see the Liferay MCP server green and the three tools listed.
7. Start prompting f.ex. `list liferay instances`

## Example Liferay Prompts for VSCode

1. Clone this repo
1. Open the `workspace` folder in the VSCode
1. Start chatting with `/` and the VSCode will autocomplete

Please notice that the prompt number 5 relies on the Jira MCP server configured as well. 

See a collection of other VSCode prompt examples [here](https://github.com/github/awesome-copilot/tree/main/prompts).
