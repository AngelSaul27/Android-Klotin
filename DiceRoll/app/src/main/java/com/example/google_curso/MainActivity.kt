package com.example.google_curso

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.Nullable

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollbutton)
        diceImage = findViewById<ImageView>(R.id.dice_image)
        diceImage2 = findViewById<ImageView>(R.id.dice_image2)

        rollButton.setOnClickListener{
            diceImage.setImageResource(rollTwoDice())
            diceImage2.setImageResource(rollTwoDice())
        }
    }

    private fun rollTwoDice() : Int{
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

}


