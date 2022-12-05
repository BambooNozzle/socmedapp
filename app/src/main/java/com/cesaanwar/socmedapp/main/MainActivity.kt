package com.cesaanwar.socmedapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cesaanwar.socmedapp.R
import com.cesaanwar.socmedapp.databinding.ActivityMainBinding
import com.cesaanwar.socmedapp.main.likes.LikesFragment
import com.cesaanwar.socmedapp.main.posts.PostsFragment
import com.cesaanwar.socmedapp.main.users.UsersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val usersFragment = UsersFragment.newInstance()
        val postsFragment = PostsFragment.newInstance()
        val likesFragment = LikesFragment.newInstance()

        binding.btmNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.users -> setCurrentFragment(usersFragment)
                R.id.posts -> setCurrentFragment(postsFragment)
                R.id.likes -> setCurrentFragment(likesFragment)
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_frame,fragment)
            commit()
        }

}