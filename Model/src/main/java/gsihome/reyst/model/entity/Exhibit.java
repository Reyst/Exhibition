package gsihome.reyst.model.entity;

public class Exhibit {

    private String title;

    private String[] images;

    public Exhibit() {
    }

    public Exhibit(String title, String[] images) {
        this.title = title;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
