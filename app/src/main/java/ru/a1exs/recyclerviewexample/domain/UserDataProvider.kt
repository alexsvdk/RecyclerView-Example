package ru.a1exs.recyclerviewexample.domain

import ru.a1exs.recyclerviewexample.models.User
import kotlin.math.min

class UserDataProvider(
    private val dataGenerator: DataGenerator,
    val count: Int
) {

    val users = mutableListOf<User>()

    val allUsers: List<User>
    get() {
        if (users.size < count) loadAllUsers()
        return users
    }

    fun loadUsers(count: Int) {
        assert(count > 0)
        val addCount = min(this.count-users.size, count)
        users.addAll(List(addCount) { dataGenerator.generateUser() })
    }

    fun loadAllUsers() = loadUsers(this.count)
}