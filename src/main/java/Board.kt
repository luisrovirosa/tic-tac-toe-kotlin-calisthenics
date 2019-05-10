class Board {
    var value = hashMapOf<Position, Player>()

    fun play(player: Player, position: Position) {
        value[position] = player
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

    private fun hasFilledTheRow(playerX: Player, row: Int): Boolean {
        return (playerX == value[Position(row, 0)]
                && playerX == value[Position(row, 1)]
                && playerX == value[Position(row, 2)])
    }

}
