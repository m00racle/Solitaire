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

    fun onDeckTap() {
        /*
        * This function act when user tap on the deck pile
        * Remember this solitaire game we use single card rule which user can only draw one card each time from deck*/
        if (deck.cardsInDeck.size > 0){
            //if there are cards inside the deck then one card will be drawn
            val card = deck.drawCard()
            //then make that card face up
            card.faceUp = true
            //then transfer that card to waste pile
            wastePile.add(card)
        } else {
            //else if there are no card left on the deck then the waste pile need to return to the deck
            //remember user may take the cards from the waste pile thus the returned pile is what is left
            deck.cardsInDeck = wastePile.toMutableList()
            //since above we only copy the left of waste pile then we need to clear the waste pile
            wastePile.clear()
        }
    }
}