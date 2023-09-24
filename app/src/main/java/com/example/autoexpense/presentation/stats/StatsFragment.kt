package com.example.autoexpense.presentation.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.autoexpense.R


class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val statsViewModel = ViewModelProvider(this)[StatsViewModel::class.java]
        val statsText: TextView = view.findViewById(R.id.statsText)
        statsViewModel.statsLiveData.observe(viewLifecycleOwner) {
            statsText.text = it
        }
    }
}