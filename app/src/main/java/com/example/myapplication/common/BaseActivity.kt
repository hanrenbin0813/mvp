package com.example.myapplication.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication.mvp.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseActivity : ComponentActivity() {
    var disposed: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        disposed=true
        super.onDestroy()
    }

    fun <T>loadData(observable: Observable<T>,observer: BaseObserver<T>){
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { if (disposed==true) false else true }
            .subscribeWith(observer)
    }

}
