package com.codeschool.myapplication.ui.ecommerce.activity

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.codeschool.common.BaseCommonActivity
import com.codeschool.myapplication.databinding.ActivityEcommerceHomeBinding
import com.codeschool.myapplication.ui.ecommerce.fragment.HotSalesFragment

class EcommerceHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEcommerceHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEcommerceHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }
}