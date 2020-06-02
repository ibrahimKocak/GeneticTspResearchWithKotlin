package populationFactory.childPopulationFactory

import model.PathX
import population.Population

class ChildPopulationFactoryByAdding : ChildPopulationFactoryCreationPreparatory() {
    override fun createPopulation(population: Population, count: Int) {
        prepareToCreate(population, count)
        for (i in 0 until count) {
            for (j in 0 until parentTemp[0].key.size) populationNew[i].key.add(parentTemp[i].key[j])
        }
        populationNew.forEach(PathX::commit)
    }

    override val population: Population
        get() = populationNew

    override val code: String
        get() = "Ca"
}