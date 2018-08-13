Feature: Users should be able to login

Scenario: User registration
Given  the user is on the login page
And the user enters a random email 
And the user enters personal information
|First Name|Kunnka      |
|Last Name | Admiral    |
|City      | Anytown    |
|Address   | 123 Main st|
|Company   |  Volvo     |


Scenario: User registration
Given  the user is on the login page
And the user enters a random email 
And the user enters user information

|First Name|Last Name | City  | Address   | Company|
|Kunnka    |Admiral   |Anytown|123 Main st| Volvo  | 

# lines below are not implemented
Scenario: user info
Then correct user info should be displayed
|First Name|Last Name | City  | Address   | Company|
|Kunnka    |Admiral   |Anytown|123 Main st| Volvo  | 
And I login as this user
|First Name|Last Name | 
|Kunnka    |Admiral   |
And I order these
|name|count|size|
|dress |123 |S  |
|dress |123 |M  |
|tshirt|1   |M  |