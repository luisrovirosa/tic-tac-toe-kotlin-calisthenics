import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicTacToeShould {
    @Test
    fun `at the beginning of the game there is no winner`() {
        val ticTacToe = TicTacToe()

        val winner = ticTacToe.winner()

        assertEquals(NoPlayer(), winner)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `a X player wins when 3 fields of a row are taken by the X player`(row: Int) {
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
    @ValueSource(ints = [0, 1, 2])
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


    @Test
    fun `no player wins when there is no 3 filled on any direction`() {
        val ticTacToe = TicTacToe()
        ticTacToe.play(Position(0, 0))
        ticTacToe.play(Position(0, 1))
        ticTacToe.play(Position(0, 2))
        ticTacToe.play(Position(1, 1))
        ticTacToe.play(Position(1, 0))
        ticTacToe.play(Position(1, 2))
        ticTacToe.play(Position(2, 1))
        ticTacToe.play(Position(2, 0))
        ticTacToe.play(Position(2, 2))

        val winner = ticTacToe.winner()

        assertEquals(NoPlayer(), winner)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `a X player wins when 3 fields of a column are taken by the same player`(row: Int) {
        val ticTacToe = TicTacToe()
        ticTacToe.play(Position(0, row))
        ticTacToe.play(Position(0, (row + 1) % 3))
        ticTacToe.play(Position(1, row))
        ticTacToe.play(Position(0, (row + 2) % 3))
        ticTacToe.play(Position(2, row))

        val winner = ticTacToe.winner()

        assertEquals(Player("X"), winner)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `a O player wins when 3 fields of a column are taken by the same player`(row: Int) {
        val ticTacToe = TicTacToe()
        ticTacToe.play(Position(0, (row + 1) % 3))
        ticTacToe.play(Position(0, row))
        ticTacToe.play(Position(1, (row + 1) % 3))
        ticTacToe.play(Position(1, row))
        ticTacToe.play(Position(0, (row + 2) % 3))
        ticTacToe.play(Position(2, row))

        val winner = ticTacToe.winner()

        assertEquals(Player("O"), winner)
    }

}