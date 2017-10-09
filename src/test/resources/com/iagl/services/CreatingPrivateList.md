# Creating a private list

### [Example 1](- "creation with no existing list")

Given a user with no lists.

When a new list [List1](- "#list") is [created](- "#result = createNewListWithNoExistingLists(#list)") by the user.

Then the user has a list named [List1](- "?=#result.list").

### [Example 2](- "creation with existing list")

Given a user with a list [List1](- "#list1").

When a new list [List2](- "#list2") is [created](- "#result = createNewListWithExistingList(#list1, #list2)") by the user.

Then the user has [2](- "?=#result.length") lists : [List1](- "?=#result.list1") and [List2](- "?=#result.list2")

### [Example 3](- "creation with existing list with same name")

Given a user with a list List1.

When a new list [List1](- "#listName") is [created](- "#result = createNewListWithExistingListWithSameName(#listName)") by the user.

Then the system displays an error saying : [There is already a list with this name](- "?=#result.errorMessage")