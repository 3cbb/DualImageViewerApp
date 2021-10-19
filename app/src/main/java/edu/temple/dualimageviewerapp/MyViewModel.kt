package edu.temple.dualimageviewerapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val imageObject: MutableLiveData<ImageObject> by lazy {
        MutableLiveData<ImageObject>().also {
            loadImageObject()
        }
    }

    fun getImageObject(): LiveData<ImageObject> {
        return imageObject
    }

    fun setImageObject(_imageObject : ImageObject){
        imageObject.value = _imageObject

    }

    private fun loadImageObject() {

    }


}
