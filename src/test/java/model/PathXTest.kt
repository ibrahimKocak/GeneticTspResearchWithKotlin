package model

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PathXTest {

    @Test
    fun setValue() {
        val pathX = PathX(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
        pathX.setValue(10)
        assert(pathX.value == 10)
    }

    @Test
    fun commit() {
        val pathX = PathX(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
        pathX.setValue(Int.MAX_VALUE)
        pathX.commit()
        assert(pathX.value != Int.MAX_VALUE)
        assert(pathX.value != 0)
    }

    @BeforeAll
    internal fun init() {
        PathX.setDistanceValues(DistanceInstance1)
    }
}