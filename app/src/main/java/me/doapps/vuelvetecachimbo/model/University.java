package me.doapps.vuelvetecachimbo.model;

/**
 * Created by doapps on 7/4/15.
 */
public class University {
    private String name;
    private int image;

    public University(){}

    public University(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
