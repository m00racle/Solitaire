class Deck {
    //creating array of card and initializing it
    //in Kotlin initialization does not require keyword new
    val cards: Array<Card> = Array(52, fun(i:Int): Card{
        // the anonymous function will returns a Card object with cardValue, and suite
        val value = i%13
        val suite = when(i/13){
            //since i was declared as integer means the division will result in integer
            0 -> "Clubs"
            1 -> "Diamonds"
            2 -> "Hearts"
            else -> "Spades"
        }
        //return the card object with parameter calculated at the anonymous function above
        return Card(value, suite)
    })
}