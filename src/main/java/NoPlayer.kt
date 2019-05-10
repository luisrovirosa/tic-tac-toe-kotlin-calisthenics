class NoPlayer : Player("") {
    override fun equals(other: Any?): Boolean {
        return other is NoPlayer
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

}
