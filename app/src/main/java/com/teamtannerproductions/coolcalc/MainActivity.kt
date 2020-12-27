package com.teamtannerproductions.coolcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isAddition: Boolean = false
        var isSubtraction: Boolean = false
        var isMultiplication: Boolean = false
        var isDivision: Boolean = false
        var storeOperand = ""
        var displayText = findViewById<TextView>(R.id.display)
        var displayStoredText = ""
        val clearButtonText = findViewById<Button>(R.id.clearButton)
        val equalText = findViewById<Button>(R.id.equalButton)
        val addition = findViewById<Button>(R.id.addButton)
        val subtraction = findViewById<Button>(R.id.subtractButton)
        val multiplication = findViewById<Button>(R.id.multiplyButton)
        val division = findViewById<Button>(R.id.divideButton)
        val decimalText = findViewById<Button>(R.id.decimalButton)
        val percentSign = findViewById<Button>(R.id.percentButton)
        val delete = findViewById<Button>(R.id.deleteButton)
        val numberOne = findViewById<Button>(R.id.numberOneButton)
        val numberTwo = findViewById<Button>(R.id.numberTwoButton)
        val numberThree = findViewById<Button>(R.id.numberThreeButton)
        val numberFour = findViewById<Button>(R.id.numberFourButton)
        val numberFive = findViewById<Button>(R.id.numberFiveButton)
        val numberSix = findViewById<Button>(R.id.numberSixButton)
        val numberSeven = findViewById<Button>(R.id.numberSevenButton)
        val numberEight = findViewById<Button>(R.id.numberEightButton)
        val numberNine = findViewById<Button>(R.id.numberNineButton)
        var answer = 0.0
        var currentdisplay = ""
        var percentSignAnswer = 0.0
        numberOne.setOnClickListener {
                appendNumbersTogether(numberOne.text.toString())
        }

        numberTwo.setOnClickListener {
            appendNumbersTogether(numberTwo.text.toString())
        }

        numberThree.setOnClickListener {
            appendNumbersTogether(numberThree.text.toString())
        }

        numberFour.setOnClickListener {
            appendNumbersTogether(numberFour.text.toString())
        }

        numberFive.setOnClickListener {
            appendNumbersTogether(numberFive.text.toString())
        }

        numberSix.setOnClickListener {
            appendNumbersTogether(numberSix.text.toString())
        }

        numberSeven.setOnClickListener {
            appendNumbersTogether(numberSeven.text.toString())
        }

        numberEight.setOnClickListener {
            appendNumbersTogether(numberEight.text.toString())
        }

        numberNine.setOnClickListener {
            appendNumbersTogether(numberNine.text.toString())
        }

        clearButtonText.setOnClickListener {
            displayText.text = ""
            displayText.hint = "0"
            isAddition = false
            isSubtraction = false
            isMultiplication = false
            isDivision = false
            //clearButtonText.text = "C"
        }

        addition.setOnClickListener {
            if (!isAddition) {
                isAddition = true
                storeOperand = addition.text.toString()
                displayStoredText = displayText.text.toString()
                displayText.hint = displayText.text
                displayText.text = ""
                Log.v(storeOperand, "+ should be: $storeOperand")
                isSubtraction = false
                isMultiplication = false
                isDivision = false
            }

        }

        subtraction.setOnClickListener {
            if (!isSubtraction) {
                isSubtraction = true
                storeOperand = subtraction.text.toString()
                displayStoredText = displayText.text.toString()
                displayText.hint = displayText.text
                displayText.text = ""
                Log.v(storeOperand, "+ should be: $storeOperand")
                isAddition = false
                isMultiplication = false
                isDivision = false
            }

        }

        multiplication.setOnClickListener {
            if (!isMultiplication) {
                isMultiplication = false
                storeOperand = multiplication.text.toString()
                displayStoredText = displayText.text.toString()
                displayText.hint = displayText.text
                displayText.text = ""
                Log.v(storeOperand, "+ should be: $storeOperand")
                isAddition = false
                isSubtraction = false
                isDivision = false
            }

        }

        division.setOnClickListener {
            if (!isDivision) {
                isDivision = false
                storeOperand = division.text.toString()
                displayStoredText = displayText.text.toString()
                displayText.hint = displayText.text
                displayText.text = ""
                Log.v(storeOperand, "+ should be: $storeOperand")
                isAddition = false
                isSubtraction = false
                isMultiplication = false
            }


        }

        decimalText.setOnClickListener {
            if (displayText.text.toString().contains(".")) {

            } else {
                displayText.text = displayText.text.toString() + "."
            }
        }

        percentSign.setOnClickListener {
            currentdisplay = displayText.text.toString()
            percentSignAnswer = currentdisplay.toDouble() * 0.01
            displayText.text = String.format("%.2f", percentSignAnswer)
            //displayText.hint = displayText.text
            //displayText.hint = ""
            
        }

        delete.setOnClickListener {
            if (displayText.text.toString() != "0"){
                var s = displayText.text.toString()
                displayText.text = s.substring(0, s.length - 1)
            }
            else {
                //displayText.text = "0"
            }

        }

        equalText.setOnClickListener {
            val firstNumber = displayStoredText
            val secondNumber = displayText.text.toString()
            Log.v(firstNumber, "stored text be: $firstNumber")
            Log.v(secondNumber, "display text is: $secondNumber")
           // answer = firstNumber.toDouble() + secondNumber.toDouble()

            if (storeOperand == "+") {
                answer = firstNumber.toDouble() + secondNumber.toDouble()
                Log.v(answer.toString(), "answer should be: $answer")
                displayText.text = String.format("%.2f", answer)
            } else if (storeOperand == "-") {
                answer = firstNumber.toDouble() - secondNumber.toDouble()
                Log.v(answer.toString(), "answer should be: $answer")
                displayText.text = String.format("%.2f", answer)
            }else if (storeOperand == "*") {
                answer = firstNumber.toDouble() * secondNumber.toDouble()
                Log.v(answer.toString(), "answer should be: $answer")
                displayText.text = String.format("%.2f", answer)
            } else if (storeOperand == "/") {
                answer = firstNumber.toDouble() / secondNumber.toDouble()
                Log.v(answer.toString(), "answer should be: $answer")
                displayText.text = String.format("%.2f", answer)
            }
            //answer = firstNumber +  //"$storeOperand" + storeOperand.toDouble()
        }
    }
    private fun appendNumbersTogether(aNumber: String): String {
        var displayText1 = findViewById<TextView>(R.id.display)
        displayText1.text = "${displayText1.text}$aNumber"
        return displayText1.toString()
    }

//    private fun numberOrOperand(digitOrOperand: String, displayText: View) {
//        if (digitOrOperand == "1" || digitOrOperand == "2" ||
//                digitOrOperand == "3") {
//
//        } else if (digitOrOperand == "+" || digitOrOperand == "-" ||
//                digitOrOperand == "*" || digitOrOperand == "/") {
//            storeOperand = digitOrOperand
//            displayStoredText = displayText.text.toString()
//            displayText.hint = displayText.text
//            displayText.text = ""
//            Log.v(storeOperand, "+ should be: $storeOperand")
//        } else {
//
//        }
//    }

}