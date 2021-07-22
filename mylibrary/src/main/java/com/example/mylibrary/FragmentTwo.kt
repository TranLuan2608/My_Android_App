package com.example.mylibrary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvFragmentTwo = view.findViewById<TextView>(R.id.tvFragmentTwo)
//        val strtext = requireArguments().getString("edttext")
//        tvFragmentTwo.text = strtext
        val user = requireArguments().getSerializable("user")
        tvFragmentTwo.text = user.toString()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_two, container, false)
    }


}