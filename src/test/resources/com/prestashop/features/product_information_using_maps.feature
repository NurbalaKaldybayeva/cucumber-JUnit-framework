Feature: Complete product information 
Scenario: Product details 
	Given the user is on the home page 
	When the user selects "Printed Summer Dress" 
	Then product name should be "Printed Summer Dress" 
	Then correct default count should be 1 
	
	
Scenario: Product details with map 
	Given the user is on the home page 
	When the user selects "Printed Summer Dress" 
	Then the system should display the product information: 
		|name     |  Printed Summer Dress  |
		|count    |  1                     |
		|condition|  New                   |
		|size     |  S                     |
		|price    |   $28.98               |
		
	
Scenario: Product details with map 2 
	Given the user is on the home page 
	When the user selects "Printed Summer Dress" 
	Then the system should display the product information: 
		|name     | Printed Summer Dress  |
		|count    |          1            |
		|condition|        New            |
		|size     |          S            |
		|price    |       $28.98          |
		
		
	
Scenario Outline: Product details with map and outline 
	Given the user is on the home page 
	When the user selects "<product>" 
	Then the system should display the product information: 
		|name     | <product>  |
		|count    |      1     |
		|condition|     New    |
		|size     |      S     |
		|price    |  <price>   |
		Examples:
		|price   |product              |
		| $28.98 |Printed Summer Dress |	
		| $26.00 |Printed Dress        |
		| $16.40 |Printed Chiffon Dress| 
		
		
		
		
Scenario Outline: verify <page> title
When the user is on the <page>
Then the title and url should be:
|title|<title>|
|url|<url>|	
Examples:
|page      |title           |url|
|home page |My Store        | http://automationpractice.com/index.php|
|login page|Login - My Store| http://automationpractice.com/index.php?controller=authentication&back=my-account|
		  