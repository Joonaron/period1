package exercise3

fun main(){
    val weatherStation = WeatherStation()
    val currentDisplay = CurrentConditionsDisplay(weatherStation)
    val statsDisplay = StatisticsDisplay(weatherStation)

    weatherStation.addObserver(currentDisplay)
    weatherStation.addObserver(statsDisplay)

    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(WeatherData(25.0f, 65f,
        1012f))
    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(WeatherData(27.5f, 70f,
        1011f))
    weatherStation.removeObserver(statsDisplay)

    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(WeatherData(26.0f, 90f,
        1013f))



}