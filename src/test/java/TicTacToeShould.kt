import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicTacToeShould {
    @Test
    fun `at the beginning of the game there is no winner`() {
        val ticTacToe = TicTacToe()

        val winner = ticTacToe.winner()

        assertEquals(NoWinner(), winner)
    }

    @ParameterizedTest
    @ValueSource(ints = [0])
    fun `a X player wins when 3 fields of a row are taken by the same player`(row: Int) {
        val ticTacToe = TicTacToe()
        ticTacToe.play(Position(row, 0))
        ticTacToe.play(Position((row + 1) % 3, 0))
        ticTacToe.play(Position(row, 1))
        ticTacToe.play(Position((row + 2) % 3, 0))
        ticTacToe.play(Position(row, 2))

        val winner = ticTacToe.winner()

        assertEquals(Player("X"), winner)
    }

    @ParameterizedTest
    @ValueSource(ints = [0])
    fun `a O player wins when 3 fields of a row are taken by the O player`(row: Int) {
        val ticTacToe = TicTacToe()
        ticTacToe.play(Position((row + 1) % 3, 0))
        ticTacToe.play(Position(row, 0))
        ticTacToe.play(Position((row + 1) % 3, 1))
        ticTacToe.play(Position(row, 1))
        ticTacToe.play(Position((row + 2) % 3, 0))
        ticTacToe.play(Position(row, 2))

        val winner = ticTacToe.winner()

        assertEquals(Player("O"), winner)
    }

}