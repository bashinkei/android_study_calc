package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //Intent 取り出し
        val price = intent.getIntExtra(intentPrice,0)
        val discount = intent.getIntExtra(intentDiscount, 0)

        val expression = findViewById<TextView>(R.id.expression_label)
        expression.text = getString(R.string.expression, price,discount)
        val discountPrice = price*(100-discount)/100

        val result = findViewById<TextView>(R.id.result_label)
        result.text = getString(R.string.result,discountPrice)

    }

    internal companion object {
        const val intentPrice = "price"
        const val intentDiscount : String = "discount"
    }
}
