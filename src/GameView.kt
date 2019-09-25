interface GameView {
    /*
    * This interface will be used as View which model the user interface to the game model.
    * It will consist of one abstract function called update which updates both user interface and the game models state
    * */
    fun update(model: GameModel = GameModel)
    /*
    * NOTE: This function take GameModel type object which already being converted from class to object in order to
    * state that this GameModel object is a singleton*/
}