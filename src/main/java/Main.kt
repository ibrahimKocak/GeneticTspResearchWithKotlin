import model.DistanceInstance1
import model.PathX
import mutation.MutationInsert
import mutation.MutationSwap
import populationFactory.childPopulationFactory.ChildPopulationFactoryByAdding
import populationFactory.parentPopulationFactory.ParentPopulationFactoryGreedy
import populationFactory.parentPopulationFactory.ParentPopulationFactoryRandom
import selection.SelectionByBetterThanMax
import selection.SelectionByIndexing

/***** Notation ***
 *
 * pR -> Population"P"arent"R"andom
 * pG -> Population"P"arent"G"reedy
 * cA -> Population"C"hildrenBy"A"dding
 * cI -> Population"C"hildrenBy"I"ndexing
 * mI -> "M"utation"I"nsert
 * mR -> "M"utation"R"everse
 * mS -> "M"utation"S"wap
 * sB -> "S"electionBy"B"etterThanMax
 * sI -> "S"electionBy"I"ndexing
 * sS -> "S"electionBy"S"orting
 *
 * explain:
 * mS -> "m" means "m"utation, "S" means mutation type is "s"wap, so mS -> using MutationSwap.class for mutation.
 * order priority p > c > m > s
 *
 */

fun main() {

    PathX.setDistanceValues(DistanceInstance1)

    val tester0 = Tester(20, 20, 1, 1, 200000)
    tester0.add(ParentPopulationFactoryRandom())
    tester0.add(ChildPopulationFactoryByAdding())
    tester0.add(MutationInsert())
    tester0.add(SelectionByBetterThanMax())

    val tester1 = Tester(20, 20, 1, 1, 200000)
    tester1.add(ParentPopulationFactoryRandom())
    tester1.add(ChildPopulationFactoryByAdding())
    tester1.add(MutationInsert())
    tester1.add(SelectionByIndexing())

    val tester2 = Tester(20, 20, 1, 1, 200000)
    tester2.add(ParentPopulationFactoryRandom())
    tester2.add(ChildPopulationFactoryByAdding())
    tester2.add(MutationSwap())
    tester2.add(SelectionByBetterThanMax())

    val tester3 = Tester(20, 20, 1, 1, 200000)
    tester3.add(ParentPopulationFactoryGreedy())
    tester3.add(ChildPopulationFactoryByAdding())
    tester3.add(MutationSwap())
    tester3.add(SelectionByBetterThanMax())

    val testerList = mutableListOf(
            tester0,
            tester1,
            tester2,
            tester3
    )

    testerList.forEach { tester: Tester -> run { tester.start() } }
    println()
}