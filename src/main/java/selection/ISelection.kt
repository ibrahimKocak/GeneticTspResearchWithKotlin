package selection

import model.IAppComponent
import population.Population
import java.io.Serializable

interface ISelection : Serializable, IAppComponent {
    fun naturalSelection(parents: Population, children: Population)
}