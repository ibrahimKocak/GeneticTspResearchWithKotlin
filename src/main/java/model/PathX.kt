package model


class PathX : MutableMap.MutableEntry<MutableList<Int>, Int> {

    override val key: MutableList<Int>
    override var value = 0
        private set

    constructor(cities: List<Int>) {
        checkDistance()
        key = ArrayList(cities)
        commit()
    }

    constructor(pathX: PathX) {
        checkDistance()
        key = ArrayList(pathX.key)
        value = pathX.value
    }

    fun commit() {
        var cost = 0
        val citySize = key.size
        for (i in 0 until citySize - 1) cost += distance[key[i]][key[i + 1]]
        value = cost
    }

    fun equals(other: PathX): Boolean {
        return this.key == other.key && this.value == other.value
    }

    override fun toString(): String {
        return "" + key +
                "\t\t" + value
    }

    override fun setValue(newValue: Int): Int {
        this.value = newValue
        return this.value
    }

    private fun checkDistance() {
        if (distance.isEmpty()) throw RuntimeException("Attention!!! Distance values not set for " + this.javaClass.simpleName + ".class.")
    }

    companion object {
        var distance: Array<IntArray> = arrayOf()
            private set

        fun setDistanceValues(distanceValues: IDistanceValues) {
            distance = distanceValues.values
        }
    }
}