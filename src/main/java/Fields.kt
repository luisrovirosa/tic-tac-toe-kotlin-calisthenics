class Fields(private val fields: Collection<Field>) {
    fun belongsAllTo(player: Player): Boolean {
        return fields.filter { field -> field.belongsTo(player) }.size == fields.size
    }

}
