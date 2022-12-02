package com.francotte.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.francotte.newsapp.R
import com.francotte.newsapp.adaptor.NewsAdaptor
import com.francotte.newsapp.databinding.FragmentNewsBinding


class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        return binding.root
    }

    fun setUpRecyclerView() {
        val adapterInstance = NewsAdaptor()
        binding.rvNewsFragment.adapter = adapterInstance
    }

}