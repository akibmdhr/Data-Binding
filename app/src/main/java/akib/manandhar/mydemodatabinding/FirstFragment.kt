package akib.manandhar.mydemodatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import akib.manandhar.mydemodatabinding.databinding.FragmentFirstBinding
import androidx.databinding.DataBindingUtil

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment()
{

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding as FragmentFirstBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.textviewFirst.text = getString(R.string.app_name)
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}