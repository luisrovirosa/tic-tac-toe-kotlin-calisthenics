class TmpFields(val value: Map<Position, Field>) {
    fun belongsAllTo(player: Player): Boolean {
        return value.all { it -> it.value.belongsTo(player) }
    }

    fun row(rowNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inRow(rowNumber) })
    }

    fun col(columnNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inColumn(columnNumber) })
    }

    fun diagonalLeftToRight(): TmpFields {
        return TmpFields(
            value.filterKeys {
                it == Position(0, 0)
                        || it == Position(1, 1)
                        || it == Position(2, 2)
            }
        )
    }

    fun diagonalRightToLeft(): TmpFields {
        return TmpFields(
            value.filterKeys {
                it == Position(0, 2)
                        || it == Position(1, 1)
                        || it == Position(2, 0)
            }
        )
    }

}
