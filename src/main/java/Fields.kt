class Fields(private val fields: Collection<Field>) {
    fun belongsAllTo(player: Player): Boolean {
        return fields.all { field -> field.belongsTo(player) }
    }

}
