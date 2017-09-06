package learning.sweta.com.mytestapplication.model;

import org.parceler.Parcel;

/**
 * Created by swetashinde on 9/6/17.
 */

@Parcel
public class Picture {

    String large;
    String medium;
    String thumbnail;

    public Picture() {
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
