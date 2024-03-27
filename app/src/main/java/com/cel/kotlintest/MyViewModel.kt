package com.cel.kotlintest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cel.kotlintest.model.User
import com.cel.kotlintest.repos.MyRepository
import com.cel.kotlintest.repos.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: UserRepository): ViewModel() {
    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData
    private val _userListLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>> = _userListLiveData

    fun getUser(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = repository.getUser(userId)
                _userLiveData.postValue(user)
            } catch (e: Exception) {
                Log.d("TAG", "getUser: "+e.message)
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun getUserList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userList = repository.getUserList()
                _userListLiveData.postValue(userList)
            } catch (e: Exception) {
                Log.d("TAG", "getUser: " + e.message)
                // Handle error
                e.printStackTrace()
            }
        }
    }
}