package populationFactory.childPopulationFactory

import model.DistanceInstance1
import model.PathX
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import population.Population
import population.PopulationChild
import populationFactory.parentPopulationFactory.ParentPopulationFactory
import populationFactory.parentPopulationFactory.ParentPopulationFactoryRandom

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChildPopulationFactoryTest {

    private lateinit var populationParent: Population
    private lateinit var populationChildByAdding: Population
    private lateinit var populationChildByIndexing: Population
    private lateinit var childCreationTemplate: ChildCreationTemplate
    private lateinit var parentPopulationFactory: ParentPopulationFactory
    private lateinit var factoryByAdding: ChildPopulationFactory
    private lateinit var factoryByIndexing: ChildPopulationFactory
    private val parentSize = 100
    private val childSize = 100

    @Test
    fun templateRandomTest() {
        childCreationTemplate = ChildCreationTemplate()
        childCreationTemplate.buildRandomTemplate()
        assert(childCreationTemplate.randomTemplate.size == PathX.distance.size)
    }

    @Test
    fun byAddingChildPopulationFactoryTest() {

        populationChildByAdding = PopulationChild(mutableListOf())
        factoryTestFun(ChildPopulationFactoryByAdding(), populationChildByAdding)
    }

    @Test
    fun byIndexingChildPopulationFactoryTest() {

        populationChildByIndexing = PopulationChild(mutableListOf())
        factoryTestFun(ChildPopulationFactoryByIndexing(), populationChildByIndexing)
    }

    @Test
    fun childPopulationFactoryTest() {

        populationChildByAdding = PopulationChild(mutableListOf())
        populationChildByIndexing = PopulationChild(mutableListOf())

        factoryTestFun(ChildPopulationFactoryByAdding(), populationChildByAdding)
        factoryTestFun(ChildPopulationFactoryByIndexing(), populationChildByIndexing)
    }

    private fun factoryTestFun(factory: ChildPopulationFactory, population: Population) {

        factory.createPopulation(populationParent, childSize)
        population.addAll(factory.population)

        assert(population.size == childSize)

        for (i in 0 until population.size) {

            for (j in 0 until population[0].key.size)
                assert(population[i].key.contains(j))

            assert(population[i].key.size == populationParent[0].key.size)
        }
    }

    @BeforeAll
    fun init() {
        PathX.setDistanceValues(DistanceInstance1)

        parentPopulationFactory = ParentPopulationFactoryRandom()
        parentPopulationFactory.createPopulation(parentSize)
        populationParent = parentPopulationFactory.population
    }
}