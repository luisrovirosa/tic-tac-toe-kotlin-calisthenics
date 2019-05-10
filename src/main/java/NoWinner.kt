class NoWinner : Player() {
    override fun equals(other: Any?): Boolean {
        return other is NoWinner
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

}
