package gsihome.reyst.fileexhibitsloader.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import gsihome.reyst.model.entity.Exhibit;

public class ListWrapper {

    @SerializedName("list")
    private List<Exhibit> data;

    public List<Exhibit> getData() {
        return data;
    }

    public void setData(List<Exhibit> data) {
        this.data = data;
    }
}
