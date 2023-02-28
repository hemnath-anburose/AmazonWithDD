Ability: Purchasing in Amazon


Feature: Buy a product in Amazon.in

  Background: 
    Given launch browser and visit amazon india

  @nonexcel
  Scenario: Search a product and buy
    Then search a product
    Then sort the price from high to low
    Then click fifth product
    Then print the details of the product in console
    Then do add cart

  @SC
  Scenario Outline: Search Multiple Products
    Then Search Products "<MyProduct>"
    Then sort the price from high to low
    Then click fifth product
    Then print the details of the product in console
    Then do add cart

    Examples: 
      | MyProduct |
      | xaomi    |
      | yamaha   |
      | axe      |

  @excel
  Scenario Outline: Search a product and buy	From Excel
    Then search from Excel Sheet
      | Excel      | Location                             | Sheet  | Index |
      | prods.xlsx | src/test/resources/Assets/prods.xlsx | Sheet1 |     1 |
    Then sort the price from high to low
    Then click fifth product
    Then print the details of the product in console
    Then do add cart
