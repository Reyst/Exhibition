package gsihome.reyst.exhibition

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import gsihome.reyst.exhibition.data.AssetDataProvider
import gsihome.reyst.exhibition.data.DataProvider
import gsihome.reyst.exhibition.factory.DataLoaderFactory
import gsihome.reyst.exhibition.util.ImageLoader
import gsihome.reyst.exhibition.util.PicassoImageLoader

class App : Application() {

    private val gson: Gson by lazy { GsonBuilder().create() }
    val dataProvider: DataProvider by lazy { AssetDataProvider(assetManager = assets) }
    val loaderFactory: DataLoaderFactory by lazy { DataLoaderFactory(gson) }
    val imageLoader: ImageLoader by lazy { PicassoImageLoader() }

}