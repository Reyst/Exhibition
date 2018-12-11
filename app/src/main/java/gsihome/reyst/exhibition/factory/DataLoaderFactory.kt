package gsihome.reyst.exhibition.factory

import com.google.gson.Gson
import gsihome.reyst.fileexhibitsloader.FileExhibitsLoader
import gsihome.reyst.model.ExhibitsLoader
import java.io.InputStream

class DataLoaderFactory(private val gson: Gson) {
    fun create(inputStream: InputStream): ExhibitsLoader = FileExhibitsLoader(gson, inputStream)
}