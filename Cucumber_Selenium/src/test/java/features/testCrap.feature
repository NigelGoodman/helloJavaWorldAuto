Feature: Login Feature
  Verify if user is able to Login in to the site

 # Scenario: Login as a authenticated user
 #   Given user is on homepage
 #   When user goes to Grid FAQ
 #   And user clicks option eight
 #   Then the view the musical formats explaination
 
 Scenario: Go to Analysis board
 Given the user is on lichess
 And they hover over the tools menu
 When they click on Analysis board
 Then They are taken to the analysis board
 
  Scenario: Turn on analysis
 Given the user is on the analysis board
 When they turn the analysis on
 Then analysis activates