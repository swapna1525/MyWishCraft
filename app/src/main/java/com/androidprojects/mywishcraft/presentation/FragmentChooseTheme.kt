package com.androidprojects.mywishcraft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidprojects.mywishcraft.R

class FragmentChooseTheme : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_choose_theme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val defaultTheme = view.findViewById<View>(R.id.default_theme)
        val customizedTheme = view.findViewById<View>(R.id.customized_theme)
        val pictureTheme = view.findViewById<View>(R.id.picture_theme)
        val pictureCustomizedTheme = view.findViewById<View>(R.id.picture_customized_theme)
        defaultTheme.setOnClickListener{
            findNavController().navigate(R.id.actionChooseTheme_to_defafultTheme)
        }
        customizedTheme.setOnClickListener{
            findNavController().navigate(R.id.actionChooseTheme_to_defafultTheme)
        }
        pictureTheme.setOnClickListener{
            findNavController().navigate(R.id.actionChooseTheme_to_defafultTheme)
        }
        pictureCustomizedTheme.setOnClickListener{
            findNavController().navigate(R.id.actionChooseTheme_to_defafultTheme)
        }
    }
}