fun main() {
    //since Kotlin 1.3 the main parameters are not required to be stated in the fun main()

    //calling the GameModel object directly since it was a singleton object
    GameModel.resetGame()
    //add one simulated tap on the deck
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}