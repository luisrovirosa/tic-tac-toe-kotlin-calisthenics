class Board {
    var value = hashMapOf<Position, Player>()

    fun play(player: Player, position: Position) {
        value[position] = player
    }

    fun winner(): Player {
        if (hasFilledOneRow(Player("X"))) {
            return Player("X")
        }
        if (hasFilledOneRow(Player("O"))) {
            return Player("O")
        }
        return NoPlayer()
    }

    private fun hasFilledOneRow(playerX: Player): Boolean {
        return (playerX == value[Position(0, 0)]
                && playerX == value[Position(0, 1)]
                && playerX == value[Position(0, 2)])
    }

}
