package populationFactory

import model.IAppComponent
import population.Population

interface IPopulationFactory : IAppComponent {
    val population: Population
}