package com.codeschool.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.codeschool.myapplication.databinding.ActivityDashboardBinding
import com.codeschool.myapplication.ui.ecommerce.activity.EcommerceStartActivity
import com.codeschool.myapplication.ui.guardian.GuardianNewsActivity

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
 private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyCodeSchoolApplicationsEnum.values().forEach {
            val button = AppCompatButton(this)
            button.text = it.name.replace("_", " ")
            button.tag = it
            binding.linearLayout.addView(button)
            button.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.tag as MyCodeSchoolApplicationsEnum) {
            MyCodeSchoolApplicationsEnum.GUARDIAN -> startActivity(
                Intent(
                    this,
                    GuardianNewsActivity::class.java
                )
            )
            MyCodeSchoolApplicationsEnum.E_COMMERCE -> startActivity(
                Intent(
                    this,
                    EcommerceStartActivity::class.java
                )
            )
        }
    }
}

enum class MyCodeSchoolApplicationsEnum {
    GUARDIAN,
    E_COMMERCE
}