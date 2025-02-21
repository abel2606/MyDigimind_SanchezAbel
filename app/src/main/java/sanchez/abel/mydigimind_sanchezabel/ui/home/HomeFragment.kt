package sanchez.abel.mydigimind_sanchezabel.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sanchez.abel.mydigimind_sanchezabel.R
import sanchez.abel.mydigimind_sanchezabel.databinding.FragmentHomeBinding
import sanchez.abel.mydigimind_sanchezabel.ui.RecordatorioViewModel
import sanchez.abel.mydigimind_sanchezabel.ui.Task
import sanchez.abel.mydigimind_sanchezabel.ui.dashboard.DashboardViewModel

class HomeFragment : Fragment() {

    var tasks = ArrayList<Task>()
    private var adaptador: AdaptadorTareas? = null
    private lateinit var  homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel=
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        fillTasks()

        adaptador = AdaptadorTareas(root.context, tasks)

        val gridView: GridView = root.findViewById(R.id.gridView)

        gridView.adapter = adaptador
        return root
    }

    fun fillTasks(){
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
        tasks.add(Task("Practice 1", arrayListOf("Monday", "Sunday"),"17:30"))
    }

    private class AdaptadorTareas: BaseAdapter{
        var tasks = ArrayList<Task>()
        var contexto: Context? = null

        constructor(contexto: Context, tasks: ArrayList<Task>){
            this.contexto = contexto
            this.tasks = tasks
        }

        override fun getCount(): Int {
            return tasks.size
        }

        override fun getItem(position: Int): Any {
            return tasks[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var task = tasks[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.task_view, null)

            var tv_title: TextView = vista.findViewById(R.id.tv_title)
            var tv_time: TextView = vista.findViewById(R.id.tv_time)
            var tv_day: TextView = vista.findViewById(R.id.tv_days)

            tv_title.setText(task.title)
            tv_time.setText(task.time)
            tv_day.setText(task.days.toString())

            return vista

        }


    }

}