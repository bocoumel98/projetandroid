package com.example.e_shoes

import androidx.fragment.app.Fragment

interface FragmentNavigation {
    fun navigateFrag(fragment:Fragment,addToStack:Boolean)
}