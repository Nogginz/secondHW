package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.FragmentActivity
import bonch.dev.school.R





class FirstFragment:Fragment(){
    private lateinit var nextActivityButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        nextActivityButton = view.findViewById(R.id.next_activity_button)
        nextActivityButton.setOnClickListener(View.OnClickListener(){
            (activity as FragmentActivity).replace()
        })
        return view
    }


}