package com.cesaanwar.socmedapp.main.users

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.cesaanwar.socmedapp.R
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error
import com.cesaanwar.socmedapp.data.source.remote.result.User
import com.cesaanwar.socmedapp.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val viewModel: UsersViewModel by viewModels()
    lateinit var binding: FragmentUsersBinding
    lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservables()
    }

    private fun setupAdapter() {
        adapter = UserAdapter()
        binding.rvUsers.adapter = adapter
        viewModel.loadUsers(1)
    }

    private fun setupObservables() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> updateList(it.data)
                is Error -> showMessage(it.e)
                else -> showMessage(Exception("Unknown"))
            }
        }
    }

    private fun showMessage(e: Exception) {
        Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
    }

    private fun updateList(data: List<User>) {
        adapter.submitList(data)
    }

}