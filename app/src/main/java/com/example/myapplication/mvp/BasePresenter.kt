package com.example.myapplication.mvp

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers


/**
 * 作者:Created by sinbara on 2019/2/13.
 * 邮箱:hrb940258169@163.com
 */
open class BasePresenter {
    private var disposed = false

    fun dispose() {
        disposed = true
    }

    fun <T>loadData(observable: Observable<T>, observer: BaseObserver<T>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter {
            if (disposed==true) false
            else true}
            .subscribeWith(observer)
    }
}
