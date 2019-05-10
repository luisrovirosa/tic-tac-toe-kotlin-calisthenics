class TicTacToe {
    private val board = Board()
    private var currentPlayer = Player("X")

    fun winner(): Player {
        return board.winner()
    }


    fun play(position: Position) {
        board.play(currentPlayer, position)
        currentPlayer = if (currentPlayer == Player("X")) Player("O") else Player(("X"))
    }

}
