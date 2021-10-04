package edu.temple.dualimageviewerapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView: TextView = findViewById(R.id.textView)

        var imageView: ImageView = findViewById(R.id.imageView2)

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val imageArray = arrayOf(
            ImageObject("badlands", R.drawable.badlands),
            ImageObject("plateau", R.drawable.plateau),
            ImageObject("bayou", R.drawable.bayou),
            ImageObject("savannah", R.drawable.savannah),
            ImageObject("scrubland", R.drawable.scrubland),
            ImageObject("taiga", R.drawable.taiga),
            ImageObject("trop", R.drawable.trop),
            ImageObject("tundra", R.drawable.tundra),
            ImageObject("usea", R.drawable.usea),
            ImageObject("volc", R.drawable.volc)
        )

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            imageView.setImageResource(imageArray[itemPosition].resourceID)
            textView.text = imageArray[itemPosition].description
        }

        recyclerView.adapter = ImageAdapter(this, imageArray, onClickListener)




    }


}

class ImageAdapter(var _context: Context, private val _dataSet: Array<ImageObject>, _ocl : View.OnClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val dataSet = _dataSet
    val ocl = _ocl

    class ViewHolder(_view: ImageView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val imageView = _view.apply { setOnClickListener(ocl) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, ocl)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.imageView.setImageResource(dataSet[position].resourceID)

    }

    override fun getItemCount() = dataSet.size

}