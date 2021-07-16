@tag
Feature: login page 
  I want to login to the system with different roles

  @tag1
  Scenario Outline: Title of your scenario
    Given User login to FlickFusion with the correct credentials
    Then validate user logged as "<Role>"
    
    Examples: 
      | Role               |
      | Flick Fusion Admin |
    @datadrivenlogin 
    Scenario Outline: Login to Flick Fusion with diffrent users
    Given User login to FlickFusion with the "<username>" and "<password>" credentials
    Then validate user logged as "<Role>"
    Then logout user
    
    Examples: 
      | Role               |username| password|     
      |Flick User					 |chatuser1|chatuser1|
