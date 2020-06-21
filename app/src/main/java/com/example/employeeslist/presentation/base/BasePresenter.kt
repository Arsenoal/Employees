package com.example.employeeslist.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

typealias Success<T> = (T) -> Unit
typealias SuccessCompletable = () -> Unit

abstract class BasePresenter<VIEW_STATE: MvpView>: MvpPresenter<VIEW_STATE>() {

    private val compositeDisposable = CompositeDisposable()

    fun execute(
        completable: Completable,
        successCompletable: SuccessCompletable) {
        compositeDisposable.add(
            completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        successCompletable.invoke()
                    }, {
                        it.printStackTrace() //TODO this is not great, change with app logger
                    })
        )
    }

    fun <T> execute(
        observable: Observable<T>,
        success: Success<T>) {
        compositeDisposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        success.invoke(it)
                    }, {
                        it.printStackTrace() //TODO this is not great, change with app logger
                    })
        )
    }

    fun <T> execute(
        single: Single<T>,
        success: Success<T>) {
        compositeDisposable.add(
            single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        success.invoke(it)
                    }, {
                        it.printStackTrace() //TODO this is not great, change with app logger
                    })
        )
    }

}