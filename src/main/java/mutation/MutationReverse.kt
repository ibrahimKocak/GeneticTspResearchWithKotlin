package mutation

class MutationReverse : RandomTwoPointSorted(), IMutation {
    override fun infect(list: MutableList<Int>) {
        super.initPoints(list.size)
        list.subList(points[0], points[1] + 1).reverse()
    }

    override val code: String
        get() = "Mr"
}