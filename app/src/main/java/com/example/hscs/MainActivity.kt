package com.example.hscs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.hscs.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        // Creates a button that mimics a crash when pressed
//        val crashButton = Button(this)
//        crashButton.text = "Test Crash"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))

    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.apply {
            val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
            itemIconTintList = null

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
            navHostFragment.navController.apply {
                setupWithNavController(this)
                addOnDestinationChangedListener { _, _, args ->
                    // Top level items should have such argument with value set to true
                    isVisible = args?.getBoolean("hasBottomNav", false) == true
                }
                setOnItemReselectedListener { } // Do nothing when selecting same item
            }
        }
    }

}