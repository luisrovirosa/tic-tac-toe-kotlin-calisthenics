class Board {
    private val fields = TmpFields()

    init {
        for (col in 0..2) {
            for (row in 0..2) {
                fields.replace(Position(row, col), Field.of(NoPlayer()))
            }
        }
    }

    fun play(player: Player, position: Position) {
        fields.replace(position, Field.of(player))
    }

    fun hasWon(thePlayer: Player): Boolean {
        return hasFilledAnyRow(thePlayer)
                || hasFilledAnyColumn(thePlayer)
                || hasFilledAnyDiagonal(thePlayer)
    }

    private fun hasFilledAnyColumn(player: Player): Boolean {
        return 0.rangeTo(2)
            .any { fields.col(it).belongsAllTo(player) }
    }

    private fun hasFilledAnyRow(thePlayer: Player): Boolean {
        return 0.rangeTo(2)
            .any { fields.row(it).belongsAllTo(thePlayer) }
    }

    private fun hasFilledAnyDiagonal(player: Player): Boolean {
        return fields.diagonalLeftToRight().belongsAllTo(player)
                || fields.diagonalRightToLeft().belongsAllTo(player)
    }

}
