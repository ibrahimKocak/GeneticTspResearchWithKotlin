package populationFactory.childPopulationFactory

import model.PathX
import population.Population
import population.PopulationChild
import populationFactory.IPopulationFactory

abstract class ChildPopulationFactory : IPopulationFactory {

    protected lateinit var populationNew: PopulationChild
    protected var length: Int = 0
    lateinit var parent: Population
    lateinit var parentTemp: Population
    lateinit var template: MutableList<Boolean>

    fun init(population: Population, count: Int) {
        populationNew = PopulationChild(mutableListOf())
        parent = PopulationChild(mutableListOf())
        parentTemp = PopulationChild(mutableListOf())
        val childCreationTemplate = ChildCreationTemplate()
        childCreationTemplate.buildRandomTemplate()
        template = childCreationTemplate.randomTemplate

        for (i in 0 until count) {
            populationNew.add(PathX(mutableListOf()))
            parent.add(population[i % population.size])
            parentTemp.add(PathX(population[i % population.size]))
        }
        parentTemp.shuffle()
        length = population[0].key.size
    }

    abstract fun prepareToCreate(population: Population, count: Int)
    abstract fun createPopulation(population: Population, count: Int)
}