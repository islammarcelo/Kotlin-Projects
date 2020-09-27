package com.example.marcelocolculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view:View){
        if (isNewOp){
            etShowNumber.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue:String = etShowNumber.text.toString()
        when(buSelect.id){
            btn0.id->{
                buClickValue+="0"
            }
            btn1.id->{
                buClickValue+="1"
            }
            btn2.id->{
                buClickValue+="2"
            }
            btn3.id->{
                buClickValue+="3"
            }
            btn4.id->{
                buClickValue+="4"
            }
            btn5.id->{
                buClickValue+="5"
            }
            btn6.id->{
                buClickValue+="6"
            }
            btn7.id->{
                buClickValue+="7"
            }
            btn8.id->{
                buClickValue+="8"
            }
            btn9.id->{
                buClickValue+="9"
            }
            btnDott.id->{
                buClickValue+="."
            }
            btnPulsMinus.id->{
                buClickValue = "-"+buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }
 var op="*"
 var oldNumber =""
 var isNewOp = true

    fun opEvent(view: View){
        val buSelect = view as Button
        when(buSelect.id){
            btnDiv.id->{
                op = "/"
            }
            btnMul.id->{
                op = "*"
            }
            btnMins.id->{
                op = "-"
            }
            btnAdd.id->{
                op = "+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true

    }
    fun equalEvent(view: View){
        val newNumber = etShowNumber.text.toString()
        var finalNumber:Double? = null
        when(op){
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun percentEvent(view: View){

        val number:Double = etShowNumber.text.toString().toDouble()
        etShowNumber.setText(number.toString())
    }

    fun cleanEvent(view: View){
        etShowNumber.setText("0")
        isNewOp = true
    }
}
