package populationFactory.parentPopulationFactory

import model.PathX
import population.Population
import population.PopulationParent
import java.util.logging.Logger

class ParentPopulationFactoryGreedy : ParentPopulationFactory() {

    lateinit var populationNew: PopulationParent

    override fun createPopulation(count: Int) {
        if (count > PathX.distance.size) {
            val logger = Logger.getLogger(this.javaClass.name)
            logger.warning("""
    Greedy parents become duplicates when their count is more than their length!
    Count = $count, Length = ${PathX.distance.size}
    """.trimIndent())
        }
        populationNew = PopulationParent(mutableListOf())
        var list: MutableList<Int>
        for (k in 0 until count) {

            list = mutableListOf()

            for (i in PathX.distance.indices) {
                if (i == k % PathX.distance.size)
                    list.add(0, i)
                else
                    list.add(i)
            }
            for (i in 0 until list.size - 1) {
                var nearestCity = i + 1
                var nearestCityCost = PathX.distance[list[i]][list[i + 1]]

                for (j in i + 2 until list.size) {
                    if (PathX.distance[list[i]][list[j]] < nearestCityCost) {
                        nearestCity = j
                        nearestCityCost = PathX.distance[list[i]][list[j]]
                    }
                }
                if (i + 1 != nearestCity)
                    list[i + 1] = list[nearestCity].also { list[nearestCity] = list[i + 1] }
            }
            populationNew.add(PathX(list))
        }
    }

    override val population: Population
        get() = populationNew

    override val code: String
        get() = "Pg"
}