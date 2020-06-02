package populationFactory.parentPopulationFactory

import model.DistanceInstance1
import model.PathX
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import population.Population

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParentPopulationFactoryTest {

    private lateinit var parentPopulationFactory: ParentPopulationFactory

    @Test
    fun randomParentFactoryTest() {
        parentPopulationFactory = ParentPopulationFactoryRandom()
        parentPopulationFactory.createPopulation(5)
        val population: Population = parentPopulationFactory.population

        assert(population.size == 5)
        assert(population[0].value != 0)
    }

    @Test
    fun greedyParentFactoryTest() {
        parentPopulationFactory = ParentPopulationFactoryGreedy()
        parentPopulationFactory.createPopulation(1)
        val population: Population = parentPopulationFactory.population
        val pathX = PathX(listOf(0, 12, 14, 18, 20, 7, 4, 11, 9, 8, 16, 13, 15, 1, 5, 17, 19, 6, 2, 10, 3))

        assert(population.bestValue.equals(pathX))
    }

    @BeforeAll
    fun init() {
        PathX.setDistanceValues(DistanceInstance1)
    }
}