package com.cesaanwar.socmedapp.main.likes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.domain.DeletePostFromLocalUseCase
import com.cesaanwar.socmedapp.domain.GetSavedPostsUseCase
import com.cesaanwar.socmedapp.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikesViewModel @Inject constructor(
    private val getSavedPostsUseCase: GetSavedPostsUseCase,
    private val deletePostFromLocalUseCase: DeletePostFromLocalUseCase
): ViewModel() {

    private val _postsLiveData = MutableLiveData<Result<List<Post>>>()
    val postsLiveData: LiveData<Result<List<Post>>> = _postsLiveData

    fun loadSavedPosts() {
        viewModelScope.launch {
            val res = getSavedPostsUseCase.getAllLikedPosts()
            _postsLiveData.value = res
        }
    }

}