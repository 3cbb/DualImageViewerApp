package edu.temple.dualimageviewerapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Array<ImageObject>? = null


    private lateinit var layout : View

    private lateinit var recyclerView : RecyclerView

    private lateinit var imageArray : Array<ImageObject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Array<ImageObject>
            imageArray = param1 as Array<ImageObject>
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        recyclerView = layout.findViewById(R.id.recyclerView)


        val onClickListener = View.OnClickListener {
            //val itemPosition = recyclerView.getChildAdapterPosition(it)

            //val launchActivityIntent = Intent(requireActivity(), DisplayActivity::class.java)

            //launchActivityIntent.putExtra("ImageObjectIn", imageArray[itemPosition])

            //startActivity(launchActivityIntent)
        }

        recyclerView.adapter = ImageAdapter(requireActivity(), imageArray, onClickListener)

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }

        fun getInstance (input: Array<ImageObject>) : SelectionFragment {
            val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            bundle.putSerializable("param1", input)
            fragment.arguments = bundle
            return fragment
        }
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