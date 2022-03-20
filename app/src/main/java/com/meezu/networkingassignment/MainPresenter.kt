package com.meezu.networkingassignment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenter: MvpBasePresenter<MainView>() {

    fun getUniversitiesUsingRx(){
        UniversityRepository().getUniversitiesByRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ArrayList<University>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(t: ArrayList<University>) {
                    ifViewAttached { view -> view.setUniversities(t) }
                }

                override fun onError(e: Throwable) {

                }

            })


    }
}


