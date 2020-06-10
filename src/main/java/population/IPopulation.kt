package population

import model.PathX

interface IPopulation {
    val name: PopulationName
    val best: PathX
    val worst: PathX
    fun printBestValue()
}