package com.nicksidiropoulos.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView)
        diceImage = findViewById(R.id.imageView)
        rollButton = findViewById(R.id.button)


        rollButton.setOnClickListener {
            //Dice Roll with the button
            rollDice()
        }


        diceImage.setOnClickListener {
            //Dice Roll with the button
            rollDice()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        //Roll a dice and update text view
        //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

        val dice = Dice(6)
        val result = dice.roll()
        resultTextView.setText(R.string.youGot)
        resultTextView.text = "${resultTextView.text} ${result.toString()}"


        diceImage.contentDescription = resultTextView.text

        when (result){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}