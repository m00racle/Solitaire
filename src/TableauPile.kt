class TableauPile(var cards : MutableList<Card>) {
    /*
    This is model of the tableau pile which consist playable cards in the deck. The last card of each list
    mut be face up
     */
    init {
        cards.last().faceUp //make the last card of the list face up
    }

    fun addCard(newCards : MutableList<Card>) : Boolean{
        /*
        Assumes newCards is a list of Cards which can be moved between card pile in the tableau pile. The card can be
        moved to another list of cards in tableau only if the first value of the newCards list is exactly one smaller
        than the last card of the tableau list and if the suit is opposite color of the tableau suit
        returns boolean if the newCards can be accepted to the
         */
        if (cards.size > 0) {
            //if the cards is not empty
            if (newCards.first().cardValue == cards.last().cardValue - 1 &&
                suitCheck(newCards.first().suit, cards.last().suit)
            ) {
                //add all cards moved in new cards to existing cards
                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().cardValue == 12){
            //if the existing cards list is empty a list of cards with king in the top can be moved there
            cards.addAll(newCards)
            return true
        }
        return false
    }

    private fun suitCheck(suit1: String, suit2: String): Boolean {
        /*
        part of the addCard method intended to check the suit of first new cards and the last of existing cards suits
        are indeed not in the same color
        assumes suit1 and suit2 are Strings for specifying suit of the corresponding cards
        returns boolean if suit1 and suit2 are different in suit color
         */

        return !(redSuits.contains(suit1) && redSuits.contains(suit2))
    }
}