package population

import model.DistanceInstance1
import model.PathX
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PopulationTest {

    @Test
    fun nameTest() {
        val populationChild = PopulationChild()
        val populationParent = PopulationParent()
        assert(populationChild.name == PopulationName.Children)
        assert(populationParent.name == PopulationName.Parents)
    }

    @Test
    fun bestValueTest() {
        val pathX0 = PathX(listOf(1, 2))
        val pathX1 = PathX(listOf(1, 2))
        val pathX2 = PathX(listOf(1, 2))
        pathX0.setValue(8)
        pathX1.setValue(3)
        pathX2.setValue(6)
        val population = PopulationParent()
        population.add(pathX0)
        population.add(pathX1)
        population.add(pathX2)
        assert(population.bestValue.value == pathX1.value)
    }


    @BeforeAll
    fun init() {
            PathX.setDistanceValues(DistanceInstance1)
    }
}
