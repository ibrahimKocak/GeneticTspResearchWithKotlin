package populationFactory.childPopulationFactory

import population.Population

abstract class ChildPopulationFactoryCreationPreparatory : ChildPopulationFactory() {

    override fun prepareToCreate(population: Population, count: Int) {
        init(population, count)
        for (i in 0 until count) {
            for (j in 0 until length) {
                if (super.template[j]) {
                    populationNew[i].key.add(parent[i].key[j])
                    parentTemp[i].key.remove(parent[i].key[j])
                }
            }
        }
    }
}