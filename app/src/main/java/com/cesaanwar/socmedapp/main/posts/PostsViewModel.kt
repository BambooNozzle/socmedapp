package com.cesaanwar.socmedapp.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.domain.DeletePostFromLocalUseCase
import com.cesaanwar.socmedapp.domain.GetAllPostsUseCase
import com.cesaanwar.socmedapp.domain.GetSavedPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val savedPostsUseCase: GetSavedPostsUseCase,
    private val deletePostFromLocalUseCase: DeletePostFromLocalUseCase
) : ViewModel() {

    private val _postsLiveData = MutableLiveData<Result<List<Post>>>()
    val postsLiveData : LiveData<Result<List<Post>>> = _postsLiveData

    fun fetchAllPosts(page: Int) {
        viewModelScope.launch {
            val res = getAllPostsUseCase.getAllPosts(page)
            _postsLiveData.value = res
        }
    }

}