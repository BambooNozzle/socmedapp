package com.cesaanwar.socmedapp.main.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesaanwar.socmedapp.data.source.remote.result.User
import com.cesaanwar.socmedapp.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _usersLiveData = MutableLiveData<Result<List<User>>>()
    val userLiveData: LiveData<Result<List<User>>> = _usersLiveData

    fun loadUsers(page: Int) {
        viewModelScope.launch {
            val res = getUsersUseCase.getUsers(page)
            _usersLiveData.value = res
        }
    }



}