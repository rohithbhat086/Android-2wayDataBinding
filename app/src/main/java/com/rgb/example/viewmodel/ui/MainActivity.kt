package com.rgb.example.viewmodel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rgb.example.viewmodel.R
import com.rgb.example.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this, MainViewModelFactory(50)).get(MainActivityViewModel::class.java)

        mBinding.vm = mViewModel
        // with this, no need to observe livedata(mViewModel.sumData.observe...).
        mBinding.lifecycleOwner = this

        // After adding (mBinding.lifecycleOwner = this), the following is taken care
//        mViewModel.sumData.observe(this, Observer { it ->
//            mBinding.result.text = it.toString()
//        })

        // Moved this to onClick in layout xml
//        mBinding.button.setOnClickListener { view ->
//            var input = mBinding.inputField.text.toString()
//            if (input.isEmpty()) {
//                showError()
//                return@setOnClickListener
//            }
//            mViewModel.add(input.toInt())
//        }
    }

}