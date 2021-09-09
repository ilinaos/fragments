package com.example.home_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Fragment1 : Fragment() {

    private var clickListener : Fragment1ClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        // Inflate the layout for this fragment
        val mainText = view.findViewById<TextView>(R.id.mainText)
        var clickListener: Fragment1ClickListener? = null
        arguments?.let {
            mainText.text = it.getInt("openWithId").toString()
        }
        mainText.text=arguments?.getInt("openWithId").toString()
        view.findViewById<Button>(R.id.button).apply {
            setOnClickListener { clickListener?.onClick() }
        }

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is Fragment1ClickListener){
            clickListener = context
        }
    }

    companion object {
        fun newInstance (id: Int) : Fragment1{
            val args = Bundle()
            args.putInt("openWithId", id)
            val fragment = Fragment1()
            fragment.arguments = args
            return fragment
        }
    }
}


