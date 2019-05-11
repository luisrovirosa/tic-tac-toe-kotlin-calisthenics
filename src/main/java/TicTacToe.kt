class TicTacToe {
    private val board = Board()
    private var currentPlayer = Player("X")

    fun winner(): Player {
        if (board.hasFilledAnyRow(Player("X"))) {
            return Player("X")
        }
        if (board.hasFilledAnyRow(Player("O"))) {
            return Player("O")
        }
        return NoPlayer()
    }

    fun play(position: Position) {
        board.play(currentPlayer, position)
        currentPlayer = if (currentPlayer == Player("X")) Player("O") else Player(("X"))
    }
}
