Feature: Registration Form
  As a user,
  I want to see a registration form,
  So that I can create an account to access my dashboard.

  Background:
    Given I am on the registration page

  @validData
  Scenario Outline: Positive Testing
    When I fill in a valid email address "<validEmail>"
    And I fill in a valid password "<validPassword>"
    And I confirm the password "<validPassword>"
    And I check the start trial checkbox
    And I submit the form
    Then I should see an alert box with the message "Thanks for registering"

    Examples:
      | validEmail       | validPassword |
      | user@example.com | Password123!  |

  @checkbox
  Scenario Outline: Checkbox Message
    When I fill in a valid email address "<validEmail>"
    And I fill in a valid password "<validPassword>"
    And I confirm the password "<validPassword>"
    And I check the start trial checkbox
    Then I should see a validation message "Your trial version license will expire on the 17th August 2022"

    Examples:
      | validEmail       | validPassword |
      | user@example.com | Password123!  |