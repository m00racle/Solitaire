class GameModel {
    /**
     * This model the game which includes the deck and waste pile. deck is a list (mutable) of card and also the waste
     * pile.
     */
    val deck = Deck()
    val wastePile : MutableList<Card> = mutableListOf() //empty list at first
    val foundationPiles : Array<FoundationPile> = arrayOf(FoundationPile(clubs), FoundationPile(diamonds),
        FoundationPile(hearts), FoundationPile(spades))
    val tableauPiles = Array(7, { TableauPile() })

    fun resetGame() {
        /*
        * this function is called in the first time start the game and when we reset the game
        * it will clear the wastePile and foundationPile objects*/
        //reset the wastePile
        wastePile.clear()
        //reset all piles inside the foundation pile by calling the FoubdationPile object function reset()
        /*for (pile in foundationPiles){
            pile.reset()
        }*/
        //use shorter version to clear each file in the foundationPiles immutable array
        //Question: why here it is immutable? supposedly this can be changed later
        foundationPiles.forEach {
            //call it to represent each file inside foundationPiles, it only represent single
            //object of pile which consist in the above for loop
            it.reset()
        }

        /*
        * reset the deck by calling the Deck object class function reset()
        * this will clear the deck and make new list of card object then shuffle it*/
        deck.reset()

        /*
        * Recreate the tableau piles by using the for each will consist of i + 1 number of cards*/
        tableauPiles.forEachIndexed { index, tableauPile ->
            //form cards in pile with number exactly index + 1 by building and Array of that size and turn it mutable
            val cardsInPile: MutableList<Card> = Array(index + 1, {deck.drawCard()}).toMutableList()
            //add corresponding cardsInPile to the index related tableauPiles
            //Note: why we cannot use the tableauPile instead of tableauPiles[index]?
            tableauPiles[index] = TableauPile(cardsInPile)
        }
    }
}