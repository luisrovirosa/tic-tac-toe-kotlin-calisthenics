package player

open class Player(val name: String) {

    override fun equals(other: Any?): Boolean {
        if (other is Player){
            return other.name == name
        }
        return false
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

}
