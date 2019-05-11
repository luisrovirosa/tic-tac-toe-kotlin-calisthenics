class Board() {
    var value = HashMap<Position, Field>()

    init {
        for (col in 0..2) {
            for (row in 0..2) {
                value[Position(row, col)] = Field.of(NoPlayer())
            }
        }
    }

    fun play(player: Player, position: Position) {
        value[position] = Field.of(player)
    }

    fun hasWon(thePlayer: Player): Boolean {
        return hasFilledAnyRow(thePlayer)
                || hasFilledAnyColumn(thePlayer)
                || hasFilledAnyDiagonal(thePlayer)
    }

    private fun hasFilledAnyColumn(player: Player): Boolean {
        return 0.rangeTo(2)
            .any { col(it).belongsAllTo(player) }
    }

    private fun hasFilledAnyRow(thePlayer: Player): Boolean {
        return 0.rangeTo(2)
            .any { row(it).belongsAllTo(thePlayer) }
    }

    private fun hasFilledAnyDiagonal(player: Player): Boolean {
        return diagonalLeftToRight().belongsAllTo(player)
    }

    private fun row(rowNumber: Int): Fields {
        return Fields(value.filterKeys { position -> position.inRow(rowNumber) }.values)
    }

    private fun col(columnNumber: Int): Fields {
        return Fields(value.filterKeys { position -> position.inColumn(columnNumber) }.values)
    }


    private fun diagonalLeftToRight(): Fields {
        return Fields(
            listOf<Field>(
                value[Position(0, 0)]!!,
                value[Position(1, 1)]!!,
                value[Position( 2, 2)]!!
            )
        )
    }

}
