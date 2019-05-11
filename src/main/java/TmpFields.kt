class TmpFields(val value: Map<Position, Field>) {
    fun row(rowNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inRow(rowNumber) })
    }

    fun col(columnNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inColumn(columnNumber) })
    }

    fun belongsAllTo(player: Player): Boolean {
        return value.all { it -> it.value.belongsTo(player) }
    }
}
