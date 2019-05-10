class Fields(private vararg val fields: Field) {
    fun belongsAllTo(player: Player): Boolean {
        return fields.filter { field -> field.belongsTo(player) }.size == fields.size
    }

}
