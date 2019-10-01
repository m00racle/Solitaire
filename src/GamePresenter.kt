object GamePresenter {
    /*
    * This class is intended as presenter layer of the whole app
    * it's task is to be the middleman between the view (which is the interface) and the model (GameModel)
    * This is turned into a singleton object since through all the play we only need one presenter
    * */

    //created a view object but since it was on the starts then the app UI will not yet ready, thus set it to null
    var view: GameView? = null

    //populate the view with GameView interface instantiation
    fun setGameView(gameView: GameView) {
        view = gameView
    }

    //for each of the user action in tapping various part of the game UI we need to pass it into changing the state
    //of the model call each corresponding function in the GameModel object
    fun onDeckTap(){
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap(){
        GameModel.onWasteTap()
        view?.update()
    }

    fun onFoundationTap(foundationIndex:Int){
        GameModel.onFoundationTap(foundationIndex)
        view?.update()
    }

    fun onTableauTap(tableauIndex:Int, cardIndex:Int){
        GameModel.onTableauTap(tableauIndex, cardIndex)
        view?.update()
    }
}