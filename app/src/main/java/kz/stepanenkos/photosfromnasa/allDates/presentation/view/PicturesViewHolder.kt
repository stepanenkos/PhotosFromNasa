package kz.stepanenkos.photosfromnasa.allDates.presentation.view

import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData
import kz.stepanenkos.photosfromnasa.databinding.PicturesItemBinding
import kz.stepanenkos.photosfromnasa.di.applicationModule
import okhttp3.HttpUrl
import org.koin.java.KoinJavaComponent.inject

class PicturesViewHolder(
     binding: PicturesItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val binding = PicturesItemBinding.bind(binding.root)
    fun onBind(picturesOfTheDaysData: PicturesOfTheDaysData) {
        binding.pictureOfTheDayTitle.text = picturesOfTheDaysData.title
        binding.pictureOfTheDayDate.text = picturesOfTheDaysData.date
        if(picturesOfTheDaysData.mediaType == "image") {
            binding.pictureOfTheDayImage.load(HttpUrl.get(picturesOfTheDaysData.hdUrl))
        }
        binding.pictureOfTheDayCopyright.text = picturesOfTheDaysData.copyright
    }
}