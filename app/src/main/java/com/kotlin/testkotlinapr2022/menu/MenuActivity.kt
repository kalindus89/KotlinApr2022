package com.kotlin.testkotlinapr2022.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kotlin.testkotlinapr2022.R
import com.kotlin.testkotlinapr2022.databinding.ActivityMainBinding

class MenuActivity : AppCompatActivity() {

      private lateinit var binding: ActivityMainBinding
      private lateinit var menuViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


         binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.lifecycleOwner = this
        binding.menuViewModel=menuViewModel

        menuViewModel.changeActivityId.observe(this) {

            when (it) {
                1 -> {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
