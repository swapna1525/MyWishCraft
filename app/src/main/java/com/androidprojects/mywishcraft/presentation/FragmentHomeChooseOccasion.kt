package com.androidprojects.mywishcraft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.mywishcraft.R
import com.androidprojects.mywishcraft.adapter.OccasionsListAdapter
import com.androidprojects.mywishcraft.model.OccasionsList

class FragmentHomeChooseOccasion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_home_choose_occasion, container, false)
        setUpViews(view)
        return view
    }

    private fun setUpViews(view: View) {
        val occasion = listOf(
            OccasionsList("Birthday", R.drawable.ic_gift_box),
            OccasionsList("Anniversary", R.drawable.ic_gift_box),
            OccasionsList("Festivals", R.drawable.ic_gift_box)
        )

        val recyclerViewList = view.findViewById<RecyclerView>(R.id.rv_occasions)
        recyclerViewList.layoutManager = LinearLayoutManager(requireContext())

        val adapter = OccasionsListAdapter(
            occasion,
            onItemClick = { selectedOccasion ->
                val navController = findNavController()

                when (selectedOccasion.occasionName) {
                    "Birthday" -> navController.navigate(R.id.action_main_to_birthday)
                    "Anniversary" -> navController.navigate(R.id.action_main_to_anniversary)
                    else -> navController.navigate(R.id.action_main_to_festivalsList)
                }
            }
        )
        recyclerViewList.adapter = adapter
    }
}
