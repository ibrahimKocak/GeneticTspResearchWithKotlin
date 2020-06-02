package populationFactory.parentPopulationFactory

import model.PathX
import population.Population
import population.PopulationParent
import java.util.*

class ParentPopulationFactoryRandom : ParentPopulationFactory() {

    lateinit var populationNew: PopulationParent

    override fun createPopulation(count: Int) {

        populationNew = PopulationParent(mutableListOf())
        var listTemp: MutableList<Int>

        for (i in 0 until count) {
            listTemp = ArrayList()
            for (j in PathX.distance.indices) listTemp.add(j)
            listTemp.shuffle()
            populationNew.add(PathX(listTemp))
        }
    }

    override val population: Population
        get() = populationNew

    override val code: String
        get() = "Pr"
}