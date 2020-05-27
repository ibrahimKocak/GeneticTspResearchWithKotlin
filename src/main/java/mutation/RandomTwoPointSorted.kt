package mutation

abstract class RandomTwoPointSorted : RandomTwoPoint() {
    public override fun initPoints(length: Int) {
        super.initPoints(length)
        points.sort()
    }
}