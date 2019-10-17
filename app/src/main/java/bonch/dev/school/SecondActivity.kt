package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var outText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val indStr = if(intent.getBooleanExtra("indicatorBtn", true)) "не была нажата"  else  "была нажата"
        val outputStr = "Кнопка-индикатор $indStr; \nКнопка для нажатий была нажата ${intent.getIntExtra("tapBtn",0)}  раз;\nТекст в текстовом поле: \"${intent.getStringExtra("textField")}\"."

        outText = findViewById(R.id.textView2)
        outText.setText(outputStr)

    }
}