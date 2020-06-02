package populationFactory.childPopulationFactory

import model.PathX
import kotlin.random.Random

class ChildCreationTemplate {

    lateinit var randomTemplate: MutableList<Boolean>
        private set

    fun buildRandomTemplate() {
        randomTemplate = mutableListOf()
        for (i in PathX.distance.indices) randomTemplate.add(Random.nextBoolean())
    }
}