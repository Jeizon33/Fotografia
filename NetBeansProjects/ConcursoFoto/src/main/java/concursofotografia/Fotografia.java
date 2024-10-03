package concursofotografia;

public class Fotografia {
    private String titulo;
    private String autor;
    private String nacionalidad;
    private double puntuacion;

    // Constructor
    public Fotografia(String titulo, String autor, String nacionalidad, double puntuacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.nacionalidad = nacionalidad;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Nacionalidad: " + nacionalidad + ", Puntuación: " + puntuacion;
    }
}

