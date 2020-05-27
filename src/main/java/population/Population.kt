package population

import model.PathX

abstract class Population : ArrayList<PathX>(), IPopulation {

    override lateinit var name: PopulationName

    override val bestValue: PathX
        get() = this.minBy { pathX -> pathX.value }!!

    override fun printBestValue() {
        val bestPathX: PathX = bestValue
        println("""Best of $name
        ${bestPathX.key}	${bestPathX.value}""")
    }

    override fun toString(): String {
        val s = StringBuilder()
        s.append("\n").append(name).append("\n")
        for (i in this.indices) s.append(i).append("\t").append(this[i].key).append("\t\t").append(this[i].value).append("\n")
        return s.toString()
    }
}