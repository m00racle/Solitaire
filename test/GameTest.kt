import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        /*
        * This test function will test if the King will go up to the foundation pile.
        * This will simulate numerous games in order to simulate if the foundation pile can be filled with 13 cards
        * it will simulate maximum of 10.000 games
        * each games will take 100 steps of tapping the deck pile, waste pile and tableau pile which will run the cards
        * if there's a valid movements of cards available*/

        //arrange:
        //record the number of games
        var numGames = 0
        //set max number of games to be 10.000 times
        val maxGames = 50000

        //act:
        //for games from the first to the max games set play the game:
        for (session in 1..maxGames) {
            //keep record of session number
            numGames++
            //start the new game:
            GameModel.resetGame()
            //simulate 100 steps each game session
            for (steps in 1..100){
                //simulate tapping on deck pile
                GamePresenter.onDeckTap()
                //simulate tapping on waste pile
                GamePresenter.onWasteTap()
                //simulate tapping on each tableau pile to play the cards:
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    //simulate the presented tapping on each (by index) tableau pile
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            //if the game is finished (with a foundation pile card size reach 13 then break
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        //assert:
        //print the prove of the finished game
        GameModel.debugPrint()
        //print the number of sessions it takes to finish the game
        println("number of session(s) taken: $numGames")
        //assert that it took less than max number of games to finish
        assert(numGames < maxGames)
    }
}