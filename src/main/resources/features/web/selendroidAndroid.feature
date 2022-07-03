Feature: Test selendroid test app on android

  Background:
    Given Launch application

  @E2EAndroid @VerifyHomePageTitle
  Scenario: Test Home Page Title
    When user reaches home page
    Then verify the home page title


  @E2EAndroid @VerifyENButtonAndHomePageTitle
  Scenario: Test EN Button and verify home page title
    When user reaches home page
    And Tap on EN button
    And Select option as NO
    Then verify the home page title

  @E2EAndroid @VerifyChromeLogoButton
  Scenario Outline: Test Chrome Logo Button and verify prefered car details
    When user reaches home page
    And tap on Chrome logo button
    Then verify the text "Hello, can you please tell me your name?"
    When user enters its "<name>" in textbox
    And selects prefered car as "<carName>"
    And taps on send me your name
    Then verify the hello text "This is my way of saying hello"
    And verify entered "<name>" and selected "<carName>"
    And click on link "here"

    Examples:
      | name    | carName  |
      | prabhat | Mercedes |

  @E2EAndroid @VerifyFileLogoButton
  Scenario Outline: Test File Logo Button and verify user registration process
    When user reaches home page
    And tap on File logo button
    Then verify the text on registration page as "Welcome to register a new User"
    And Check if the Name eld is pre-populated with "Mr. Burns"
    And Check if "Ruby" is selected as Programming Language by default
    When Fill in the fields with new values as "<name>" "<email>" and "<password>"
    And Select 'I accept adds'
    And Tap on Register User verify
    Then Verify the user details on the next screen as  "<name>" "<email>" and "<password>"
    When Tap on Register User link
    Then Check if the screen navigates to the home screen.
    Examples:
      | name    | email                     | password |
      | prabhat | prabhat.singh@naggaro.com | Pass@123 |

  @E2EAndroid @VerifyProgressButton
  Scenario: Test Progress Button and verify registration page element
    When user reaches home page
    And Tap on Show Progress Bar Button
    Then Wait for the loader to disappear
    And Verify the elements on the user registration on screen

  @E2EAndroid @VerifyToast
  Scenario: Test Toast and verify its text
    When user reaches home page
    And Tap on Display Toast
    Then Verify the toast text

  @E2EAndroid @VerifyPopup
  Scenario: Test Popup and dismiss it
    When user reaches home page
    And Tap on popup
    Then dismiss the popup

  @E2EAndroid @VerifyPressUnhandledException @VerifyUnhandledExceptions
  Scenario: Test Press Unhandled Exception
    When user reaches home page
    And Tap on Press to throw unhandled exception
    Then verify the home page title

  @E2EAndroid @VerifyTypeUnhandledException @VerifyUnhandledExceptions
  Scenario: Test Type Unhandled Exception
    When user reaches home page
    And Tap on Type to throw unhandled exception
    Then verify the home page title