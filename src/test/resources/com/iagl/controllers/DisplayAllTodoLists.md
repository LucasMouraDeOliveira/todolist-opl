# Displaying all todolists

### [Example 1](- "displaying all todolist of an user")

Given a user "Bob" authentified in the application.

When Bob asks the system to [display](- "#result = displayLists()") all his lists.

Then the systems returns all his lists with a status code [200](- "?=#result.code").

### [Example 1](- "displaying all todolist of an invalid user")

Given a user "John" not authentified in the application.

When John asks the system to [display](- "#result = displayListsWithInvalidUser()") all his lists.

Then the systems returns a status code [404](- "?=#result.code").