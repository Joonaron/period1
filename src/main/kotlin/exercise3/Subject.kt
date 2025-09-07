package exercise3

interface Subject {
    val observers: ArrayList<Observer>

    fun addObserver(observer: Observer){
        observers.add(observer)
    }
    fun removeObserver(observer: Observer){
        observers.remove(observer)
    }
    fun notifyObserver(){
        observers.forEach{it.update()}
    }
}