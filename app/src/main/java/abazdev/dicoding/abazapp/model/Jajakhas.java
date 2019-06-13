package abazdev.dicoding.abazapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Jajakhas implements Parcelable {
    private String name;
    private String description;
    private String photo;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.photo);
        dest.writeString(this.category);
    }

    public Jajakhas() {
    }

    protected Jajakhas(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readString();
        this.category = in.readString();
    }

    public static final Parcelable.Creator<Jajakhas> CREATOR = new Parcelable.Creator<Jajakhas>() {
        @Override
        public Jajakhas createFromParcel(Parcel source) {
            return new Jajakhas(source);
        }

        @Override
        public Jajakhas[] newArray(int size) {
            return new Jajakhas[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}