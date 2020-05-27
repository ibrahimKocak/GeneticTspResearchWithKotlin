package population

import model.PathX

interface IPopulation {
    val name: PopulationName
    val bestValue: PathX
    fun printBestValue()
}