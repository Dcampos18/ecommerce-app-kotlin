package com.camposconsulting.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide();

        val imageSliderAdapter = ImageSliderAdapter(this)

        main_image_slider.setSliderAdapter(imageSliderAdapter)
        main_image_slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        main_image_slider.startAutoCycle()

        imageSliderAdapter.renewItems(fetchSliderItemList())

        main_recycler_view.apply {
            adapter = ItemListAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        main_recycler.apply {
            adapter = ItemList2Adapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun fetchSliderItemList(): List<String> {
        val items = arrayListOf<String>()
        items.add("https://images.pexels.com/photos/1779487/pexels-photo-1779487.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")

        items.add("https://images.pexels.com/photos/3937174/pexels-photo-3937174.jpeg?auto=compress&cs=tinysrgb&w=1600")

        items.add("https://images.pexels.com/photos/115655/pexels-photo-115655.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        return items
    }
}