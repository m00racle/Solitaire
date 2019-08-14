class FoundationPile(val suit : String) {
    /**
     * This foundation pile will be a list of card in each suit from ace (int 0) to king (int 12)
     */
    val cards : MutableList<Card> = mutableListOf() //empty list at first

    //3 methods:
    fun reset(){
        /*
        reset the card deck back to empty
         */
        cards.clear()
    }

    fun addCard(card: Card): Boolean {
        /*
        add card corresponds with suit and appropriate value of the card
        initially the pile of cards must be set to be ace (int 0) means nextValue is initially 0 then gradually up
         */
        var nextValue = 0
        //if the pile is already has card means next value will be current highest int + 1
        if (cards.size > 0){
            nextValue = cards.last().cardValue + 1 //NOTE: last() is fun, while cardValue is variable
        }
        //only put cards of the same suit and has value = nextValue
        if (card.suit ==  suit && card.cardValue == nextValue){
            cards.add(card) //add the card to the list
            return true
        }
        //by default and if not be able to satisfy the specification above returns false
        return false
    }

    fun removeCard(card: Card) {
        /*
        remove the specified card from the list cards
         */
        cards.remove(card)
    }
}
