package com.osefe.landmarkbook

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.osefe.landmarkbook.databinding.ActivityDetailsBinding
import com.osefe.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarklist:ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        landmarklist=ArrayList()

        val superman=Landmark("Süperman","Gazeteci",R.drawable.superman)
        val spiderman=Landmark("Spiderman","Gazeteci",R.drawable.spiderman)
        val ıronman=Landmark("Ironman","Milyoner",R.drawable.ironman)
        val aquaman=Landmark("Aquaman","Balık",R.drawable.aquaman)
        val batman=Landmark("Batman","İş Adamı",R.drawable.batman)

        landmarklist.add(superman)
        landmarklist.add(spiderman)
        landmarklist.add(ıronman)
        landmarklist.add(aquaman)
        landmarklist.add(batman)




        val landmarkAdapter=LandmarkAdaptor(landmarklist)
        binding.recyclerView.adapter=landmarkAdapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
 /*

         val adaptor=ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarklist.map { landmark -> landmark.name })
        binding.listView.adapter=adaptor
        
        
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val intent= Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarklist.get(position))
            startActivity(intent)
        }

  */
    }
}