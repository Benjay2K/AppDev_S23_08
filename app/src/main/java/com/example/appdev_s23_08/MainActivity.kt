package com.example.appdev_s23_08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    companion object {
        private var isStyle1Applied = true
    }

    private lateinit var styleButton: Button

    private lateinit var motionLayout: MotionLayout
    private lateinit var textView: TextView
    private lateinit var showButton: Button

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set theme
        if (isStyle1Applied) setTheme(R.style.AppTheme1)
        else setTheme(R.style.AppTheme2)

        setContentView(R.layout.activity_main)

        styleButton = findViewById(R.id.styleButton)
        motionLayout = findViewById(R.id.activity_main)
        textView = findViewById(R.id.textView)
        showButton = findViewById(R.id.showButton)

//        Set style
        if (isStyle1Applied) textView.setTextAppearance(R.style.AppStyle1)
        else textView.setTextAppearance(R.style.AppStyle2)

        // Set button click listener that should change style of "Hello there" textView
        styleButton.setOnClickListener {
            // Toggle between styles
            isStyle1Applied = !isStyle1Applied
            this.recreate()
        }

        showButton.setOnClickListener {
            motionLayout.transitionToEnd()
            showButton.text = if (textView.isVisible) "Hide"
            else "Show"
            textView.isVisible = !textView.isVisible
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
}