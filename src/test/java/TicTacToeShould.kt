import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TicTacToeShould {
    @Test
    fun `at the beginning of the game there is no winner`() {
        val ticTacToe = TicTacToe()

        val winner = ticTacToe.winner()

        assertEquals(NoWinner(), winner)
    }
}