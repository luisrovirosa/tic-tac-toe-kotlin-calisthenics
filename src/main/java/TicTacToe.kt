import board.Position
import board.Board
import player.NoPlayer
import player.Player

class TicTacToe {
    private val board = Board()
    private val players = arrayOf(Player("X"), Player("O"))
    private var currentPlayer = 0

    fun winner(): Player {
        if (board.hasWon(Player("X"))) {
            return Player("X")
        }
        if (board.hasWon(Player("O"))) {
            return Player("O")
        }
        return NoPlayer()
    }

    fun play(position: Position) {
        board.play(currentPlayer(), position)
        currentPlayer = (currentPlayer + 1) % 2
    }

    private fun currentPlayer() = players[currentPlayer]
}
