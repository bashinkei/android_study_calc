package com.example.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.calculate)

        button.setOnClickListener {
            var isValid = true

            // 定価の入力確認
            val priceEditText = findViewById<EditText>(R.id.price)
            val priceText = priceEditText.text.toString()

            if(priceText.isEmpty()) {
                priceEditText.error=getString(R.string.price_error)
                isValid = false
            }

            //割引率の入力確認
            val discountEditText = findViewById<EditText>(R.id.discount)
            val discountText = discountEditText.text.toString()

            if(discountText.isEmpty()){
                discountEditText.error=getString(R.string.discount_error)
                isValid = false
            }


            if(isValid){
                val price = Integer.parseInt(priceText)
                val discount= Integer.parseInt(discountText)

                //この後遷移
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(ResultActivity.intentPrice, price)
                    putExtra(ResultActivity.intentDiscount, discount)
                }
                startActivity(intent)
            }
        }
    }
}
