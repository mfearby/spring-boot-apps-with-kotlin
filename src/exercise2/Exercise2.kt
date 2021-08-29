package exercise2

import java.math.BigDecimal

data class Seat(val row: Int, val num: Int, val price: BigDecimal, val description: String) {
    //YOU MAY NOT EDIT THIS CLASS!
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}

data class SeatInfo (val description: String, val price: BigDecimal)

class Theater() {

    // SEAT PRICES:
    // Seats in rows 14 and 15 cost 14.50
    // Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
    // All other seats in row 1 [and 2 according to the picture!] cost 21.00
    // All other seats cost 18.00

    // SEAT DESCRIPTIONS:
    // Seats in row 15: "Back row"
    // Seats in row 14: "Cheaper seat"
    // All other rows, seats 1 to 3 and 34 to 36: "Restricted View"
    // All other seats in rows 1 and 2 "Best view"
    // All other seats: "Standard seat"

    val seats = ArrayList<Seat>() //THIS MUST BE AN IMMUTABLE LIST

    init {
        val temp = ArrayList<Seat>()
        for (x in 1..15) {
            for (y in 1..36) {
                val info = getSeatDetails(x, y)
                temp.add(Seat(x, y, info.price, info.description))
            }
        }
        seats.addAll(temp)
    }

    private fun getSeatDetails(row: Int, num: Int): SeatInfo {
        var info: SeatInfo = when (row) {
            in 1..2 -> SeatInfo("Best view", BigDecimal(21))
            14 -> SeatInfo("Cheaper seat", BigDecimal(14.5))
            15 -> SeatInfo("Back row", BigDecimal(14.5))
            else -> SeatInfo("Standard seat", BigDecimal(18))
        }

        if (row <= 13 && (num <= 3 || num >= 34))
            info = SeatInfo("Restricted view", BigDecimal(16.5))

        return info
    }
}

fun runExercise2() {
    val cheapSeats = Theater().seats.filter {it.price == BigDecimal(14.5)}
    for (seat in cheapSeats) println (seat)
}