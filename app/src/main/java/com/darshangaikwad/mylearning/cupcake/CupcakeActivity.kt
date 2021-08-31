package com.darshangaikwad.mylearning.cupcake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.darshangaikwad.mylearning.R

/**
 * Created by Darshan Gaikwad on 17,August,2021
 */
class CupcakeActivity : AppCompatActivity(R.layout.activity_cupcake) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.cupcake_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }
}
