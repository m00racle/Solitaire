class Deck {
    //creating array of card and initializing it
    //in Kotlin initialization does not require keyword new
    val cards: Array<Card> = Array(52) {Card(it%13, getSuite(it))}

    private fun getSuite(i: Int) = when(i/13){
            //since i was declared as integer means the division will result in integer
            0 -> "Clubs"
            1 -> "Diamonds"
            2 -> "Hearts"
            else -> "Spades"
        }
}