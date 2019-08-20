class Deck {
    //creating array of card and initializing it
    //in Kotlin initialization does not require keyword new
    val cards: Array<Card> = Array(52) {Card(it%13, getSuite(it))}

    //need to change the immutable Array to mutable list of cards
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    //add function to draw a card from the deck the top one as index 0
    fun drawCard(): Card = cardsInDeck.removeAt(0)

    //add reset function to start the game and shuffle the mutable list
    fun reset() {
        //this returns void and only shuffle the card in deck
        cardsInDeck = cards.toMutableList()
        //the Kotlin suggest that Java Collections.shuffle(cardsIndeck) is changed to Kotlin static function of
        //cardsInDeck (which already a Collections class object) and directly call shuffle.
        cardsInDeck.shuffle()
    }

    private fun getSuite(i: Int) = when(i/13){
            //since i was declared as integer means the division will result in integer
            0 -> clubs
            1 -> diamonds
            2 -> hearts
            else -> spades
        }
}