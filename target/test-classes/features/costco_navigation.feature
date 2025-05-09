Feature: Costco Website Navigation
  As a Costco website user
  I want to be able to search products and navigate different sections
  So that I can find products and services I'm interested in

  Scenario: Search for laptop
    Given I am on Costco homepage
    When I enter "laptop" in the search box
    And I click the search button
    Then I should see laptop search results

  Scenario: Navigate to Deals page
    Given I am on Costco homepage
    When I click on the Deals link
    Then I should be redirected to the Deals page

  Scenario: Navigate to Travel page
    Given I am on Costco homepage
    When I click on the Travel link
    Then I should be redirected to the Travel page