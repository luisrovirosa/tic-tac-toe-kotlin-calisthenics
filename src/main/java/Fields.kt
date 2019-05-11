class Fields(private val value: HashMap<Position, Field>) {
    constructor() : this(HashMap())

    fun belongsAllTo(player: Player): Boolean {
        return value.all { it -> it.value.belongsTo(player) }
    }

    fun row(rowNumber: Int): Fields {
        return Fields(value.filterKeys { position -> position.inRow(rowNumber) } as HashMap<Position, Field>)
    }

    fun col(columnNumber: Int): Fields {
        return Fields(value.filterKeys { position -> position.inColumn(columnNumber) } as HashMap<Position, Field>)
    }

    fun diagonalLeftToRight(): Fields {
        return Fields(
            value.filterKeys {
                it == Position(0, 0)
                        || it == Position(1, 1)
                        || it == Position(2, 2)
            } as HashMap<Position, Field>
        )
    }

    fun diagonalRightToLeft(): Fields {
        return Fields(
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
