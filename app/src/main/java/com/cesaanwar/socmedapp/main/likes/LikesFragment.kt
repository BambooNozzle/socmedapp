package com.cesaanwar.socmedapp.main.likes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.databinding.FragmentLikesBinding
import com.cesaanwar.socmedapp.main.PostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikesFragment : Fragment() {

    companion object {
        fun newInstance() = LikesFragment()
    }

    private val viewModel: LikesViewModel by viewModels()
    lateinit var binding : FragmentLikesBinding
    lateinit var adapter : PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservables()
        viewModel.loadSavedPosts()
    }

    private fun setupAdapter() {
        adapter = PostAdapter()
        binding.rvLikedPosts.adapter = adapter
    }

    private fun setupObservables() {
        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> updateList(it.data)
                is Error -> showError(it.e)
                else -> showError(Exception("Unknown"))
            }
        }
    }

    private fun showError(e: Exception) {
        Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
    }


    private fun updateList(it: List<Post>) {
        adapter.submitList(it)
    }

}