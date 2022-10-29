# Always write 'Feature:' keyword in feature file
Feature: Signin 

Scenario: Signin button
Given User should be on SignIn Page
When User mouse hover on sign in menu
And Click on the Sign in button
Then Page title should be "Amazon Sign In"

Scenario: Signin with credentials
Given User should be on SignIn Page
When User enter the username "sp1612eeece1@gmail.com" 
And User click on sign in button
Then User should be redirected to SignInRedirect page 
And Page title of SignInRedirect  page should be "Amazon Sign In"
