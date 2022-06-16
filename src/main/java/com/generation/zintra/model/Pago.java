package com.generation.zintra.model;

import javax.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="pago_id")
    private Integer id;

    @Column(nullable = false)
    private Integer cvc;

    @Column(nullable = false)
    private Integer fecha_vencim;

    @Column(nullable = false)
    private String nombre_tarjeta;

    @Column(nullable = false)
    private String numero_tarjeta;

    @OneToOne
    @JoinColumn(nullable = false, name = "envio_id")
    private Envio envio;

    /*Getters & Setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public Integer getFecha_vencim() {
        return fecha_vencim;
    }

    public void setFecha_vencim(Integer fecha_vencim) {
        this.fecha_vencim = fecha_vencim;
    }

    public String getNombre_tarjeta() {
        return nombre_tarjeta;
    }

    public void setNombre_tarjeta(String nombre_tarjeta) {
        this.nombre_tarjeta = nombre_tarjeta;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
}
