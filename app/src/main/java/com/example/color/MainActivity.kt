package com.example.color

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var playerColorNumber = 0
    private val targetColorNumber = (Math.random() * 5).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 色の初期設定
        setPlayerColor(playerColorNumber)
        setTargetColor()

        checkColor()
    }

    override fun onStart() {
        super.onStart()
        tapPlayerView()


    }

    private fun colorNumber(number: Int): Int {

        var color: Int = Color.GREEN

        when (number) {
            0 -> color = Color.GREEN
            1 -> color = Color.BLACK
            2 -> color = Color.BLUE
            3 -> color = Color.RED
            4 -> color = Color.YELLOW
        }

        return color
    }

    private fun setPlayerColor(playerColorNumber: Int) {
        val playerColor = colorNumber(playerColorNumber)
        player.setBackgroundColor(playerColor)
    }

    private fun tapPlayerView() {
        player.setOnClickListener {

            when (playerColorNumber) {
                0 -> playerColorNumber = 1
                1 -> playerColorNumber = 2
                2 -> playerColorNumber = 3
                3 -> playerColorNumber = 4
                4 -> playerColorNumber = 0
            }

            setPlayerColor(playerColorNumber)
        }
    }

    private fun setTargetColor() {
        val targetColor = colorNumber(targetColorNumber)

        target.setBackgroundColor(targetColor)
    }

    private fun checkColor() {
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            if (playerColorNumber == targetColorNumber) {
                builder.setTitle("Result")
                builder.setMessage("success!!")
                builder.show()

            } else {
                builder.setTitle("Result")
                builder.setMessage("false...")
                builder.show()
            }
        }
    }
}
