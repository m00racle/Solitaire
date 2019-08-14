class GameModel {
    /**
     * This model the game which includes the deck and waste pile. deck is a list (mutable) of card and also the waste
     * pile.
     */
    val deck = Deck()
    val wastePile : MutableList<Card> = mutableListOf() //empty list at first
    val foundationPiles : Array<FoundationPile> = arrayOf(FoundationPile(clubs), FoundationPile(diamonds),
        FoundationPile(hearts), FoundationPile(spades))
}