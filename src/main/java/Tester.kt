import mutation.IMutation
import population.Population
import populationFactory.childPopulationFactory.ChildPopulationFactory
import populationFactory.parentPopulationFactory.ParentPopulationFactory
import selection.ISelection
import java.io.Serializable
import kotlin.random.Random

class Tester(private val parentCount: Int, private val childCount: Int, private val crossingOverFactor: Int, private val mutationFactor: Int, private val iterationCount: Int) : Runnable, Serializable {
    private val parentFactories: MutableList<ParentPopulationFactory>
    private val childFactories: MutableList<ChildPopulationFactory>
    private val mutations: MutableList<IMutation>
    private val selections: MutableList<ISelection>
    private var codeParentFactories = ""
    private var codeChildFactories = ""
    private var codeMutations = ""
    private var codeSelections = ""
    private lateinit var parents: Population
    private lateinit var children: Population
    private var t: Thread? = null

    fun start() {
        try {
            if (parentFactories.size < 1) throw Exception("Parent Factories is empty, add one.", NoSuchElementException())
            if (childFactories.size < 1) throw Exception("Child Factories is empty, add one.", NoSuchElementException())
            if (selections.size < 1) throw Exception("Selection is empty, add one.", NoSuchElementException())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (t == null) {
            t = Thread(this)
            t!!.start()
        }
    }

    override fun run() {
        val startTime = System.currentTimeMillis().toDouble()
        createParents()
        for (i in 0 until iterationCount) {
            for (j in 0 until crossingOverFactor) {
                createChildren()
                parentSelection()
            }
            if (mutations.size > 0) for (j in 0 until mutationFactor) {
                mutation()
                parentSelection()
            }
        }
        println("$codeParentFactories$codeChildFactories$codeMutations$codeSelections->")
        parents.printBestValue()
        println("""
    Time : ${(System.currentTimeMillis() - startTime) / 1000}
    
    """.trimIndent())
    }

    private fun createParents() {
        val factoryParent: ParentPopulationFactory = parentFactories[Random.nextInt(parentFactories.size)]
        factoryParent.createPopulation(parentCount)
        parents = factoryParent.population
    }

    private fun createChildren() {
        val factoryChild: ChildPopulationFactory = childFactories[Random.nextInt(childFactories.size)]
        factoryChild.createPopulation(parents, childCount)
        children = factoryChild.population
    }

    private fun mutation() {
        children.forEach { pathX ->
            mutations[Random.nextInt(mutations.size)].infect(pathX.key)
            pathX.commit()
        }
    }

    private fun parentSelection() {
        selections[Random.nextInt(parentFactories.size)].naturalSelection(parents, children)
    }

    fun add(parentFactory: ParentPopulationFactory) {
        parentFactories.add(parentFactory)
        codeParentFactories += parentFactory.code
    }

    fun add(childFactory: ChildPopulationFactory) {
        childFactories.add(childFactory)
        codeChildFactories += childFactory.code
    }

    fun add(mutation: IMutation) {
        mutations.add(mutation)
        codeMutations += mutation.code
    }

    fun add(selection: ISelection) {
        selections.add(selection)
        codeSelections += selection.code
    }

    init {
        parentFactories = ArrayList<ParentPopulationFactory>()
        childFactories = ArrayList<ChildPopulationFactory>()
        mutations = ArrayList<IMutation>()
        selections = ArrayList<ISelection>()
    }
}