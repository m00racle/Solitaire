//global package variable, all files which uses this package can access this values. Since it was values not mutable
val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"

val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(clubs, spades)

class Card(val cardValue : Int, val suit : String, var faceUp : Boolean =  false)