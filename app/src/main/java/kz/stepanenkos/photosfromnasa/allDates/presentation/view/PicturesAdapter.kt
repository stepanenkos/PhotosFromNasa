package kz.stepanenkos.photosfromnasa.allDates.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData
import kz.stepanenkos.photosfromnasa.databinding.PicturesItemBinding

class PicturesAdapter :
    ListAdapter<PicturesOfTheDaysData, PicturesViewHolder>(PicturesDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        return PicturesViewHolder(
            binding = PicturesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}