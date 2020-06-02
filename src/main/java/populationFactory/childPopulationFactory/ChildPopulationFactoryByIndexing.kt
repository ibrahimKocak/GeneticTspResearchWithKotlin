package populationFactory.childPopulationFactory

import model.PathX
import population.Population

class ChildPopulationFactoryByIndexing : ChildPopulationFactoryCreationPreparatory() {
    override fun createPopulation(population: Population, count: Int) {
        prepareToCreate(population, count)
        for (i in 0 until count) {
            var index = 0
            for (j in 0 until length) {
                if (!template[j]) {
                    populationNew[i].key.add(j, parentTemp[i].key[index])
                    index++
                }
            }
        }
        populationNew.forEach(PathX::commit)
    }

    override val population: Population
        get() = populationNew

    override val code: String
        get() = "Ci"
}