package sanchez.abel.mydigimind_sanchezabel.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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
        var task = ArrayList<Task>()
        var contexto = Context?

    }

}