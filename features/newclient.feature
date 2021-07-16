#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Adds new client
  I want to create new client and other validations

  @addnewcient
  Scenario Outline: New Client Information
    Given User login to FlickFusion with the correct credentials
    Then validate user logged as "<Role>"
    Given  I Clicks on clients Menu Link    
    When I Clicks on the AddClient Button
    Then Add client information and validate 
    Then logout user
   Examples:  
      | Role          |Rooftop ID|
       |Flick Fusion Admin| 123|
 
