/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Madsen
 */
public class Furniture extends Product {

    private String materials;
    private String dimensions;

    public Furniture(String materials, String dimensions, String title, String description, int estimatedPrice, String picturePath) {
        super(title, description, estimatedPrice, picturePath);
        this.materials = materials;
        this.dimensions = dimensions;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

}
