package com.example.myapplication.presenter

import com.example.myapplication.api.ApiRetrofit
import com.example.myapplication.model.MainTagBean
import com.example.myapplication.model.PhoneBean
import com.example.myapplication.mvp.BaseModel
import com.example.myapplication.mvp.BaseObserver
import com.example.myapplication.mvp.BasePresenter
import com.example.myapplication.mvp.BaseView
import com.example.myapplication.mvp.DataCallBack

class MainPresenter : BasePresenter() {
    fun getMainTag(view: BaseView?, callBack: DataCallBack) {
        val observable = ApiRetrofit.getInstance().getApiService().getMainTag("")
        val observer: BaseObserver<BaseModel<MainTagBean?>?> =
            object : BaseObserver<BaseModel<MainTagBean?>?>(view) {
                override fun onSuccess(o: BaseModel<MainTagBean?>?) {
                    callBack.callBack(o)
                }
            }
        loadData<BaseModel<MainTagBean?>?>(observable, observer)
    }

    fun getPhone(view: BaseView?, phone: String?, callBack: DataCallBack) {
        val observable = ApiRetrofit.getInstance().getApiService().getPhone(phone)
        val observer: BaseObserver<PhoneBean?> = object : BaseObserver<PhoneBean?>(view) {
            override fun onSuccess(o: PhoneBean?) {
                callBack.callBack(o)
            }
        }
        loadData<PhoneBean?>(observable, observer)
    }
}
