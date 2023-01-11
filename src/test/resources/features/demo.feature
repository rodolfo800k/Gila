Feature: Gila Demo
    Scenario Outline: Search for approved loans
        Given User logs in to the application "<username>" "<password>"
        When User lands on Loan Manager Page with all controls present
        And User searches for approved loans
        Then All the retrieved loans must have status as approved

        Examples:
        |username                                            |password     |
        |loanproqaautomatedapitesting+atestpractice@gmail.com|%Wd5u50Q1?121|

