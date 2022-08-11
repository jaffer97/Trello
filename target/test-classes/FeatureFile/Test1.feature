Feature: Trello

@Login
  Scenario: Login to Trello
    Given Launch the URl "https://trello.com/login"
    When user Enter the login cerdentials username "kingjaffer97@gmail.com" and password "Jaffer@123" 
    And Click on Boards
    
@CreateBoards
   Scenario: Create new List
    Given Enter the board title and Click on Create "Automation"
    When Click on add another list 
    And Add two list named as "A" and "B" 
    And Add card to list and move that to List B
    