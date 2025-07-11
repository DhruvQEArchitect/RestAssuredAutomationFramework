Feature: Test the integration of cucumber with rest assured framework

  @BDD
  Scenario Outline: : This feature file tries to test the integration of cucumber with rest assured framework
    Given User<user> executes carts api

    Examples:
      | user |
      |      |