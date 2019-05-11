package board

import player.Player

class Field(private val belongsToPlayer: Player) {
    companion object {
        fun of(player: Player) = Field(player)
    }

    fun belongsTo(player: Player): Boolean {
        return belongsToPlayer == player
    }
}
