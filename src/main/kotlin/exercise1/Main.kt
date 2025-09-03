package exercise1

class FractionMutable(numerator: Int, denominator: Int, sign: Int = 1){
    private var num: Int
    private var den: Int

    init {
        val gcd = gcd(numerator, denominator)
        val normalizedNum = numerator / gcd
        val normalizedDen = denominator / gcd
        num = if (normalizedDen < 0) -normalizedNum else normalizedNum
        den = if (normalizedDen < 0) -normalizedDen else normalizedDen
        num *= sign
    }

    override fun toString(): String {
        return "$num/$den"
    }
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
    fun mult(other: FractionMutable) {
        val newNum = this.num * other.num
        val newDen = this.den * other.den
        val gcd = gcd(newNum, newDen)
        this.num = (newNum / gcd)
        this.den = (newDen / gcd)
        if (this.den < 0) {
            this.num = -this.num
            this.den = -this.den
        }
    }
    fun div(other: FractionMutable) {
        val newNum = this.num * other.den
        val newDen = this.den * other.num
        val gcd = gcd(newNum, newDen)
        this.num = newNum / gcd
        this.den = newDen / gcd
    }
    fun add(other: FractionMutable) {
        val newNum = this.num * other.den + other.num * this.den
        val newDen = this.den * other.den
        val gcd = gcd(newNum, newDen)
        this.num = newNum / gcd
        this.den = newDen / gcd
    }
    fun negate(){
        this.num = -this.num
    }
    fun intPart(): Int{
        return num/den
    }


}