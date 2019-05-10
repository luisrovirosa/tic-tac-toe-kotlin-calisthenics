class TicTacToe {
    val board = Board()

    fun winner(): Player {
        return board.winner()
    }

    private var currentPlayer = Player("X")

    fun play(position: Position) {
        board.play(currentPlayer, position)
        currentPlayer = if (currentPlayer == Player("X")) Player("O") else Player(("X"))
    }

}
