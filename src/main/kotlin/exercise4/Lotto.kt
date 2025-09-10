package exercise4

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

class Lotto{
    private val lottoNumbers = mutableSetOf<Int>().apply{
        while (size < 7) add(Random.nextInt(0,40))
    }
    val hitStats = ConcurrentHashMap<Int, AtomicInteger>().apply{
        for (i in 0..7) put(i, AtomicInteger(0))
    }

    fun generateGuess(): Set<Int>{
        val guess = mutableSetOf<Int>().apply{
            while (size < 7)add(Random.nextInt(0,40))
        }
        return guess
    }


    fun check(){
        val guess = generateGuess()
        val hits = guess.count{it in lottoNumbers}
        hitStats[hits]?.incrementAndGet()
    }


}