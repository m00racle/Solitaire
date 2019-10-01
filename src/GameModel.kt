object GameModel {
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

    fun onWasteTap() {
        /*
        * This function is called when the waste pile is tapped. Here when the card can be played
        * then the card can be removed from the top of the waste pile*/
        //check if there are any card in the waste pile only the available one can be played
        if (wastePile.size > 0) {
            //get the latest (top) card on the waste pile
            val card = wastePile.last()
            //check if the card is playable
            if (cardIsPlayable(card)){
                //if it is playable then we remove the card from the waste pile
                wastePile.remove(card)
            }
        }
    }

    fun onFoundationTap(foundationIndex:Int) {
        /*
        * Assumes foundationIndex is an integer of index of the foundation pile which will denotes which suite
        * it corresponds
        * This function will be called if the foundation pile is tapped. If the card is playable then the card
        * will be removed from the foundation pile*/
        //designate the foundation pile by using the index
        val foundationPile = foundationPiles[foundationIndex]

        //check if there are indeed cards in corresponding foundation pile
        if (foundationPile.cards.size > 0){
            //if the card is playable then remove it from the foundation pile the card is the last card in the
            //foundation pile
            val card = foundationPile.cards.last()
            if (cardIsPlayable(card)){
                //if the card is playable then just remove it from this foundation pile
                foundationPile.cards.remove(card)

                /* NOTE: don't worry if the first check of each foundationPile will return true because it will
                always return false since the last card is not yet removed thus this card will never eligible
                to be added into the foundationPile*/
            }
        }
    }

    fun onTableauTap(tableauIndex:Int, cardIndex:Int){
        /*
        * Assumes tableauIndex and cardIndex are Integers which denotes the index of the tapped tableau and highest
        * card index by the user respectively
        * This function is called when user tap any cards in the tableau pile. It will process the
        * tableau index and card index to remove the card if the card is playable*/

        //: designate the intended tableau to tap
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.cards.size > 0) {

            //: if the tableau really has card then process if the card is playable
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            //NOTE: the sublist information is in the doc

            //: if the card is playable the remove it from the card index and so on to the last card in the tableau
            if (cardIsPlayable(cards)){
                //NOTE: this time we give a Mutable list of Cards as parameter thus we need to define another function
                //of cardIsPlayable but with Mutable list of Cards as parameter
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    private fun cardIsPlayable(cards: MutableList<Card>): Boolean {
        //if the cards is only consist of one card then just called the old cardIsPlayable function
        if (cards.size == 1){cardIsPlayable(cards)} else{
            //else just check each of the cards whether it can be added to other tableau pile or not
            tableauPiles.forEach {
                if (it.addCards(cards)){
                    return true
                }
            }
        }

        //if nothing makes criteria just return false
        return false
    }

    private fun cardIsPlayable(card: Card): Boolean {
        /*
        Assumes: card is a Card object
        * this function will determine if the card variable is playable
        * by looking at the latest cards inside the tableau pile and foundation pile*/

        //checking each foundation pile
        foundationPiles.forEach {
            //if it can be added the card in the foundationPile then return true
            //remember foundationPile is becomes it here
            if (it.addCard(card)){
                //remember the function foundationPile addCard function return boolean
                return true
            }
        }

        //checking each tableau pile
        tableauPiles.forEach {
            //if it can be added the card in the tableau pile then return true
            //remember to use addCard in tableau pile we use mutable list to accommodate multiple cards movements
            if (it.addCards(mutableListOf(card))){
                //remember the addCards function of the tableau pile class returns boolean
                return true
            }
        }
        return false
    }

    fun debugPrint(){
        /*
        * This function is used for debug and test purposes
        * this will printout cards designated by testing the play*/

        //test 1: printing the top card of the deck
        println(deck.cards.last())
    }
}