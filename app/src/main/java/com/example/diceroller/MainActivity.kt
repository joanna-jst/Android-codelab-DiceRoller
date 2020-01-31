package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import timber.log.Timber
import java.util.*

const val DICES_STATE = "dices_state"

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView
    var dicesState = intArrayOf(R.drawable.empty_dice, R.drawable.empty_dice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.diceImage)
        diceImage2 = findViewById(R.id.diceImage2)
        if (savedInstanceState != null) {
            dicesState = savedInstanceState.getIntArray(DICES_STATE) ?:
                    intArrayOf(R.drawable.empty_dice, R.drawable.empty_dice)
            setDiceImages()
        }

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDices() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clear() }
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(DICES_STATE, dicesState)
    }

    private fun rollDices() {
        dicesState = intArrayOf(getRandomDiceImage(), getRandomDiceImage())
        setDiceImages()
    }

    private fun setDiceImages() {
        diceImage.setImageResource(dicesState[0])
        diceImage2.setImageResource(dicesState[1])
    }

    private fun getRandomDiceImage() : Int {
        return when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun clear() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        dicesState = intArrayOf(R.drawable.empty_dice, R.drawable.empty_dice)
    }
}
