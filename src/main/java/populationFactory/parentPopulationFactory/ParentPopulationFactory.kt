package populationFactory.parentPopulationFactory

import populationFactory.IPopulationFactory

abstract class ParentPopulationFactory : IPopulationFactory {
    abstract fun createPopulation(count: Int)
}