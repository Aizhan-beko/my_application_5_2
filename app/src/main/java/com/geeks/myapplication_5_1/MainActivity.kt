package com.geeks.myapplication_5_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.geeks.myapplication_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        with(binding) {
            btnInc.setOnClickListener {
                presenter.onIncrementButtonClicked()

            }
            btnDec.setOnClickListener {
                presenter.onDecrementButtonClicked()

            }
        }
    }

    override fun updateCount(count: Int) {
        binding.counterResult.text = count.toString()
    }

    override fun showCongratulationsMessage() {
        Toast.makeText(this, "Congratulations!!!", Toast.LENGTH_LONG).show()
    }

    override fun changeTextColor() {
        val greenColor = ContextCompat.getColor(this, R.color.green)
        binding.counterResult.setTextColor(greenColor)
    }

    override fun resetTextColor() {
        val defaultColor = ContextCompat.getColor(this, android.R.color.white)
        binding.counterResult.setTextColor(defaultColor)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}

