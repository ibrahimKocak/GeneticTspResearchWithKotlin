package mutation

class MutationInsert : RandomTwoPointSorted(), IMutation {
    override fun infect(list: MutableList<Int>) {
        initPoints(list.size)

        list.add(points[0], list[points[1]])
        list.removeAt(points[1]+1)
    }

    override val code: String
        get() = "Mi"
}