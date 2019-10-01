//global package variable, all files which uses this package can access this values. Since it was values not mutable
val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"

val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(clubs, spades)

//make map of value to card symbol in order to make it simpler
val cardsMap = mapOf(0 to "A", 1 to "2", 2 to "3" , 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8",
    8 to "9", 9 to "10", 10 to "J", 11 to "Q", 12 to "K")

data class Card(val cardValue : Int, val suit : String, var faceUp : Boolean =  false){
    override fun toString(): String {
        /*
        * this function will override the default toString function
        * it will print the value, suit, and faceUp status of any card
        * we use string templates of $ to make it simple*/

        return "${cardsMap[cardValue]} $suit $faceUp"
    }
}