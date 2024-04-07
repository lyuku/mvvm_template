package tech.lyuku.mvvm_template.base.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class BasePageStateViewModel : BaseViewModel() {

    private val _pageState = MutableLiveData<PageState>()
    val pageState: LiveData<PageState> = _pageState

    fun setPageState(pageState: PageState) {
        _pageState.value = pageState
    }
}