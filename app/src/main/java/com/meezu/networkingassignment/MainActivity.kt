package com.meezu.networkingassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.mosby3.mvp.MvpActivity

class MainActivity : MvpActivity<MainView, MainPresenter>(),MainView {

    private lateinit var rcvUniversity: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvUniversity = findViewById(R.id.rcvUniversity)
        presenter.getUniversitiesUsingRx()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun setUniversities(universityList: ArrayList<University>) {
        runOnUiThread {
            val adapter = UniversityAdapter(universityList, this)
            rcvUniversity.layoutManager = LinearLayoutManager(this)
            rcvUniversity.adapter = adapter
        }   //Main Thread

    }
}