package gsihome.reyst.exhibition.data

import android.content.res.AssetManager
import java.io.InputStream

class AssetDataProvider(private val assetManager: AssetManager): DataProvider {

    override fun getDataStream(): InputStream {
        return assetManager.open("data.json")
    }
}