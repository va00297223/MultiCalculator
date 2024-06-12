import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val firstWord = if (Random.nextBoolean()) "Hi there!" else "Hello!"

        return "$firstWord Welcome to ${platform.name}!"
    }
}