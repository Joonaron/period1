package exercise4

fun main() {
    val lotto = Lotto()
    val totalGuesses = 13_500_000
    val threadCount = 8
    val guessesPerThread = totalGuesses / threadCount

    val threads = mutableListOf<Thread>()

    val startTime = System.currentTimeMillis()

    for (i in 1..threadCount) {
        val thread = Thread {
            repeat(guessesPerThread){
                lotto.check()
            }
        }
        threads.add(thread)
        thread.start()
    }
    threads.forEach { it.join() }

    val endTime = System.currentTimeMillis()
    println("Aikaa kului: ${endTime - startTime} ms")

    for (i in 0..7){
        val count = lotto.hitStats[i]?.get() ?: 0
        println("$i osumaa: $count kertaa")
    }
    val total = (0..7).sumOf { lotto.hitStats[it]?.get() ?: 0 }
    println("Yhteensä arvauksia: $total")

}