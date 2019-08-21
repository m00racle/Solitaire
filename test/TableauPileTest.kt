import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {

    @Test
    fun addCards() {
        //Arrange
        //: create tableauPile object with a card already put inside it
        val tableauPile = TableauPile(mutableListOf(Card(12,spades)))
        //: create card object
        val cardsWillBeAdded = mutableListOf(Card(11,diamonds))
        //Act
        //: add the card object to tableauPile object
        tableauPile.addCards(cardsWillBeAdded)
        //Assert
        //: assert if the number of card in the tableauPile is two
        assertEquals("failed to add card",2, tableauPile.cards.size)
    }

    @Test
    fun preventUnintendedSuitCardToBeAdded() {
        //Arrange
        val tableauPile = TableauPile(mutableListOf(Card(12,spades)))
        val cardsWithSameSuitColor = mutableListOf(Card(11,clubs))
        //Act
        tableauPile.addCards(cardsWithSameSuitColor)
        //Assert
        assertEquals("unintended suit card", 1,tableauPile.cards.size)
    }

    @Test
    fun preventUnintendedValueCardToBeAdded(){
        //Arrange
        val tableauPile = TableauPile(mutableListOf(Card(12,spades)))
        val cardsWithNoSuitableValue = mutableListOf(Card(10, diamonds))
        //Act
        tableauPile.addCards(cardsWithNoSuitableValue)
        //Assert
        assertEquals("unintended value card",1,tableauPile.cards.size)
    }

    @Test
    fun removeCards() {
        //Arrange
        val tableauPile = TableauPile(mutableListOf(Card(4,clubs), Card(3,hearts),
            Card(2,spades)))
        //Act
        tableauPile.removeCards(1)
        //Assert
        assertEquals("remove cards", mutableListOf(Card(4,clubs,true)), tableauPile.cards)
    }
}