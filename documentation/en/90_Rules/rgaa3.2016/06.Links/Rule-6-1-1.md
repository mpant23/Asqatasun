# RGAA 3.2016 - Rule 6.1.1

## Summary
This test consists in checking whether the context of each text link is enough explicit to understand the purpose and the target.

## Business description

### Criterion
[6.1](http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/criteres.html#crit-6-1)

### Test
[6.1.1](http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/criteres.html#test-6-1-1)

### Description
<div lang="fr">Chaque <a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/glossaire.html#lien-texte">lien texte</a> v&#xE9;rifie-t-il une de ces conditions (hors <a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/cas-particuliers.html#cp-6-1,6-3" title="Cas particuliers pour le crit&#xE8;re 6.1">cas particuliers</a>)&nbsp;? <ul><li>L&#x2019;<a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/glossaire.html#intitul-de-lien">intitul&#xE9; de lien</a> seul permet d&#x2019;en comprendre la fonction et la destination&nbsp;;</li> <li>Le <a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/glossaire.html#contexte-du-lien">contexte du lien</a> permet d&#x2019;en comprendre la fonction et la destination.</li> </ul></div>

### Level
**A**

## Technical description

### Scope
**Page**

### Decision level
**Semi-Decidable**

## Algorithm

### Selection

##### Set1

All the `<a>` tags with a `"href"` attribute, without children (a[href]:not(:has(*)))

##### Set2

All the elements of **Set1** with a not empty text and without context (assuming [the definition of a link context in Rgaa3.0](http://disic.github.io/rgaa_referentiel_en/RGAA3.0_Glossary_English_version_v1.html#mContexteLien))

##### Set3

All the elements of **Set1** with a not empty text, with a context (assuming [the definition of a link context in Rgaa3.0](http://disic.github.io/rgaa_referentiel_en/RGAA3.0_Glossary_English_version_v1.html#mContexteLien))

in other words :

size(**Set1**) = size(**Set2**) + size(**Set3**)

### Process

##### Test1

For each element of **Set2**, we check whether the link content is not pertinent (see Notes about relevancy detection)

For each element returning true in **Test1**, raise a MessageA, raise a MessageB instead

##### Test2

For each element of **Set3**, we check whether the link content is not pertinent (see Notes about relevancy detection)

For each element returning true in **Test2**, raise a MessageC, raise a MessageD instead

##### MessageA : Unexplicit Link

-   code : UnexplicitLink
-   status: Failed
-   parameter : link text, `"title"` attribute, snippet
-   present in source : yes

##### MessageB : Check link without context pertinence

-   code : CheckLinkWithoutContextPertinence
-   status: Need More Info
-   parameter : link text, `"title"` attribute, snippet
-   present in source : yes

##### MessageC : Unexplicit Link With context

-   code : UnexplicitLinkWithContext
-   status: Need More Info
-   parameter : link text, `"title"` attribute, snippet
-   present in source : yes

##### MessageD : Check link with context pertinence

-   code : CheckLinkWithContextPertinence
-   status: Need More Info
-   parameter : link text, `"title"` attribute, snippet
-   present in source : yes

### Analysis

#### Not Applicable

The page has no textual link (**Set1** is empty)

#### Failed

At least one textual link without context has a text content which is blacklisted or only composed of non-alphanumerical characters (**Test1** returns false for at least one element)

#### Pre-qualified

In all other cases

## Notes

We assume here that the links are only composed of a text. (`<a href="http://www.asqatasun.org/target.html">`my link`</a>`)

All the links that have children different from `<img>`, `<canvas>`, `<object>` or `<svg>` are considered as combined links.

**Definition of not-pertinent link title :**

A link title is seen as not-pertinent in the following cases :

-   the link title is blacklisted (regarding the LinkTextBlacklist nomenclature)
-   the link only contains not alphanumerics characters



##  TestCases

[TestCases files for rule 6.1.1](https://github.com/Asqatasun/Asqatasun/tree/develop/rules/rules-rgaa3.2016/src/test/resources/testcases/rgaa32016/Rgaa32016Rule060101/)


