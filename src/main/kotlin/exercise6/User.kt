package exercise6


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.IOException

data class User(val id: Int, val name: String, val status: String)

// Mock data source – DO NOT MODIFY
val allUsers = listOf(
    User(1, "Alice", "inactive"),
    User(2, "Bob", "active"),
    User(3, "Charlie", "inactive"),
    User(4, "Diana", "inactive")
)

// Simulated network function
private var fetchCount = 0
fun fetchUsers(): List<User> {
    println("Fetching user data...")
    fetchCount++
    if (fetchCount > 4) {
        throw IOException("Simulated network error: Server is down.")
    }
    val updatedUsers = allUsers.map { it.copy() }.toMutableList()
    val userToActivate = updatedUsers.filter { it.status == "inactive" }.randomOrNull()
    userToActivate?.let {
        val index = updatedUsers.indexOf(it)
        updatedUsers[index] = it.copy(status = "active")
    }
    return updatedUsers
}

