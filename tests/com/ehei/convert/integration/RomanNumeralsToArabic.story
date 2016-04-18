Roman Numerals to Arabic

Narrative:
As a marketing manager
I want customers to be able to convert numerals to numbers
So that they can buy the latest version of the game

					 
Scenario: Converting Roman Numerals to Arabic
Given I have started the converter
When I enter Roman Numeral $numeral
Then $number is returned

Examples:
|numeral|number|
|I|1|
|III|3|
|IX|9|
|MLXVI|1066|
|MCMLXXXIX|1989|
