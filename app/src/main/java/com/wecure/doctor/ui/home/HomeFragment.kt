package com.wecure.doctor.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wecure.doctor.DataSource
import com.wecure.doctor.DoctorRecyclerAdapter
import com.wecure.doctor.HistoryRecyclerAdapter
import com.wecure.doctor.R
import com.wecure.doctor.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var nameList = mutableListOf<String>()
    private var categoryList = mutableListOf<String>()
    private var profileList = mutableListOf<Int>()
    private var nameListHistory = mutableListOf<String>()
    private var categoryListHistory = mutableListOf<String>()
    private var profileListHistory = mutableListOf<Int>()
    private var dateListHistory = mutableListOf<String>()
    private var _binding: FragmentHomeBinding? = null

    private val data = DataSource.createDataSet()
    private val dataHistory = DataSource.createDataSetHistory()
    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        postToList()
        recyclerDoctors.layoutManager= LinearLayoutManager(this.context,RecyclerView.HORIZONTAL,false)
        recyclerDoctors.adapter = DoctorRecyclerAdapter(nameList,categoryList,profileList)

        recyclerDoctors.layoutManager= LinearLayoutManager(this.context,RecyclerView.HORIZONTAL,false)
        recyclerDoctors.adapter = HistoryRecyclerAdapter(nameListHistory,categoryListHistory,profileListHistory,dateListHistory)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

private fun addToList(name:String,category:String,proile:Int){

    nameList.add(name)
    categoryList.add(category)
    profileList.add(proile)

}
private fun postToList(){
    for( i in 0 until data.size-1){
        addToList(data[i].name,data[i].desc,data[i].image)
    }
}

    private fun addToListHistory(namehist:String,categoryhist:String,proilehist:Int,datehist:String){

        nameList.add(namehist)
        categoryList.add(categoryhist)
        profileList.add(proilehist)
        dateListHistory.add(datehist)

    }
    private fun postToListHistory(){
        for( i in 0 until data.size-1){
            addToListHistory(dataHistory[i].name,dataHistory[i].category,dataHistory[i].image,dataHistory[i].date)
        }
    }
}