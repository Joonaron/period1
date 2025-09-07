package exercise3

class StatisticsDisplay(private var weatherStation: WeatherStation): Observer{
    override fun update() {
        weatherStation.getWeatherData()?.let {display(it)}

    }
    private val temperatures = mutableListOf<Float>()

    fun display(weatherData: WeatherData){
        //calculate the average temperature
        temperatures.add(weatherData.temperature)
        val average = if (temperatures.isEmpty()){
            null
        } else{
                temperatures.map {it.toDouble()}.average()
        }

        println("average temperature: $average")
    }
}