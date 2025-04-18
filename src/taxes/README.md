# tax-calculator
A small task from an OOP course on the topic “Interfaces”

Task:

You are required to implement a tax calculator for different types of individuals. There are three types: Individual Entrepreneur (IE) (ИП), Self-employed (самозанятый), and Natural Person (физлицо). The tax rates are as follows:

    IE: 45%
    Natural Person: 30%
    Self-employed: 10%

These rates are hypothetical and used for example purposes only.

Your task is to:

1. Implement a Calculator interface that contains the method double calculate(double income);.
2. You are provided with a TaxCalculator class that includes the following methods:
   - `double calculateTax(double income, String personType);`
   - `Calculator getCalculator(String personType);`

You need to write the implementation for these methods. The calculateTax method should use the appropriate tax rate based on the personType and return the calculated tax. The getCalculator method should return the appropriate Calculator implementation depending on the type of individual (IE, Self-employed, or Natural Person).
