# Renaming a private list

### [Example 1](- "renaming with no existing list")

Given a user with a list called "[Ma liste](- "#nomActuel")"

When the list is renamed "[Liste de courses](- "#nouveauNom")" by the [user](- "#result = renameList(#nomActuel, #nouveauNom)").

Then the user has a list called "[Liste de courses](- "?=#result.newListName")".

### [Example 2](- "renaming fails because another list already has this name")

Given a user with a list called "[Liste 1](- "#liste1")" and a list called "[Liste 2](- "#liste2")".

When the list "Liste 1" is renamed "[Liste 2](- "#liste1NouveauNom")" by the [user](- "#result = renameListWithSameName(#liste1, #liste2)").

Then the system displays an error saying : [There is already a list with this name](- "?=#result.errorMessage")