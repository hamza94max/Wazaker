package school.alihamz.simpleQuiz.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_see_answer.*
import school.alihamz.simpleQuiz.R


class SeeAnswerFragment : Fragment(R.layout.fragment_see_answer) {

    private val args: SeeAnswerFragmentArgs by navArgs()


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seeanswerText.text = "The answer is:"
        result.text = "${args.result}"


        newProblembtnInSeeanswer.setOnClickListener {
            val action = SeeAnswerFragmentDirections.actionSeeAnswerFragmentToNewproblemFragment()
            findNavController().navigate(action)
        }


    }
}