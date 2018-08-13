@login
Feature: login
@smoke
Scenario: login link
 Given the user is on the home page
  When the user clicks on the Sign in link
  Then username and password fields should be displayed
  
 
  Scenario: verify user name and last name
  Given the user is on the login page
  When I login using username "nitoyey@dumoac.net" and password "password"
  Then users full name "John" "Smith" should be displayed 