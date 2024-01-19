package com.example.mvvmcap1.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcap1.R
import com.example.mvvmcap1.databinding.ActivityHomeBinding
import com.example.mvvmcap1.presentation.artist.ArtistActivity
import com.example.mvvmcap1.presentation.movie.MovieActivity
import com.example.mvvmcap1.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        homeBinding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        homeBinding.tvShowButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
        homeBinding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}