package su.codesign.kotlincalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var output: TextView
    lateinit var clear: Button
    lateinit var divide: Button
    lateinit var multiply: Button
    lateinit var minus: Button
    lateinit var plus: Button
    lateinit var equals: Button
    lateinit var comma: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button

    var leftOperand: String? = ""
    var rightOperand: String? = ""
    var operator: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output = findViewById(R.id.output)
        clear = findViewById(R.id.clear)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        equals = findViewById(R.id.equals)
        comma = findViewById(R.id.comma)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)

        clear.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiply.setOnClickListener(this)
        minus.setOnClickListener(this)
        plus.setOnClickListener(this)
        equals.setOnClickListener(this)
        comma.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)

    }

    @SuppressLint("ResourceType")
    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.clear -> {
                output.text = "0"
                leftOperand = ""
                rightOperand = ""
                operator = ""
            }
            R.id.divide -> operator = "/"
            R.id.multiply -> operator = "*"
            R.id.minus -> operator = "-"
            R.id.plus -> operator = "+"
            R.id.equals -> {
                val operand1 = leftOperand?.toFloat()
                val operand2 = rightOperand?.toFloat()
                if (operand1 != null && operand2 !== null) {
                    val result = when(operator) {
                        "/" -> operand1 / operand2
                        "*" -> operand1 * operand2
                        "-" -> operand1 - operand2
                        "+" -> operand1 + operand2
                        else -> {}
                    }
                    output.text = result.toString()
                }
            }
            R.id.comma -> {
                if (operator == "") {
                    leftOperand += "."
                    output.text = leftOperand
                } else {
                    rightOperand += "."
                    output.text = rightOperand
                }
            }
            else -> {
                if (operator == "") {
                    leftOperand += (p0 as Button).text
                    output.text = leftOperand
                } else {
                    rightOperand += (p0 as Button).text
                    output.text = rightOperand
                }
            }
        }
    }
}