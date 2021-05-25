package vinit.sonyliv.model;

import com.google.gson.annotations.SerializedName;

public class ImageUrl {
    @SerializedName("200x200")
    private String url200;
    @SerializedName("400x400")
    private String url400;
    @SerializedName("800x800")
    private String url800;

    public String getUrl200() {
        return url200;
    }

    public void setUrl200(String url200) {
        this.url200 = url200;
    }

    public String getUrl400() {
        return url400;
    }

    public void setUrl400(String url400) {
        this.url400 = url400;
    }

    public String getUrl800() {
        return url800;
    }

    public void setUrl800(String url800) {
        this.url800 = url800;
    }
}
