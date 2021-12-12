package kz.stepanenkos.photosfromnasa.allDates.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.stepanenkos.photosfromnasa.allDates.domain.NasaRepository
import kz.stepanenkos.photosfromnasa.allDates.domain.models.PicturesOfTheDaysData
import kz.stepanenkos.photosfromnasa.utils.helpers.time.TimeHelper
import kz.stepanenkos.photosfromnasa.utils.model.ResponseData

class PicturesOfTheDaysViewModel(
    private val nasaRepository: NasaRepository,
) : ViewModel() {
    private val _text = MutableLiveData<List<PicturesOfTheDaysData>>()
    val text: LiveData<List<PicturesOfTheDaysData>> = _text

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun getAllDates() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val allDates = nasaRepository.getPicturesOfTheRangeDays(TimeHelper.getSpecificDay(-29))) {
                is ResponseData.Success -> {
                    _text.postValue(allDates.result!!)
                }
                is ResponseData.Error -> {
                    _error.postValue(allDates.error!!)
                }
            }
        }
    }
}