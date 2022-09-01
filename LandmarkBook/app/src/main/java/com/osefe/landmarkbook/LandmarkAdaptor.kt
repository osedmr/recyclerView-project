package com.osefe.landmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osefe.landmarkbook.databinding.RecylerRowBinding

class LandmarkAdaptor(val landmarkList:ArrayList<Landmark>):RecyclerView.Adapter<LandmarkAdaptor.LandmarkHolder> (){

    class LandmarkHolder(val binding:RecylerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
           val binding=RecylerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
           return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
          holder.binding.textView3.text= landmarkList.get(position).name
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }
}