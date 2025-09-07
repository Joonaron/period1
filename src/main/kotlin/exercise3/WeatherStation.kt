package exercise3

class WeatherStation: Subject{

    override val observers: ArrayList<Observer> = ArrayList()



    private var currentData: WeatherData? = null

    fun measurementsChanged(newData: WeatherData){
        this.currentData = newData
        println("The weatherstation got an update: $newData")
        notifyObserver()

    }
    fun getWeatherData(): WeatherData? = currentData
}