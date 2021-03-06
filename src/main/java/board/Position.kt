package board

class Position(val row: Int, val column: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Position){
            return other.row == row && other.column == column
        }
        return false
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        return result
    }

    fun inRow(rowNumber: Int): Boolean {
        return row == rowNumber
    }

    fun inColumn(columnNumber: Int): Boolean {
        return column == columnNumber
    }
}
