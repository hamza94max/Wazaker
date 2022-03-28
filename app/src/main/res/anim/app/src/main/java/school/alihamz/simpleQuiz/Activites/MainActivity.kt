package school.alihamz.simpleQuiz.Activites

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import simpleQuiz.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            Log.i("tag", "delay 1 s")
            delay(1000)
            Log.i("Tag", "Hey pitch !")
        }


    }


}

