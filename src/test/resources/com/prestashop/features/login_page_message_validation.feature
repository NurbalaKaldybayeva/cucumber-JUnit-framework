Feature: Error message on the login page


Scenario: Invalid email
  Given the user is on the login page
When the user tries to register an invalid email
Then the system should display error message "Invalid email address."
 
Scenario: blank email
  Given the user is on the login page
When the user tries to register blank email
Then the system should display error message "Invalid email address."
 
Scenario: existing email
  Given there is an existing email
  And the user is on the login page
When the user tries to register the same email
Then the system should display error message "An account using this email address has already been registered. Please enter a valid password or request a new one."
