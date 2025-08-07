package com.androidprojects.mywishcraft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.mywishcraft.R
import com.androidprojects.mywishcraft.adapter.FestivalListAdapter
import com.androidprojects.mywishcraft.model.OccasionsList

class FestivalListFragment : Fragment() {

    private lateinit var adapter: FestivalListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    // Sample list of festivals
    private val festivalList = listOf(
        OccasionsList("Diwali", R.drawable.ic_gift_box),
        OccasionsList("Rakhi", R.drawable.ic_gift_box),
        OccasionsList("Holi", R.drawable.ic_gift_box),
        OccasionsList("Ugadi", R.drawable.ic_gift_box),
        OccasionsList("Dussehra", R.drawable.ic_gift_box),
        OccasionsList("Eid", R.drawable.ic_gift_box),
        OccasionsList("Christmas", R.drawable.ic_gift_box),
        OccasionsList("Ganesh Chaturthi", R.drawable.ic_gift_box),
        OccasionsList("Makar Sankranti", R.drawable.ic_gift_box)
    ).sortedBy { it.occasionName }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.layout_festival_list, container, false)

        // Initialize views
        searchView = view.findViewById(R.id.search_view)
        searchView.isFocusable = true
        searchView.isFocusableInTouchMode = true
        searchView.requestFocus()

        recyclerView = view.findViewById(R.id.rv_festivals)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.isFocusable = false
        recyclerView.isFocusableInTouchMode = false

/*
        searchView.post {
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT)
        }*/


        recyclerView = view.findViewById(R.id.rv_festivals)

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = FestivalListAdapter(festivalList) { festival ->


            val bundle = Bundle().apply {
                putString("festival_name", festival.occasionName)
            }
            findNavController().navigate(R.id.actionFestivalList_to_chooseTheme, bundle)


        }
        recyclerView.adapter = adapter

        // Setup SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = festivalList.filter {
                    it.occasionName.contains(newText.orEmpty(), ignoreCase = true)
                }
                adapter.filterList(filteredList.toString())
                return true
            }
        })

        return view
    }
}
