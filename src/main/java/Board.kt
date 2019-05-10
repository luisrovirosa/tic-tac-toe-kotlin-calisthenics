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
        if (playerX == value[Position(0, 0)]
                && playerX == value[Position(0, 1)]
                && playerX == value[Position(0, 2)]){
            return true
        }
        if (playerX == value[Position(1, 0)]
                && playerX == value[Position(1, 1)]
                && playerX == value[Position(1, 2)]){
            return true
        }
        if (playerX == value[Position(2, 0)]
                && playerX == value[Position(2, 1)]
                && playerX == value[Position(2, 2)]){
            return true
        }
        return false
    }

}
