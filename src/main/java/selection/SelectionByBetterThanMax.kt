package selection

import model.PathX
import population.Population

class SelectionByBetterThanMax : ISelection {
    override fun naturalSelection(parents: Population, children: Population) {

        var worstParent: PathX = parents.worst

        for (pathXC in children) {
            if (pathXC.value < worstParent.value && !parents.map { PathX -> PathX.key }.contains(pathXC.key)) {
                parents.add(PathX(pathXC))
                parents.remove(worstParent)
                worstParent = parents.worst
            }
        }
    }

    override val code: String
        get() = "Sb"
}