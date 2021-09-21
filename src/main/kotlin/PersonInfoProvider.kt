interface PersonInfoProvider {
    val providerInfo : String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId() : String
}

// implement
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val entity:Entity = EntityFactory.create(EntityType.EASY)
    val msg = when(entity) {
        is Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Medium -> "medium class"
        is Entity.Hard -> "hard class"
    }
    println(msg)
}

// type checking, type casting
fun checkType(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")
        // as - type casting
        println(infoProvider.getSessionId())
    }
}