# Creating a todolist

### [Example 1](- "creating a new list")

Given a user "Bob" authentified in the application and who has no lists.

When the list "[Liste 1](- "#list")" is [created](- "#result = createList(#list)") by Bob.

Then the system sends a code [200](- "?=#result.code").

### [Example2](- "creating a new list with the same name as another one")

Given a user "Bob" authentified in the application and who has a list "[Liste 1](- "#list")".

When another list also called "Liste 1" is [created](- "#result = createAlreadyExistingList(#list)") by Bob.

Then the system sends a code [400](- "?=#result.code").

### [Example2](- "creating a new list with an invalid user")

Given a user "John" who doesn't exist in the application.

When a list called "[Liste 1](- "#list")" is [created](- "#result = createListWithInvalidUser(#list)") by John.

Then the system sends a code [404](- "?=#result.code").

