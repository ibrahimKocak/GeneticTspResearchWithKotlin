package mutation

import kotlin.random.Random

abstract class RandomTwoPoint {

    lateinit var points: IntArray

    open fun initPoints(length: Int) {
        points = IntArray(2)
        points[0] = Random.nextInt(length)
        do {
            points[1] = Random.nextInt(length)
        } while (points[0] == points[1]) //yerdeğiştirilecek 2 şehir birbirinden farklı olsun
    }
}