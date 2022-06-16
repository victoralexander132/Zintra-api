package com.generation.zintra.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "pago")
public @Data class Pago {
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

}
