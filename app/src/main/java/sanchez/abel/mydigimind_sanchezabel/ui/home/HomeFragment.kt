package sanchez.abel.mydigimind_sanchezabel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sanchez.abel.mydigimind_sanchezabel.R
import sanchez.abel.mydigimind_sanchezabel.databinding.FragmentHomeBinding
import sanchez.abel.mydigimind_sanchezabel.ui.RecordatorioViewModel

class HomeFragment : Fragment() {

    private val recordatorioViewModel: RecordatorioViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView = root.findViewById<TextView>(R.id.tx)

        recordatorioViewModel.recordatorio.observe(viewLifecycleOwner, Observer { recordatorio ->
            textView.text = "Recordatorio: ${recordatorio?.nombre}\nDías: ${recordatorio?.dias}"
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}