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

        for (rowNumber in 0..2) {
            if (row(rowNumber).belongsAllTo(thePlayer)) {
                return true
            }
        }
        return false
    }

    private fun row(rowNumber: Int): Fields {
        return Fields(value.filterKeys { position -> position.inRow(rowNumber) }.values)
    }

}
