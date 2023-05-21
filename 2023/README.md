# Liferay DevCon 2023

Resources and sample codes to the workshop on 25th May 2023.

If you'll be attending the workshop and wish to do the exercises, please follow the instructions below set up the environment in advance of the workshop. Setup will take ~ 5-10 mins.

During the workshop we won't be able to do the setup because of limited time.

## Workshop Setup Instructions

The exercises require a running Liferay bundle and a demo site which is provided as an importable archive. Registration to IPStack geolocation service is required for one of the exercises.

### Prerequisites

1. A running Liferay DXP 7.4 U73+ bundle

### 1. Create a Blank Demo Site

1. Download the site archive Pages-20230521205716035.lar from the *setup/demo-site* folder
1. Go to *Control Panel -> Sites*
1. Create a new Site "University of Blueprints" with the "Blank Site" template
1. Go to the *Publishing -> Import* on the new site
1. Create a new Import process
1. Import the site archive
1. Done


### 2. Import the Elements

1. Download the element JSONs from *setup/elements*
1. Go to *Applications -> Blueprints*
1. Go to *Elements* tab
1. Import the elements one by one by clicking the menu icon on the top right of the screen (3 vertical dots)
1. Done

### 3. Import the Blueprints

1. Download the element JSONs from *setup/blueprints*
1. Go to *Applications -> Blueprints*
1. Import the Blueprints one by one by clicking the menu icon on the top right of the screen (3 vertical dots)
1. Done

### 4. Create a Free IPStack Account

IPStack offers a free plan, but registration is required. 

If you choose to register:

1. Go to https://ipstack.com
1. Click 'Sign Up for Free'
1. On the plan selection page, click 'Get Free API Key' on the 'Free Plan'
1. Complete the registration
1. Copy the API key from your account page

### 5. Configure IPStack service

1. Go to *Control Panel -> System Settings -> Search Experiences -> IPStack*
1. Paste the API key, but don't enable the service yet
1. Save the configuration
1. Done

### 6. Modify the Portal User Account

1. Go to your portal bundle user account settings
1. In the categorization, add *Porto* from *Campus* vocabulary
1. Add *Staff* from *Target Group* vocabulary
1. Save 

## Blueprint Conditions Cheatsheet

Conditions are a way to make Blueprint elements conditional with the help of parameters available in the Blueprint context. The available, standard parameters can be listed in the side panel of Element editor. 

If an element has multiple query entries, each of them can be made conditional. For better readability it's recommended to have only one query entry per element, though.

The structure of an element:

	{
	   "description_i18n": {},
	   "elementDefinition": {
	     "category": "panel category",
	     "configuration": {
	       "queryConfiguration": {
	         "queryEntries": [
	           {
	             "condition": {},
	             "clauses": []
	           }
	         ]
	       }
	     },
	     "icon": "some icon"
	   },
	   "title_i18n": {}
	 }
  
See more examples in the [OOTB element definitions](https://github.com/liferay/liferay-portal/tree/master/modules/dxp/apps/search-experiences/search-experiences-service/src/main/resources/com/liferay/search/experiences/internal/model/listener/dependencies)

### allConditions 
All the conditions have to match.

**Examples:**

```
"condition": {
  "allConditions": [
    {
      "contains": {
        "parameterName": "user.active_segment_entry_ids",
        "value": 12345
      }
    },
    {
      "contains": {
        "parameterName": "user.job_title",
        "value": "boss"
      }
    }								
  ]
}
```

### anyConditions
At least one of the conditions in the group has to match.

```
"condition": {
  "anyConditions": [
    {
      "contains": {
        "parameterName": "user.regular_role_ids",
        "value": 20222
      }
    },
    {
      "contains": {
        "parameterName": "user.job_title",
        "value": "boss"
      }
    }								
  ]
}
```

**Examples:**

###contains
Checks whether the array value contains the given value or one of the given values.

**Examples:**

```
"condition": {
	"contains": {
		"parameterName": "user.group_ids",
		"value": [20119, 20020, 20125]
	}
}
```

```
"condition": {
	"contains": {
		"parameterName": "user.job_title",
		"value": "boss"
	}
}
```

###equals
**Examples:**

```
"condition": {
	"equals": {
		"parameterName": "user.is_signed_in",
		"value": true
	}
}
```
```
"condition": {
	"equals": {
		"parameterName": "user.email_domain",
		"value": "liferay.com"
	}
}
```

### exist
Checks whether the parameter is available in the context. Can be used for example with custom parameters.

**Examples:**

```
"condition": {
	"exists": {
		"parameterName": "my_parameter"
	}
}
```


### in
Checks whether the parameter value in one of the given values.

**Examples:**

```
"condition": {
	"in": {
		"parameterName": "context.scope_group_id",
		"value": [20119, 20020, 20125]
	}
}
```					

### not
A wrapper condition negating the wrapped condition.

**Examples:**

```
"condition": {
	"not": {
		"equals": {
			"parameterName": "user.job_title",
			"value": "the boss"		
		}
	}
}
```

### range

**Examples:**

The condition below checks whether the creation date of user account was within the last month:

```
"condition": {
	"range": {
		"format": "yyyyMMdd",
		"gte": "${time.current_date|modifier=-30d,date_format=yyyyMMdd}",
		"lte": "${time.current_date|modifier=+1d,date_format=yyyyMMdd}",
		"parameterName": "user.create_date"
	}
}
```
