package com.example.quizzapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.CheckBox
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onQ1RBClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.question1_a ->
                    if (checked) {
                        result += 40
                    }
            }
        }
    }

    fun onQ2RBClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.question2_1 -> {
                    if (checked) {
                        result += 20
                    }
                }
                R.id.question2_2 -> {
                    if (checked) {
                        result += 20
                    }
                }

                R.id.question2_3 -> {
                    if (checked) {
                        result += 20
                    }
                }
            }
        }
    }

    fun resetSol(view: View) {
        resetAns()
    }

    fun resetAns(){
        this.findViewById<RadioButton>(R.id.question1_a).setChecked(false);
        this.findViewById<RadioButton>(R.id.question1_b).setChecked(false);

        this.findViewById<CheckBox>(R.id.question2_1).setChecked(false);
        this.findViewById<CheckBox>(R.id.question2_2).setChecked(false);
        this.findViewById<CheckBox>(R.id.question2_3).setChecked(false);
        this.findViewById<CheckBox>(R.id.question2_4).setChecked(false);
    }

    private fun showResultDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    resetAns()
                    result = 0
                    dialog.dismiss()
                }
            }
            builder.setMessage(message)
                .setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitSol(view: View) {
        val current = LocalDateTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)

        val message = if(result > 0)
            "Congratulations! You submitted on current $date and $time, Your achieved $result%"
        else "Please, try again."
        val title = "QuizApp Result"
        showResultDialog(title, message)
    }
}