package com.example.tictac

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buSelect(view: View) {
        val btnChoice = view as Button
        var btnId = 0;
        when(btnChoice.id){
            R.id.btn1-> btnId =1
            R.id.btn2-> btnId =2
            R.id.btn3-> btnId =3
            R.id.btn4-> btnId =4
            R.id.btn5-> btnId =5
            R.id.btn6-> btnId =6
            R.id.btn7-> btnId =7
            R.id.btn8-> btnId =8
            R.id.btn9-> btnId =9
        }
        playGame(btnId, btnChoice)
    }

    var player1 =  ArrayList<Int>()
    var player2 =  ArrayList<Int>()
    var activePlayer = 1

    fun playGame(btnId: Int, btnChoice:Button){

        if(activePlayer == 1){
            btnChoice.text = "X"
            btnChoice.setBackgroundResource(R.color.white)
            player1.add(btnId)
            activePlayer = 2
            autoPlay()
        }else{
            btnChoice.text = "O"
            btnChoice.setBackgroundResource(R.color.white)
            player2.add(btnId)
            activePlayer = 1
        }
        btnChoice.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //row1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            player1WinsCounts+= 1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //row2
        else if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            player1WinsCounts+= 1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //row3
        else if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //col1
        else if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //col2
        else if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //col3
        else if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //line1
        else if (player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        //line2
        else if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            player1WinsCounts+=1
            Toast.makeText(applicationContext,"Player One Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }
        else  if (player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            player2WinsCounts+=1
            Toast.makeText(applicationContext,"Player Two Is Winner",Toast.LENGTH_SHORT).show()
            destroyGame()
        }

    }

    fun autoPlay(){

        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9){
            if (!(player1.contains(cellID)|| player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }


        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val CellID = emptyCells[randIndex]
        val buttonSelect:Button?
        when(CellID){

            1->buttonSelect = btn1
            2->buttonSelect = btn2
            3->buttonSelect = btn3
            4->buttonSelect = btn4
            5->buttonSelect = btn5
            6->buttonSelect = btn6
            7->buttonSelect = btn7
            8->buttonSelect = btn8
            9->buttonSelect = btn9
            else->{
                buttonSelect = btn1
            }
        }

        playGame(CellID,buttonSelect)

    }

    var player1WinsCounts = 0
    var player2WinsCounts = 0

    fun destroyGame() {
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (CellID in 1..9){
            var buSelected:Button? = when(CellID){
                1->btn1
                2->btn2
                3->btn3
                4->btn4
                5->btn5
                6->btn6
                7->btn7
                8->btn8
                9->btn9
                else->{
                   btn1
                }
            }
            buSelected!!.text = ""
            buSelected.setBackgroundResource(R.color.button)
            buSelected!!.isEnabled = true

        }
        Toast.makeText(this,"player1: $player1WinsCounts, player2: $player2WinsCounts",Toast.LENGTH_LONG).show()

    }
}
