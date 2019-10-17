package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import bonch.dev.school.controllers.CounterBtn


class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText

    private var counter = CounterBtn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)





        counterButton = findViewById(R.id.counterButton)
        val tapAmount = savedInstanceState?.get("TAP_AMOUNT") ?: 0
        counterButton.setText("$tapAmount")
        counter = CounterBtn(tapAmount.toString().toInt())
        counterButton.setOnClickListener(View.OnClickListener{
            counter.increment()
            counterButton.setText("${counter.currentCount}")
        })

        val enableInd = savedInstanceState?.get("INDICATOR")?: true
        indicatorButton=findViewById(R.id.indicator_button)
        indicatorButton.setEnabled(enableInd.toString().toBoolean())
        indicatorButton.setOnClickListener(View.OnClickListener {
            indicatorButton.setEnabled(false)
        })

        textField = findViewById(R.id.text_field)

        nextActivityButton = findViewById(R.id.next_activity_button)
        nextActivityButton.setOnClickListener(View.OnClickListener {
            val intent =Intent(this@FirstActivity, SecondActivity::class.java)
            intent.putExtra("tapBtn", counter.currentCount)
            intent.putExtra("indicatorBtn", indicatorButton.isEnabled)
            intent.putExtra("textField", textField.text.toString())
            startActivity(intent)
        })


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNT",counter.currentCount)
        outState.putBoolean("INDICATOR",indicatorButton.isEnabled)
    }
}