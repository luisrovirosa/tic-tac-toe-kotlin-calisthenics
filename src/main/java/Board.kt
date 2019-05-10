class Board {
    var value = hashMapOf<Position, Player>()

    fun play(player: Player, position: Position) {
        value[position] = player
    }

    fun winner(): Player {
        if (Player("X") == value[Position(0,0)]){
            return Player("X")
        }
        return NoWinner()
    }

}
