class Board {
    var value = hashMapOf(
        Position(0,0) to Field.of(NoPlayer()),
        Position(0,1) to Field.of(NoPlayer()),
        Position(0,2) to Field.of(NoPlayer()),
        Position(1,0) to Field.of(NoPlayer()),
        Position(1,1) to Field.of(NoPlayer()),
        Position(1,2) to Field.of(NoPlayer()),
        Position(2,0) to Field.of(NoPlayer()),
        Position(2,1) to Field.of(NoPlayer()),
        Position(2,2) to Field.of(NoPlayer())
    )

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
        return (value[Position(row, 0)]!!.belongsTo(player)
                && value[Position(row, 1)]!!.belongsTo(player)
                && value[Position(row, 2)]!!.belongsTo(player))
    }

}
