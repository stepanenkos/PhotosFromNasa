package kz.stepanenkos.photosfromnasa.allDates.presentation.view

import androidx.recyclerview.widget.DiffUtil
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData

class PicturesDiffUtilCallback : DiffUtil.ItemCallback<PicturesOfTheDaysData>() {
    override fun areItemsTheSame(
        oldItem: PicturesOfTheDaysData,
        newItem: PicturesOfTheDaysData
    ): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(
        oldItem: PicturesOfTheDaysData,
        newItem: PicturesOfTheDaysData
    ): Boolean {
        return oldItem == newItem
    }
}