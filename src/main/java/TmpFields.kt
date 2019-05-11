class TmpFields(val value: Map<Position, Field>) {
    fun belongsAllTo(player: Player): Boolean {
        return value.all { it -> it.value.belongsTo(player) }
    }
}
