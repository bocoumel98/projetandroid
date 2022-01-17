package com.example.e_shoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity(),FragmentNavigation {
    private lateinit var fAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.setFlags(FLAG_FULLSCREEN,FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        fAuth= Firebase.auth
        var currentUser=fAuth.currentUser
//        if (currentUser ==null){
//            supportFragmentManager.beginTransaction()
//                .add(R.id.container,HomeFragment())
//                .commit()
//        }else

            supportFragmentManager.beginTransaction()
                .add(R.id.container,LoginFragment())
                .commit()


    }

    override fun navigateFrag(fragment: Fragment, addToStack: Boolean) {
        val transaction= supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
        if (addToStack){
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}

