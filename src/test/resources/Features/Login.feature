@Login
Feature: Login scenarios

@login
Scenario: To check positive path of login
	Given user is on the login page of the application
	And user enters username,password and clicks on login
	Then user should be navigated to the homepage of the application

