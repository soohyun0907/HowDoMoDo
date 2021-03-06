package com.ssafy.howdomodo.ui.selectArea

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.howdomodo.R
import com.ssafy.howdomodo.data.datasource.model.Region
import kotlinx.android.synthetic.main.item_gugun.view.*


class GugunAdapter(private val onclick: GugunViewHolder.GugunClickListener) :
    RecyclerView.Adapter<GugunViewHolder>() {
    val cityData = ArrayList<Region>()

    fun setGuGunData(data: List<Region>) {
        with(cityData) {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun getClicked(position: Int): Boolean {
        return cityData[position].isClicked
    }

    fun getClickedGuGun(): Int {
        for (i in cityData.indices) {
            if (cityData[i].isClicked) {
                return i
            }
        }
        return -1
    }

    fun setClicked(position: Int, status: Boolean) {
        cityData[position].isClicked = status
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GugunViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gugun, parent, false)
        return GugunViewHolder(inflatedView, onclick)
    }

    override fun getItemCount(): Int {
        return cityData.size
    }

    override fun onBindViewHolder(holder: GugunViewHolder, position: Int) {
        holder.bind(cityData[position])
    }
}

class GugunViewHolder(
    itemView: View,
    private val gugunClickListener: GugunClickListener
) :
    RecyclerView.ViewHolder(itemView) {

    interface GugunClickListener {
        fun onclick(position: Int, textView: TextView)
    }

    init {
        itemView.item_gugun_cl_box.setOnClickListener {
            gugunClickListener.onclick(adapterPosition, itemView.item_gugun_tv_gugun)
        }
    }

    fun bind(data: Region) {
        var gugun = data.name
        itemView.item_gugun_tv_gugun.text = gugun

        if (data.isClicked) {
            itemView.item_gugun_cl_box.setBackgroundResource(R.drawable.item_sido_selected)
            itemView.item_gugun_tv_gugun.setTextColor(Color.parseColor("#fff4eb"))
        } else {
            itemView.item_gugun_cl_box.setBackgroundResource(R.drawable.item_sido_unselected)
            itemView.item_gugun_tv_gugun.setTextColor(Color.parseColor("#333333"))
        }

    }
}
