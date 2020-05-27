package mutation

import model.IAppComponent
import java.io.Serializable

interface IMutation : Serializable, IAppComponent {
    fun infect(list: MutableList<Int>)
}