package gsihome.reyst.exhibition.data

import java.io.InputStream

interface DataProvider {

    fun getDataStream(): InputStream

}