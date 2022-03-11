package school.alihamz.simpleQuiz.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_right_answer.*
import school.alihamz.simpleQuiz.R


class RightAnswerFragment : Fragment(R.layout.fragment_right_answer) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        newproblembtn.setOnClickListener {
            val action =
                RightAnswerFragmentDirections.actionRightanswerFragmentToNewproblemFragment()
            findNavController().navigate(action)
        }


    }
}