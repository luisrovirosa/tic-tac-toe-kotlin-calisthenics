class TmpFields(private val value: HashMap<Position, Field>) {
    constructor() : this(HashMap())

    fun belongsAllTo(player: Player): Boolean {
        return value.all { it -> it.value.belongsTo(player) }
    }

    fun row(rowNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inRow(rowNumber) } as HashMap<Position, Field>)
    }

    fun col(columnNumber: Int): TmpFields {
        return TmpFields(value.filterKeys { position -> position.inColumn(columnNumber) } as HashMap<Position, Field>)
    }

    fun diagonalLeftToRight(): TmpFields {
        return TmpFields(
            value.filterKeys {
                it == Position(0, 0)
                        || it == Position(1, 1)
                        || it == Position(2, 2)
            } as HashMap<Position, Field>
        )
    }

    fun diagonalRightToLeft(): TmpFields {
        return TmpFields(
            value.filterKeys {
                it == Position(0, 2)
                        || it == Position(1, 1)
                        || it == Position(2, 0)
            } as HashMap<Position, Field>
        )
    }

    fun replace(position: Position, with: Field) {
        value[position] = with
    }

}
