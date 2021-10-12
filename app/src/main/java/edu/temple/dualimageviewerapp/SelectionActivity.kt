package edu.temple.dualimageviewerapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landNames = resources.getStringArray(R.array.land_names)


        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val imageArray = arrayOf(
            ImageObject(landNames[7], R.drawable.badlands),
            ImageObject(landNames[2], R.drawable.plateau),
            ImageObject(landNames[8], R.drawable.bayou),
            ImageObject(landNames[3], R.drawable.savannah),
            ImageObject(landNames[1], R.drawable.scrubland),
            ImageObject(landNames[9], R.drawable.taiga),
            ImageObject(landNames[6], R.drawable.trop),
            ImageObject(landNames[0], R.drawable.tundra),
            ImageObject(landNames[4], R.drawable.usea),
            ImageObject(landNames[5], R.drawable.volc)
        )

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            val launchActivityIntent = Intent(this, DisplayActivity::class.java)

            launchActivityIntent.putExtra("ImageObjectIn", imageArray[itemPosition])

            startActivity(launchActivityIntent)
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