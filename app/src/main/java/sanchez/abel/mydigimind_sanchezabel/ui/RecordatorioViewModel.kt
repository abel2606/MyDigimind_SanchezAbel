package sanchez.abel.mydigimind_sanchezabel.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecordatorioViewModel : ViewModel() {
    val recordatorio = MutableLiveData<Recordatorio>()
}