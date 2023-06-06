package com.example.appdev_s23_08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var styleButton: Button
    private var isStyle1Applied = true

    private lateinit var motionLayout: MotionLayout
    private lateinit var textView: TextView
    private lateinit var showButton: Button

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        styleButton = findViewById(R.id.styleButton)

        // Set initial style
        setStyle1()

        // Set initial theme
        setTheme(R.style.AppTheme1)

        // Set button click listener that should change style of "Hello there" textView
        styleButton.setOnClickListener {
            // Toggle between styles
            if (isStyle1Applied) {
                setStyle2()
                isStyle1Applied = false
            } else {
                setStyle1()
                isStyle1Applied = true
            }
        }*/

        // motion of showButton
        motionLayout = findViewById(R.id.activity_main)
        textView = findViewById(R.id.textView)
        showButton = findViewById(R.id.showButton)

        showButton.setOnClickListener {
            motionLayout.transitionToEnd()
            if (motionLayout.progress == 1.0f) {
                showButton.text = "Show"
            } else {
                showButton.text = "Hide"
            }
        }

        //date picker
        datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Handle the selected date
                // ...
            },
            // Set initial date or use current date
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )

        timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                // Handle the selected time
                // ...
            },
            // Set initial time or use current time
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
            Calendar.getInstance().get(Calendar.MINUTE),
            false
        )

        val datePickerButton: Button = findViewById(R.id.datePickerButton)
        val timePickerButton: Button = findViewById(R.id.timePickerButton)

        datePickerButton.setOnClickListener {
            datePickerDialog.show()
        }

        timePickerButton.setOnClickListener {
            timePickerDialog.show()
        }
    }

    // functions for changing styles
    private fun setStyle1() {
        textView.setTextAppearance(this, R.style.AppStyle1)
    }

    private fun setStyle2() {
        textView.setTextAppearance(this, R.style.AppStyle2)
    }
}