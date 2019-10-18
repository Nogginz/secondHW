package bonch.dev.school

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import bonch.dev.school.controllers.CounterBtn
import bonch.dev.school.fragments.MyFragment


class FragmentActivity : FragmentActivity() {
    val bundle = Bundle()

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText

    private var counter = CounterBtn()
    private val myFragment = MyFragment()
    private val manager: FragmentManager = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        var bundle = Bundle()




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

            bundle.putInt("TAP", counter.currentCount)
            bundle.putBoolean("INDICATOR", indicatorButton.isEnabled)
            bundle.putString("TEXT", textField.text.toString())
            myFragment.arguments = bundle
            val trancation = manager.beginTransaction().replace(R.id.fragment, myFragment).commit()
        })


    }

}