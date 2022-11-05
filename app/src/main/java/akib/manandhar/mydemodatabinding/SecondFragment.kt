package akib.manandhar.mydemodatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import akib.manandhar.mydemodatabinding.databinding.FragmentSecondBinding
import android.util.Log
import androidx.databinding.DataBindingUtil
import akib.manandhar.mydemodatabinding.Person

/**
* A simple [Fragment] subclass as the second destination in the navigation.
*/
class SecondFragment : Fragment()
{

    private var _binding: FragmentSecondBinding? = null

    private val person: Person = Person()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second,
            container, false)
//        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        person.firstName = "AKib"
        person.lastName = "Manandhar"
        binding.person = person

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            binding.apply {
                Log.v("DEMODATABINDING", binding.person?.firstName.toString())
                person?.firstName = binding.textviewSecond.text.toString()
                Log.v("DEMOTAGBINDING", person?.firstName.toString())
                Log.v("DEMODATABINDING", binding.person?.firstName.toString())
                binding.invalidateAll()
            }
        }
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}