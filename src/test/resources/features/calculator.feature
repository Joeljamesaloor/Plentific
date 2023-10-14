Feature: Basic Calculator Operations

  Scenario Outline: Perform basic operations
    Given I launch the calculator app
    When I <operation> <num1> and <num2>
    Then the result should be correct

    Examples:
      | operation | num1 | num2 |
      | add       | 2    | 4    |
      | subtract  | 5    | 3    |
      | multiply  | 5    | 3    |
      | divide    | 6    | 3    |
      | multiply  | 5    | 0    |

  Scenario Outline: Divide by zero
    Given I launch the calculator app
    When I divide <num> by 0
    Then the calculator should display "Infinity"

    Examples:
      | num |
      | 5   |
      | 6   |
      | 7   |
