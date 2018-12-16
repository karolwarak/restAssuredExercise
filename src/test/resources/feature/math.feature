Feature: Math calculations with subtraction

  Scenario Outline: Can subtraction two numbers
    Given I have <minuent>
    When I subtracted <first_number>
    And I subtracted <second_number>
    Then I have result <result>

    Examples:
    |minuent|first_number|second_number|result|
    |3      |1           |2            |0     |
    |6      |1           |2            |3     |
    |7      |3           |2            |2     |
    |8      |1           |0            |7     |