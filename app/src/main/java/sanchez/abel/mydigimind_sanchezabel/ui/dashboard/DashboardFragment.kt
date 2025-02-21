package sanchez.abel.mydigimind_sanchezabel.ui.dashboard

import android.app.TimePickerDialog
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
import sanchez.abel.mydigimind_sanchezabel.ui.Task
import sanchez.abel.mydigimind_sanchezabel.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.Calendar

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    private lateinit var diasSeleccionados: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel=
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val btn_time: Button = root.findViewById(R.id.btn_time)

        btn_time.setOnClickListener {
            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                btn_time.text = SimpleDateFormat("HH:mm").format(cal.time)

            }
            TimePickerDialog(root.context, timeSetListener,cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true).show()
        }

        val btn_save: Button = root.findViewById(R.id.btn_save)
        val et_titulo: EditText = root.findViewById(R.id.et_titulo)
        val checkMonday: CheckBox = root.findViewById(R.id.chkmon)
        val checkTuesday: CheckBox = root.findViewById(R.id.chktue)
        val checkWednesday: CheckBox = root.findViewById(R.id.chkwed)
        val checkThursday: CheckBox = root.findViewById(R.id.chkthu)
        val checkFriday: CheckBox = root.findViewById(R.id.chkfri)
        val checkSaturday: CheckBox = root.findViewById(R.id.chksatu)
        val checkSunday: CheckBox = root.findViewById(R.id.chksun)

        btn_save.setOnClickListener {
            var title = et_titulo.text.toString()
            var time = btn_time.text.toString()
            var days = ArrayList<String>()

            if(checkMonday.isChecked)
                days.add("Monday")
            if(checkTuesday.isChecked)
                days.add("Tuesday")
            if(checkWednesday.isChecked)
                days.add("Wednesday")
            if(checkThursday.isChecked)
                days.add("Thursday")
            if(checkFriday.isChecked)
                days.add("Friday")
            if(checkSaturday.isChecked)
                days.add("Saturday")
            if(checkSunday.isChecked)
                days.add("Sunday")

            var task = Task(title, days, time)

            HomeFragment.tasks.add(task)

            Toast.makeText(root.context, "new task added", Toast.LENGTH_SHORT).show()

        }
        return root
    }


}