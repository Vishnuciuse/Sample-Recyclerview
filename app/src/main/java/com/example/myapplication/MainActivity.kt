package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.UI.CellClickListener
import com.example.myapplication.UI.ProductAdapter
import com.example.myapplication.api.QuotesApi
import com.example.myapplication.api.RetrofitHelper
import com.example.myapplication.dataclass.Products
import com.example.myapplication.dataclass.product_item
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivity
     var pList: ArrayList<product_item> = arrayListOf()
    lateinit var rvMain: RecyclerView
    lateinit var myAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         rvMain = findViewById<RecyclerView>(R.id.RecyclerView1)

        val temp =  ProductAdapter(this, pList, listener)


        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null)
            // Checking the results
                Log.d("ayush: ", result.body().toString())
            val list: Products? = result.body()
             pList = list!!.products as ArrayList<product_item>
            Log.d("product list","$pList")
            temp.update(pList)



            runOnUiThread {
                myAdapter =  ProductAdapter(baseContext, pList, listener)
                rvMain.adapter = myAdapter
            }


        }
        val images : List<String> = listOf("image")
//        pList.add(product_item(1,"vishnu","",12,2.3,4.3,20,"","","",images))

        rvMain.layoutManager = LinearLayoutManager(baseContext)
        myAdapter =  ProductAdapter(baseContext, pList, listener)
        rvMain.adapter = myAdapter
    }

    private var listener = object : CellClickListener {

        override fun onCellClickListener(position: Int) {
           Toast.makeText(this@MainActivity,"the position you clicked $position",Toast.LENGTH_LONG).show()
        }

    }

//    override fun onCellClickListener() {
//        val intent = Intent(this, DetailsActivity::class.java)
//        startActivity(intent)
//    }


}