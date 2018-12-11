package gsihome.reyst.exhibition.gui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import gsihome.reyst.exhibition.App
import gsihome.reyst.model.entity.Exhibit
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val dataProvider = (application as App).dataProvider
    private val dataLoaderFactory = (application as App).loaderFactory

    private val exhibits: MutableLiveData<List<Exhibit>> = MutableLiveData()

    private val tasks = CompositeDisposable()

    fun initData() {
        if (exhibits.value != null) {
            return
        }

        Single.fromCallable { dataLoaderFactory.create(dataProvider.getDataStream()).exhibitList }
                .subscribeOn(Schedulers.io())
                .subscribe({ exhibitList -> exhibits.postValue(exhibitList) },
                           { error -> Log.e("Load", error.message, error) })
                .also { tasks.add(it) }
    }

    fun getObservableExhibits(): LiveData<List<Exhibit>> = exhibits

    override fun onCleared() {
        tasks.clear()
        super.onCleared()
    }
}