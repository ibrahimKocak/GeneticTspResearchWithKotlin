package selection

import model.PathX
import population.Population

class SelectionByIndexing : ISelection {

    override fun naturalSelection(parents: Population, children: Population) {

        val count: Int = children.size

        for (i in 0 until count) {

            if (children[i].value < parents[i % parents.size].value && !parents.map { PathX -> PathX.key }.contains(children[i].key))
                parents[i] = PathX(children[i])
        }
    }

    override val code: String
        get() = "Si"
}