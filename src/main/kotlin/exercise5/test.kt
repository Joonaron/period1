package exercise5
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(){
    runBlocking{
        launch {
            println("Hello")
            println("Hello")
            println("Hello")
        }
        launch {
            println("Moi")
            yield()
            println("moi")
            yield()
            println("moi")
        }
    }
}