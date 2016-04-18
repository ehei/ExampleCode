Arabic to Roman Numerals

Narrative:
As a game developer
I want to be able to convert a number to a numeral
So that I can label my game releases using Roman numerals
					 
Scenario: Converting Arabic Numbers to Roman Numerals
Given I have started the converter
When I enter a $number
Then the Roman Numeral representation $numeral is returned

Examples:
|number|numeral|
|1|I|
|2|II|
|3|III|
|4|IV|
|5|V|
|6|VI|
|9|IX|
|1066|MLXVI|
|1989|MCMLXXXIX|
