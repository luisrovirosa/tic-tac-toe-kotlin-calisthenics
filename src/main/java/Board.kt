class Board() {
    var value = HashMap<Position, Field>()

    init {
        for(col in 0..2){
            for (row in 0..2){
                value[Position(row, col)] = Field.of(NoPlayer())
            }
        }
    }


    fun play(player: Player, position: Position) {
        value[position] = Field.of(player)
    }

    fun winner(): Player {
        if (hasFilledAnyRow(Player("X"))) {
            return Player("X")
        }
        if (hasFilledAnyRow(Player("O"))) {
            return Player("O")
        }
        return NoPlayer()
    }

    private fun hasFilledAnyRow(thePlayer: Player): Boolean {
//        return 0.rangeTo(2)
//            .filter { row -> hasFilledTheRow(thePlayer, row) }
//            .isNotEmpty()

        for (row in 0..2) {
            if (hasFilledTheRow(thePlayer, row)) {
                return true
            }
        }
        return false
    }

    private fun hasFilledTheRow(player: Player, row: Int): Boolean {
        return row(row).belongsAllTo(player)
    }

    private fun row(rowNumber: Int): Fields {
        val fields = Fields(
            value[Position(rowNumber, 0)]!!,
            value[Position(rowNumber, 1)]!!,
            value[Position(rowNumber, 2)]!!
        )
        return fields
    }

}
