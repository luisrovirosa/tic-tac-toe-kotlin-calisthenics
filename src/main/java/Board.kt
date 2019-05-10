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
        val fields = Fields(
            value[Position(row, 0)]!!,
            value[Position(row, 1)]!!,
            value[Position(row, 2)]!!
        )
        return fields.belongsAllTo(player)
    }

}
