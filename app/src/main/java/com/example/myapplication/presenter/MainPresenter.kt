package com.example.myapplication.presenter

import com.example.myapplication.api.ApiRetrofit
import com.example.myapplication.model.MainTagBean
import com.example.myapplication.model.PhoneBean
import com.example.myapplication.mvp.BaseModel
import com.example.myapplication.mvp.BaseObserver
import com.example.myapplication.mvp.BasePresenter
import com.example.myapplication.mvp.BaseView
import com.example.myapplication.mvp.DataCallBack
import io.reactivex.Observable

class MainPresenter : BasePresenter() {
    fun getMainTag(view: BaseView?, callBack: DataCallBack) {
        val observable = ApiRetrofit.getInstance().apiServer.getMainTag("")
        val observer: BaseObserver<BaseModel<MainTagBean?>?> =
            object : BaseObserver<BaseModel<MainTagBean?>?>(view) {
                override fun onSuccess(o: BaseModel<MainTagBean?>?) {
                    callBack.callBack(o)
                }
            }
        startRequest(observable,observer)
    }

    fun getPhone(view: BaseView?, phone: String?, callBack: DataCallBack) {
        val observable = ApiRetrofit.getInstance().apiServer.getPhone(phone)
        val observer: BaseObserver<PhoneBean?> = object : BaseObserver<PhoneBean?>(view) {
            override fun onSuccess(o: PhoneBean?) {
                callBack.callBack(o)
            }
        }
        startRequest(observable,observer)
    }

    fun <T>startRequest(observable: Observable<T>,observer: BaseObserver<T>){
        observer.onStart();
        loadData(observable,observer)
    }
}
