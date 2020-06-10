package selection

import model.PathX
import population.Population

class SelectionBySorting : ISelection {

    override fun naturalSelection(parents: Population, children: Population) {

        val parentSize = parents.size
        parents.sortBy { pathX -> pathX.value }

        for (pathXC in children) {
            if (pathXC.value < parents[parentSize - 1].value && !parents.map { PathX -> PathX.key }.contains(pathXC.key))
                parents.add(PathX(pathXC))
        }
        parents.sortBy { pathX -> pathX.value }
        parents.removeAll(parents.subList(parentSize, parents.size))
    }

    override val code: String
        get() = "Ss"
}