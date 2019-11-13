package edu.upc.dsa.models;

import java.util.Comparator;

public class Producte  {
    private double precio;
    private int ventas;
    private String nombre;

    public Producte(){

    }
    public Producte(String n,double p, int v ){
        this.precio=p;
        this.ventas=v;
        this.nombre=n;
    }

    protected Comparator<Producte> CMP_PRIZE = new Comparator<Producte>() {
        public int compare(Producte p1, Producte p2) {
            return (int) (p1.precio - p2.precio);
        }
    };

    // Collections.sort(productos, CMP_PRIZE)


    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void incrCantidad(int c){
        this.ventas+=c;
    }
}
