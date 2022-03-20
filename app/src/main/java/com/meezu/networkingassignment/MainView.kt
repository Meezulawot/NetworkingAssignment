package com.meezu.networkingassignment

import com.hannesdorfmann.mosby3.mvp.MvpView

interface MainView: MvpView {

    fun setUniversities(universityList: ArrayList<University>)
}