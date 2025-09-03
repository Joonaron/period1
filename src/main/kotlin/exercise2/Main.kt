package exercise2

class Fraction(numerator: Int, denominator: Int, private val sign: Int = 1) : Comparable<Fraction> {

    override fun compareTo(other: Fraction): Int {
        return (this.numerator * other.denominator).compareTo(other.numerator * this.denominator)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraction) return false
        return this.numerator == other.numerator && this.denominator == other.denominator
    }

    override fun hashCode(): Int {
        return 31 * numerator + denominator
    }

    var numerator: Int
    var denominator: Int

    init {
        require(denominator != 0) { "Denominator cannot be zero!" }
        val gcd = gcd(numerator, denominator)
        val simplifiedNumerator = numerator / gcd
        val simplifiedDenominator = denominator / gcd

        this.numerator = simplifiedNumerator * sign
        this.denominator = kotlin.math.abs(simplifiedDenominator)
        if (this.numerator < 0 && this.denominator < 0) {
            this.numerator = -this.numerator
            this.denominator = -this.denominator
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else gcd(b, a % b)
    }

    fun add(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.denominator + other.numerator * this.denominator
        val newDenominator = this.denominator * other.denominator
        return Fraction(newNumerator, newDenominator)
    }

    operator fun plus(other: Fraction): Fraction {
        return this.add(other)
    }

    fun subtract(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.denominator - other.numerator * this.denominator
        val newDenominator = this.denominator * other.denominator
        return Fraction(newNumerator, newDenominator)
    }

    operator fun minus(other: Fraction): Fraction {
        return this.subtract(other)
    }

    fun multiply(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.numerator
        val newDenominator = this.denominator * other.denominator
        return Fraction(newNumerator, newDenominator)
    }

    operator fun times(other: Fraction): Fraction {
        return this.multiply(other)
    }

    fun divide(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.denominator
        val newDenominator = this.denominator * other.numerator
        return Fraction(newNumerator, newDenominator)
    }

    operator fun div(other: Fraction): Fraction {
        return this.divide(other)
    }

    fun negate(): Fraction {
        return Fraction(-this.numerator, this.denominator)
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}