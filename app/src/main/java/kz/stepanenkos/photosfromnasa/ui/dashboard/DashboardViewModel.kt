package kz.stepanenkos.photosfromnasa.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.stepanenkos.photosfromnasa.allDates.domain.AllDatesRepository
import kz.stepanenkos.photosfromnasa.allDates.domain.models.AllDatesData

class DashboardViewModel(
    private val allDatesRepository: AllDatesRepository,
) : ViewModel() {

    private val _text = MutableLiveData<List<AllDatesData>>()
    val text: LiveData<List<AllDatesData>> = _text

    fun getAllDates() {
        viewModelScope.launch { _text.value = allDatesRepository.getAllDates() }
    }
}