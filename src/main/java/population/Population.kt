package population

import model.PathX

abstract class Population(private val origList: MutableList<PathX>) : MutableList<PathX> by origList, IPopulation {

    override lateinit var name: PopulationName

    override val best: PathX
        get() = this.minBy { pathX -> pathX.value }!!

    override val worst: PathX
        get() = this.maxBy { pathX -> pathX.value }!!

    override fun printBestValue() {
        val bestPathX: PathX = best
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