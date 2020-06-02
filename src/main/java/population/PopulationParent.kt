package population

import model.PathX

class PopulationParent(origList: MutableList<PathX>) : Population(origList) {
    init {
        name = PopulationName.Parents
    }
}