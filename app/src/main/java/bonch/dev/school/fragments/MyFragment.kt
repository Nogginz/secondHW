package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.school.R
import kotlinx.android.synthetic.main.my_fragment.view.*

class MyFragment: Fragment(){
    val bundle = getArguments()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment,
            container, false)
        val textField:TextView = view.findViewById(R.id.textView)
        var indicator = if(bundle!!.getBoolean("INDICATOR")) "Нажата" else "Не нажата"
        textField.setText("Количество тапов: ${bundle?.getInt("TAP", 2)}\n" +
                          "Текст в поле: ${bundle?.get("TEXT")}\n" +
                          "Кнопка индикатор: $indicator")

        return view
    }

}