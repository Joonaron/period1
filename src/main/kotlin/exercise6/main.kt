package exercise6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val userFlow: Flow<User> = flow {
        while (true) {
            delay(2000)
            emit(fetchUsers())
        }
    }
        .catch { e ->
            println("Error fetching updates: ${e.message}")
        }
        .flatMapConcat { userList -> userList.asFlow() }
        .filter { user -> user.status == "active" }
        .distinctUntilChanged()

    launch {
        userFlow.collect { user ->
            println("Update: ${user.name} is now active!")
        }
    }
}