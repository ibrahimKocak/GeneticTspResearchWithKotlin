package population

import model.PathX

class PopulationChild(origList: MutableList<PathX>) : Population(origList) {
    init {
        name = PopulationName.Children
    }
}