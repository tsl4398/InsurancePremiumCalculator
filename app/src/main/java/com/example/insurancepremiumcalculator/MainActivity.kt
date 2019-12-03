package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculatePayment(it)
        }
    }

    private fun calculatePayment(viewThatIsClicked: View)
    {
        // Get Age

        val spinnerAge = findViewById<Spinner>(R.id.spinnerAge)

        val age = spinnerAge.selectedItemPosition + 1

        // Get Gender

        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)

        val genderGroup = radioGroupGender.checkedRadioButtonId

        val radioGender = findViewById<RadioButton>(genderGroup)

        val gender = radioGender.text

        // Get Smoker

        val checkBoxSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)

        val isSmoker = checkBoxSmoker.isChecked

        // Calculate Premium

        var premium = 0

        if (age == 1)
        {
            premium += 60
        }
        else if (age == 2)
        {
            premium += 70

            if (gender == "Male")
            {
                premium += 50
            }

            if (isSmoker)
            {
                premium += 100
            }
        }
        else if (age == 3)
        {
            premium += 90

            if (gender == "Male")
            {
                premium += 100
            }

            if (isSmoker)
            {
                premium += 150
            }
        }
        else if (age == 4)
        {
            premium += 120

            if (gender == "Male")
            {
                premium += 150
            }

            if (isSmoker)
            {
                premium += 200
            }
        }
        else if (age == 5)
        {
            premium += 150

            if (gender == "Male")
            {
                premium += 200
            }

            if (isSmoker)
            {
                premium += 250
            }
        }
        else if (age == 6)
        {
            premium += 150

            if (gender == "Male")
            {
                premium += 200
            }

            if (isSmoker)
            {
                premium += 300
            }
        }

        // Set Payment

        val textViewPayment = findViewById<TextView>(R.id.textViewPayment)

        textViewPayment.setText("RM " + premium)
    }
}
