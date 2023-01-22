package android.example.com.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val rollButton = findViewById<Button>(R.id.Roll)
    private val viewText = findViewById<TextView>(R.id.textRoll)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice(){
        Toast.makeText(this, "Click Button", Toast.LENGTH_SHORT).show()

        val dice = Dice(6)
        val valueRoll = dice.roll()

        viewText.text = valueRoll.toString()
    }

    class Dice(private val numSides : Int){
        fun roll() : Int{
            return (1..numSides).random()
        }
    }

}