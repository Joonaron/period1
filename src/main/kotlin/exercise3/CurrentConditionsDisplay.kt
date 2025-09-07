package exercise3

class CurrentConditionsDisplay(private var weatherStation: WeatherStation): Observer {
    override fun update() {

        weatherStation.getWeatherData()?.let {display(it)}

    }
    fun display(weatherData: WeatherData){
        println("Current conditions: Temperature is ${weatherData.temperature}C, Humidity is ${weatherData.humidity}%, pressure is ${weatherData.pressure}Ps")
    }
}