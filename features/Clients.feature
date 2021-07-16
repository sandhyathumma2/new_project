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
@clients
Feature: Edit ClientInfo and package options update
  I want to use this template for my feature file

  @clientinfo
  Scenario Outline: Update Client Information
    Given User login to FlickFusion with the correct credentials
    Then validate user logged as "<Role>"
    Given  I Clicks on clients Menu Link    
    When I Clicks on the EditAction Button of "<ClientName>" 
    Then I validate client settings page and verify all menus   
    When I clicks on client information page and updates
    Then I validate for successfull updates
    When I clicks on  options/packages tab
    Then I verify all options with thier status
    Then I select options
    Then I unselect options
    Then logout user
   Examples:  
      | ClientName          |Role|
      | Toyota of Tampa Bay | Flick Fusion Admin|
      
     