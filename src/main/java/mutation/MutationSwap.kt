package mutation

class MutationSwap : RandomTwoPoint(), IMutation {
    override fun infect(list: MutableList<Int>) {
        super.initPoints(list.size)
        list[points[0]] = list[points[1]].also { list[points[1]] = list[points[0]] }
    }

    override val code: String
        get() = "Ms"
}