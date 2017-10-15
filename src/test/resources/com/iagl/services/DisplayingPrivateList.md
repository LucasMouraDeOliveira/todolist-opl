# Displaying a private list

### [Example 1](- "displaying an existing list")

Given a user with a list "[Ma liste](- "#list")".

When the system [searches](- "#result = searchList(#list)") for a liste "Ma liste" for this user.

Then the list "[Ma liste](- "?=#result.list")" is returned.

### [Example 2](- "displaying an invalid list")

Given a user with a list "[Ma liste](- "#list")".

When the system searches for a liste "[Liste de courses](- "#list2)" for this [user](- "#result = searchListWithWrongName(#list, #list2)").

Then the system displays an error saying "[There is no list with this name](- "?=#result.errorMessage")".