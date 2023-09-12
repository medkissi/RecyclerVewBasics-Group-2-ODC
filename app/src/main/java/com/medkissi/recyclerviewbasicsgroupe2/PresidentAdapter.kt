package com.medkissi.recyclerviewbasicsgroupe2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.medkissi.recyclerviewbasicsgroupe2.model.President

class PresidentAdapter(val listner: OnItemClickListner):ListAdapter<President,PresidentAdapter.PresidentViewHolder>(PresidentDiffUtil()){

    inner class PresidentViewHolder(itemView: View):ViewHolder(itemView.rootView){

        val photo = itemView.findViewById<ImageView>(R.id.circleImageView)
        val nom =  itemView.findViewById<TextView>(R.id.nom)
        val pays = itemView.findViewById<TextView>(R.id.pays)

        init {
         itemView.setOnClickListener {
             if (adapterPosition != RecyclerView.NO_POSITION){

                 val president = getItem(adapterPosition)
                 listner.onClick(president)

             }
         }
        }



        fun lier(president: President){
            photo.setImageResource(president.photo)
            nom.text = president.nom
            pays.text = president.pays
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresidentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_2,parent,false)
        return PresidentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PresidentViewHolder, position: Int) {
        val president = getItem(position)
        holder.lier(president)



}


class PresidentDiffUtil:DiffUtil.ItemCallback<President>(){
    override fun areItemsTheSame(oldItem: President, newItem: President): Boolean {
        return  oldItem.id  == newItem.id
    }

    override fun areContentsTheSame(oldItem: President, newItem: President): Boolean {
         return oldItem == newItem
    }

}
}


interface  OnItemClickListner{
    fun onClick(president: President)
}