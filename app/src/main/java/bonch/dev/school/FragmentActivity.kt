package bonch.dev.school


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import bonch.dev.school.fragments.FirstFragment
import bonch.dev.school.fragments.SecondFragment

import kotlinx.android.synthetic.main.fragments_activity.*

class FragmentActivity: FragmentActivity(){
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private var manager: FragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragments_activity)
        val trancation = manager.beginTransaction().add(R.id.fragment_activity, firstFragment).commit()
    }

    fun replace(){
        manager.beginTransaction().replace(R.id.fragment_activity,secondFragment).addToBackStack("first_fragment").commit()
    }

}