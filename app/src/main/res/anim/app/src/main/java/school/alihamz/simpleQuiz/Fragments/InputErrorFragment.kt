package school.alihamz.simpleQuiz.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import simpleQuiz.databinding.FragmentInputErrorBinding


class InputErrorFragment : Fragment() {

    private var _binding: FragmentInputErrorBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputErrorBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}