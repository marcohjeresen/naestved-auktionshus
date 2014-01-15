/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Madsen
 */
public class Møbel {

    private String materialer;
    private String dimensioner;

    public Møbel(String materialer, String dimensioner) {
        this.materialer = materialer;
        this.dimensioner = dimensioner;
    }

    public String getMaterialer() {
        return materialer;
    }

    public void setMaterialer(String materialer) {
        this.materialer = materialer;
    }

    public String getDimensioner() {
        return dimensioner;
    }

    public void setDimensioner(String dimensioner) {
        this.dimensioner = dimensioner;
    }
}
