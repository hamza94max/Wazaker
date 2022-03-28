package school.alihamz.simpleQuiz.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_problem.*
import simpleQuiz.Fragments.NewProblemFragmentDirections
import simpleQuiz.R
import kotlin.random.Random


class NewProblemFragment : Fragment(R.layout.fragment_new_problem) {

    private var firstnum: Int = Random.nextInt(1, 9)
    private var secondnum: Int = Random.nextInt(1, 9)

    private val result: Int = firstnum * secondnum

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit_answer.setOnClickListener {

            when {
                resultIsEmpty() -> {
                    Toast.makeText(context, " Please enter result", Toast.LENGTH_LONG).show()
                }
                resulteditText.text.toString().equals(result.toString()) -> {
                    val action =
                        NewProblemFragmentDirections.actionNewProblemFragmentToRightFragment()
                    findNavController().navigate(action)
                }
                else -> {
                    val action =
                        NewProblemFragmentDirections.actionHomeFragmentToWrongAnswerFragment(result)
                    findNavController().navigate(action)
                }
            }
            Log.i("tag", "done !")
        }

        problemtext.setText("$firstnum x $secondnum =  ")

    }


    fun resultIsEmpty(): Boolean {
        return resulteditText.text.toString() == ""
    }
}