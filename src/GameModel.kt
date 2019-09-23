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
        //reset all piles inside the foundation pile
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
    }
}