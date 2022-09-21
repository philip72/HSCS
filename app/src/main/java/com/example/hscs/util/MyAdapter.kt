package com.example.hscs.util

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hscs.R
import com.example.hscs.dataClass.specialist

class MyAdapter(private val specialistList:ArrayList<specialist>):RecyclerView.Adapter<MyAdapter.MyViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.specialist_list,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = specialistList[position]

        holder.specialistFirstName.text= currentItem.specialistFirstName
    }

    override fun getItemCount(): Int {
        return specialistList.size
    }
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val specialistFirstName : TextView=itemView.findViewById(R.id.specialistFirstName)
        val specialistLastName : TextView= itemView.findViewById(R.id.SpecialistLastName)
        val specialistEmail : TextView= itemView.findViewById(R.id.specialistRegEmail)
        val specialistPhoneNumber : TextView= itemView.findViewById(R.id.specialistPhoneNo)
        val specialistHospitalId: TextView=itemView.findViewById(R.id.HospitalId)
        val specialistProfessionPractised:TextView=itemView.findViewById(R.id.ProfessionPractisec)
        val specialistYearsOfExperience:TextView=itemView.findViewById(R.id.YearsOfExp)
        val specialistAge:TextView=itemView.findViewById(R.id.Age)
        val specialistHospitalPractised:TextView= itemView.findViewById(R.id.hospitalPractising)
    }

}