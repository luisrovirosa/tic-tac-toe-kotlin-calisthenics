class TicTacToe {
    val board = Board()

    fun winner(): Player {
        return board.winner()
    }

    fun play(position: Position) {
        board.play(Player("X"), position)
    }

}
