package mutation

import org.junit.jupiter.api.Test

class MutationTest {
    private lateinit var mutation: IMutation
    private lateinit var list: MutableList<Int>

    @Test
    fun insertTest() {

        mutation = MutationInsert()
        list = mutableListOf(0, 1)
        mutation.infect(list)
        assert(list == listOf(1, 0))
    }

    @Test
    fun insertTestExpert() {
        mutation = MutationInsert()
        for (i in 0..99) {
            list = mutableListOf(0, 1, 2)
            mutation.infect(list)
            assert(list == listOf(1, 0, 2) || list == listOf(2, 0, 1) || list == listOf(0, 2, 1))
        }
    }

    @Test
    fun reverseTest() {
        mutation = MutationReverse()
        list = mutableListOf(0, 1)
        mutation.infect(list)
        assert(list == listOf(1, 0))
    }

    @Test
    fun reverseTestExpert() {
        mutation = MutationReverse()
        for (i in 0..99) {
            list = mutableListOf(0, 1, 2)
            mutation.infect(list)
            assert(list == listOf(1, 0, 2) || list == listOf(0, 2, 1) || list == listOf(2, 1, 0))
        }
    }

    @Test
    fun swapTest() {
        mutation = MutationSwap()
        list = mutableListOf(0, 1)
        mutation.infect(list)
        assert(list == listOf(1, 0))
    }

    @Test
    fun swapTestExpert() {
        mutation = MutationSwap()
        for (i in 0..99) {
            list = mutableListOf(0, 1, 2)
            mutation.infect(list)
            assert(list == listOf(1, 0, 2) || list == listOf(0, 2, 1) || list == listOf(2, 1, 0))
        }
    }
}