package org.hyperskill.calculator.tip

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider


class MainActivity() : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var slider: Slider
    lateinit var editText: EditText


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view)
        slider = findViewById(R.id.slider)
        editText = findViewById(R.id.edit_text)
        textView.text = ""
        editText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                printText()
            }
        })

        slider.addOnChangeListener { slider, value, fromUser ->
            printText()
        }
}

    private fun printText() {
        if (editText.text.isEmpty())  {
            textView.text = ""
        } else textView.text = "Tip amount: ${"%.2f".format(editText.text.toString().toDouble() * slider.value.toDouble() / 100.0)}"
    }

}

