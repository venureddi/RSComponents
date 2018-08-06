
Feature: End to End Sceanrio
  @Scenario_01
  Scenario: Add Surge Suppressor components to cart
    Given user navigated to 'RS Components' Home page
    And user verifies different sections present on the Home page
    When user clicks on 'All Products' link on Home page
    Then user validates different sections under 'All Products'
    And user clicks on 'Passive Components' under 'Electronics Components' section
    Then the 'Passsive Components' page is displayed
    And user clicks on 'Surge Protection Components'
    Then the 'Surge Protection Components' Page is displayed
    And user clicks on 'Surge Suppressor Units'
    Then the 'Surge Suppressor Units' page is displayed
    And user selects surge suppressor with RS Stock No "456-8099"
    And user clicks on 'Add To Basket' button to add in cart

  @Scenario_02
  Scenario: Add Siemens Sirius 15 kW Compact Feeder
    Given user navigated to 'RS Components' Home page
    And user verifies different sections present on the Home page
    And user clicks on 'Our Brands' link on Home page
    When user clicks on 'Siemens' logo on Top brands section
    Then Siemens brand page is displayed
    And user clicks on 'Automation  Control Gear' under Categories
    And user clicks on 'Advanced Motor Starters' under 'Electrical Motors' section
    And user selects Sirus 15kW compact feeder with RS stock no "500-888"
    And user clicks on 'Add To Basket' button to add in cart

  @Scenario_03
  Scenario: Add Siemens Sirius 15 kW Compact Feeder by searching from the home page
    Given user navigated to 'RS Components' Home page
    And user enters text "Siemens Sirius 15 kW Compact Feeder" in the search field on Home page
    And user selects Sirus 15kW compact feeder with RS stock no "500-771"
    And user clicks on 'Add To Basket' button to add in cart

  @Scenario_04
  Scenario: Using filters to find the required item and add to cart
    Given user navigated to 'RS Components' Home page
    And user verifies different sections present on the Home page
    When user clicks on 'All Products' link on Home page
    Then user validates different sections under 'All Products'
    And user clicks on 'Passive Components' under 'Electronics Components' section
    Then the 'Passsive Components' page is displayed
    And user clicks on 'Surge Protection Components'
    Then the 'Surge Protection Components' Page is displayed
    And user clicks on 'Surge Suppressor Units'
    Then the 'Surge Suppressor Units' page is displayed
    And user apply filters to select brand and Maximum Surge Current
    And user selects "ABB 5 V 10kA OVR" surge suppressor unit
    And user clicks on 'Add To Basket' button to add in cart





