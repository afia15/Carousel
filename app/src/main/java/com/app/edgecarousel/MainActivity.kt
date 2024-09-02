package com.app.edgecarousel

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var carouselRecyclerView: RecyclerView
    private lateinit var mostViewedBtn: Button
    private lateinit var nearbyBtn: Button
    private lateinit var latestBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val mostViewdList = List(4) { index ->
            Banner(
                id = index + 1,
                title = when (index % 3) {
                    0 -> "Image Post #$index"
                    1 -> "Text Post #$index"
                    else -> "Video Post #$index"
                },
                description = "Description for post #$index",
                imageUrl = "https://picsum.photos/1500/1500?random=$index",
            )
        }
        val nearbyList = List(6) { index ->
            Banner(
                id = index + 1,
                title = when (index % 3) {
                    0 -> "Image Post #$index"
                    1 -> "Text Post #$index"
                    else -> "Video Post #$index"
                },
                description = "Description for post #$index",
                imageUrl = "https://picsum.photos/1400/1400?random=$index",
            )
        }
        val latestList = List(5) { index ->
            Banner(
                id = index + 1,
                title = when (index % 3) {
                    0 -> "Image Post #$index"
                    1 -> "Text Post #$index"
                    else -> "Video Post #$index"
                },
                description = "Description for post #$index",
                imageUrl = "https://picsum.photos/1300/1300?random=$index",
            )
        }


        mostViewedBtn = findViewById(R.id.mostViewed)
        nearbyBtn = findViewById(R.id.nearby)
        latestBtn = findViewById(R.id.latest)
        carouselRecyclerView = findViewById(R.id.carouselRecyclerView)


        val adapter = CarouselAdapter(items = mostViewdList) {
            Toast.makeText(this, "Image Clicked", Toast.LENGTH_SHORT).show()
        }
        carouselRecyclerView.adapter = adapter
        carouselRecyclerView.setLayoutManager(CarouselLayoutManager())

        mostViewedBtn.setOnClickListener {
            adapter.replaceDate(mostViewdList)
        }

        nearbyBtn.setOnClickListener {
            adapter.replaceDate(nearbyList)
        }

        latestBtn.setOnClickListener {
            adapter.replaceDate(latestList)
        }


    }
}