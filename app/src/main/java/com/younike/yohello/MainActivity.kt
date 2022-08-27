package com.younike.yohello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.younike.yohello.R

lateinit var diceImage : ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice()}

        val countUp : Button = findViewById(R.id.count_up)
        countUp.setOnClickListener { countUP() }

        val countDown : Button = findViewById(R.id.count_down)
        countDown.setOnClickListener { countDown() }

    }

    private fun rollDice() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val resultText : TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled !"
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()

        val diceImage: ImageView = findViewById(R.id.dice_image)

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    private fun countUP() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val resultText : TextView = findViewById(R.id.result_text)

        if (resultText.text == "Hello World !") {
            resultText.text = "1"

        } else if (resultText.text.toString().toInt() < 6) {
            var resultInt = resultText.text.toString().toInt()

            resultInt++
            resultText.text = resultInt.toString()

            val diceImage: ImageView = findViewById(R.id.dice_image)

            val drawableResource = when (resultInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)

        }
    }

    private fun countDown() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val resultText : TextView = findViewById(R.id.result_text)


        if (resultText.text == "Hello World !") {
            resultText.text = "6"

        } else if (resultText.text.toString().toInt() > 1) {
            var resultInt = resultText.text.toString().toInt()

            resultInt--
            resultText.text = resultInt.toString()

            val diceImage: ImageView = findViewById(R.id.dice_image)


            val drawableResource = when (resultInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                else -> R.drawable.dice_5
            }

            diceImage.setImageResource(drawableResource)

        }
    }
}