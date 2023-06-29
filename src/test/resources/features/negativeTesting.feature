Feature: Registration Form
  As a user,
  I want to see a registration form,
  So that I can create an account to access my dashboard.

  Background:
    Given I am on the registration page

  @invalid_email
  Scenario Outline: Negative Testing - Invalid Email Format
    When I fill in an invalid email address "<invalidEmail>"
    Then I should see a validation error with the message "This does not look like a real email"

    Examples:
      | invalidEmail  |
      | invalid_email |

  @short_email
  Scenario Outline: Negative Testing - Invalid Password Length
    When I fill in a valid email address "<validEmail>"
    And I fill in a password shorter characters "<shortPassword>"
    Then I should see a validation error with the message for the short password "Your password needs to be at least 10 characters long."

    Examples:
      | validEmail       | shortPassword |
      | user@example.com | Pass123!      |

  @special_char
  Scenario Outline: Negative Testing - Invalid Password Composition
    When I fill in a valid email address "<validEmail>"
    And I fill in a password without a special character "<passwordWithoutSpecialChar>"
    Then I should see a validation error with the message for the special "Your password needs to be consist of at least 1 letter, 1 number and 1 special character."

    Examples:
      | validEmail       | passwordWithoutSpecialChar |
      | user@example.com | Password123                |

  @mismatched_password
  Scenario Outline: Negative Testing - Password Mismatch
    When I fill in a valid email address "<validEmail>"
    And I fill in a valid password "<validPassword>"
    And I confirm a different password "<mismatchedPassword>"
    Then I should see a validation error with the message for the mismatch "The two passwords do not match."

    Examples:
      | validEmail       | validPassword | mismatchedPassword |
      | user@example.com | Password123!  | MismatchedPass123! |
  @errorAlert
  Scenario Outline: Negative Testing - Submit the form with invalid data
    When I fill in a valid email address "<invalidEmail>"
    And I fill in a valid password "<invalidPassword>"
    And I confirm a different password "<mismatchedPassword>"
    And I submit the form
    Then I should see an alert box with the error message "The form has errors. Please try again."

    Examples:
      | invalidEmail | invalidPassword | mismatchedPassword |
      | user         | Password123!    | MismatchedPass123! |





