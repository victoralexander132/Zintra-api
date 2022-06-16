package com.generation.zintra.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "comentario")
public @Data class Comentario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false, name="comentario_id")
   private Integer id;

   @Column(nullable = false)
   private String nombre;

   @Column(nullable = false)
   private String email;

   @Column(nullable = false)
   private String asunto;

   @Column(nullable = false)
   private String mensaje;

}
