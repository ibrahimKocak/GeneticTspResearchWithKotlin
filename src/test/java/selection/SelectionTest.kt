package selection

import model.DistanceInstance1
import model.PathX
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import population.PopulationChild
import population.PopulationParent

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SelectionTest {

    private lateinit var populationParent: PopulationParent
    private lateinit var populationChild: PopulationChild
    private lateinit var selection: ISelection

    private fun setParams() {

        populationParent = PopulationParent(mutableListOf(
                PathX(mutableListOf(0, 1, 2, 3)),
                PathX(mutableListOf(0, 1, 3, 2)),
                PathX(mutableListOf(0, 2, 1, 3)),
                PathX(mutableListOf(0, 2, 3, 1))
        ))

        populationChild = PopulationChild(mutableListOf(
                PathX(mutableListOf(1, 2, 3, 0)),
                PathX(mutableListOf(1, 2, 0, 3)),
                PathX(mutableListOf(1, 3, 0, 2)),
                PathX(populationParent[3].key.toMutableList()) //that included in population_parent
        ))

        populationParent[0].setValue(0)
        populationParent[1].setValue(20)
        populationParent[2].setValue(15)
        populationParent[3].setValue(5)

        populationChild[0].setValue(35)
        populationChild[1].setValue(10)
        populationChild[2].setValue(10)
        populationChild[3].setValue(5) //same value with parent
    }

    @Test
    fun selectionByBetterThanMaxTest() {
        setParams()
        selection = SelectionByBetterThanMax()
        selection.naturalSelection(populationParent, populationChild)
        assert(populationParent[0].value == 0)
        assert(populationParent[1].value == 5)
        assert(populationParent[2].value == 10)
        assert(populationParent[3].value == 10)
    }

    @Test
    fun selectionBySortTest() {
        setParams()
        selection = SelectionBySorting()
        selection.naturalSelection(populationParent, populationChild)
        assert(populationParent[0].value == 0)
        assert(populationParent[1].value == 5)
        assert(populationParent[2].value == 10)
        assert(populationParent[3].value == 10)
    }

    @Test
    fun selectionByIndexTest() {
        setParams()
        selection = SelectionByIndexing()
        selection.naturalSelection(populationParent, populationChild)
        assert(populationParent[0].value == 0)
        assert(populationParent[1].value == 10)
        assert(populationParent[2].value == 10)
        assert(populationParent[3].value == 5)
    }

    @BeforeAll
    fun init() {
        PathX.setDistanceValues(DistanceInstance1)
    }
}