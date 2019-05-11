import board.Position
import board.Board
import player.NoPlayer
import player.Player

class TicTacToe {
    private val board = Board()
    private val players = arrayOf(Player("X"), Player("O"))
    private var currentPlayer = 0

    fun winner(): Player {
        for (player in players){
            if (board.hasWon(player)) {
                return player
            }
        }
        return NoPlayer()
    }

    fun play(position: Position) {
        board.play(currentPlayer(), position)
        currentPlayer = (currentPlayer + 1) % 2
    }

    private fun currentPlayer() = players[currentPlayer]
}
