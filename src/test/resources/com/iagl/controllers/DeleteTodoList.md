# Deleting a Todolist

### [Example 1](- "deleting an existing list")

Given a user "Bob" authentified in the application with a list "[Liste de Bob](- "#list")".

When Bob asks the system to [delete](- "#result = deleteList(#list)") his list.

The the system returns a code [200](- "?=#result.code").

### [Example 2](- "deleting an invalid list")

Given a user "Bob" authentified in the application with no lists.

When Bob asks the system to delete a list "Liste 1".

Then the system returns a code 404.

### [Example 2](- "deleting a list with an invalid user")

Given a user "John" who doesn't exist in the application.

When John asks the system to delete a list "Liste 1".

Then the system returns a code 404.