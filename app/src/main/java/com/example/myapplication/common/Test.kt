package com.example.myapplication.common

import android.os.Bundle
import com.example.myapplication.mvp.BaseView
import com.example.myapplication.mvp.DataCallBack
import com.example.myapplication.presenter.MainPresenter

class Test : BaseActivity(), BaseView {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val presenter = MainPresenter()
        presenter.getPhone(this, "1111111111", object : DataCallBack {
            override fun callBack(obj: Any?) {
            }
        })
    }

    override fun requestStart() {
    }

    override fun requestFinish() {
    }
}
