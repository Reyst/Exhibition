package gsihome.reyst.fileexhibitsloader;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import gsihome.reyst.fileexhibitsloader.data.ListWrapper;
import gsihome.reyst.model.ExhibitsLoader;
import gsihome.reyst.model.entity.Exhibit;

public class FileExhibitsLoader implements ExhibitsLoader {

    private final Gson gson;
    private InputStream inputStream;

    public FileExhibitsLoader(Gson gson, InputStream inputStream) {
        this.gson = gson;
        this.inputStream = inputStream;
    }

    @Override
    public List<Exhibit> getExhibitList() {

        Reader jsonFileReader = new InputStreamReader(inputStream);
        ListWrapper listWrapper = gson.fromJson(jsonFileReader, ListWrapper.class);

        if (listWrapper != null)
            return listWrapper.getData();

        return null;
    }
}
