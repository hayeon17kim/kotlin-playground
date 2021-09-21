fun main() {
    val list = listOf("Kotlin", "Java", "C++", "JavaScript", null)
    val map = list
        .filterNotNull()
        .associate { it to it.length }

    val firstLanguage = list.first()
    val lastLanguage = list.last()
    val lastNotNullValue = list.filterNotNull().last()
    val java = list.filterNotNull().find{ it.startsWith("Java") }
    val javascript = list.filterNotNull().findLast{ it.startsWith("JavaScript ")}
    val cannotFound = list.filterNotNull().findLast{ it.startsWith("foo") }.orEmpty()
    println(cannotFound)
}