package com.meezu.networkingassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UniversityAdapter (
    val lstUniversity: ArrayList<University>,
    val context: Context
): RecyclerView.Adapter<UniversityAdapter.UniversityVH>() {

    class UniversityVH(view: View): RecyclerView.ViewHolder(view){
        var name: TextView = view.findViewById(R.id.txvName)
        var country: TextView = view.findViewById(R.id.txvCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_custom_university, parent, false)
        return UniversityVH(view)
    }

    override fun onBindViewHolder(holder: UniversityVH, position: Int) {
        val university = lstUniversity[position]
        holder.name.text = university.name
        holder.country.text = university.country
    }

    override fun getItemCount(): Int {
        return lstUniversity.size
    }
}