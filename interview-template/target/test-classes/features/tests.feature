Feature: ValidateBlocks

Scenario: ValidateFirstBlock
Given the user has access to the current block <current> <previous> 
When the user calls the API with previous block <current> <previous>
Then the prev_block field of current block is equal to hash field of previous block
Examples:
|current|previous|
|15|14|
|14|13|
|13|12|
|12|11|
|11|10| 