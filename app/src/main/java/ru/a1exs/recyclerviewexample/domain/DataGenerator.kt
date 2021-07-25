package ru.a1exs.recyclerviewexample.domain

import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.FakerConfig
import io.github.serpro69.kfaker.create
import ru.a1exs.recyclerviewexample.models.User
import java.util.*
import kotlin.math.absoluteValue

private val gifs = listOf(
    "https://media.giphy.com/media/Z37amIryHcLTy/giphy.gif",
    "https://media.giphy.com/media/o2V3s21kb9jPO/giphy.gif",
    "https://media.giphy.com/media/f08cafueoCoRW/giphy.gif",
    "https://media.giphy.com/media/KjqnOCVXbIkiA/giphy.gif",
);

class DataGenerator {

    private val random: Random
    private val faker: Faker

    init {
        random = Random(1337)
        val config = FakerConfig.builder().create {
            random = this@DataGenerator.random
            uniqueGeneratorRetryLimit = 111
        }
        faker = Faker(config)
    }

    fun generateUser(): User = User(
        faker.name.firstName(),
        faker.name.lastName(),
        faker.address.city(),
        generateColor(),
        gifs[random.nextInt().absoluteValue % (gifs.size - 1)]
    )

    private fun generateColor(): Int = 0x888888 + (random.nextInt() % (0x888888-1))

}