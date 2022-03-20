package com.meezu.networkingassignment

import io.reactivex.Single

class UniversityRepository {

    fun getUniversitiesByRx() : Single<ArrayList<University>> {
        return RetrofitHelper.getMyApi().getAllUniversities()
    }
}