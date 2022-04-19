package com.kotlin.testkotlinapr2022.project1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.testkotlinapr2022.R
import com.kotlin.testkotlinapr2022.project1.models.AllResultsModel
import com.kotlin.testkotlinapr2022.project1.viewmodel.ViewModelGitHubApi


class RecyclerListFragment : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var githubRecyclerAdapter: GithubRecyclerAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(R.layout.fragment_recycler_list, container, false)

        initRecycler(view)
        initViewModel()

        return view
    }



    private fun initRecycler(view: View) {
        val recyclerView= view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =LinearLayoutManager(activity)
        val decoration=DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        githubRecyclerAdapter= GithubRecyclerAdapter()
        recyclerView.adapter=githubRecyclerAdapter
    }

/*    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this).get(ViewModelGitHubApi::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                githubRecyclerAdapter.setUpdatedData(it.items)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.makeApiCall()
    }*/

    private fun initViewModel() {

        val viewModel= ViewModelProvider(this).get(ViewModelGitHubApi::class.java)
        viewModel.makeApiCall()
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner) {
            if(it !=null){
                githubRecyclerAdapter.setUpdatedData(it.items)
            }else{
                Toast.makeText(activity,"Error in getting data", Toast.LENGTH_SHORT).show()
            }
        }
    }


}