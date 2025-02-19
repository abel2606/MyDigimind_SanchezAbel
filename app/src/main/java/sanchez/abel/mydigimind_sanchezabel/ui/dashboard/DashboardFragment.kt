package sanchez.abel.mydigimind_sanchezabel.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sanchez.abel.mydigimind_sanchezabel.R
import sanchez.abel.mydigimind_sanchezabel.databinding.FragmentDashboardBinding
import sanchez.abel.mydigimind_sanchezabel.ui.Recordatorio
import sanchez.abel.mydigimind_sanchezabel.ui.RecordatorioViewModel

class DashboardFragment : Fragment() {

    private val recordatorioViewModel: RecordatorioViewModel by activityViewModels()

    private lateinit var diasSeleccionados: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val checkBoxMonday = root.findViewById<CheckBox>(R.id.chkmon)
        val checkBoxTuesday = root.findViewById<CheckBox>(R.id.chktue)
        val checkBoxWednesday = root.findViewById<CheckBox>(R.id.chkwed)
        val checkBoxThursday = root.findViewById<CheckBox>(R.id.chkthu)
        val checkBoxFriday = root.findViewById<CheckBox>(R.id.chkfri)
        val checkBoxSaturday = root.findViewById<CheckBox>(R.id.chksatu)
        val checkBoxSunday = root.findViewById<CheckBox>(R.id.chksun)

        val btnRecordatorio = root.findViewById<Button>(R.id.btnRecordatorio)
        val editTextTask = root.findViewById<EditText>(R.id.editTexto)

        btnRecordatorio.setOnClickListener {
            diasSeleccionados = ""

            if (checkBoxMonday.isChecked) diasSeleccionados += "Lunes "
            if (checkBoxTuesday.isChecked) diasSeleccionados += "Martes "
            if (checkBoxWednesday.isChecked) diasSeleccionados += "Miércoles "
            if (checkBoxThursday.isChecked) diasSeleccionados += "Jueves "
            if (checkBoxFriday.isChecked) diasSeleccionados += "Viernes "
            if (checkBoxSaturday.isChecked) diasSeleccionados += "Sábado "
            if (checkBoxSunday.isChecked) diasSeleccionados += "Domingo "

            val tarea = editTextTask.text.toString()

            if (diasSeleccionados.isNotEmpty() && tarea.isNotEmpty()) {
                val recordatorio = Recordatorio(diasSeleccionados.trim(), "12:00", tarea)
                // Actualizamos el ViewModel
                recordatorioViewModel.recordatorio.value = recordatorio
            } else {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}