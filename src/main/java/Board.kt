class Board {
    var value = hashMapOf<Position, Player>()

    fun play(player: Player, position: Position) {
        value[position] = player
    }

    fun winner(): Player {
        if (Player("X") == value[Position(0, 0)]
            && Player("X") == value[Position(0, 1)]
            && Player("X") == value[Position(0, 2)]
        ) {
            return Player("X")
        }
        if (Player("O") == value[Position(0, 0)]
            && Player("O") == value[Position(0, 1)]
            && Player("O") == value[Position(0, 2)]
        ) {
            return Player("O")
        }
        return NoWinner()
    }

}
