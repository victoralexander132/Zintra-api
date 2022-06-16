package com.generation.zintra.model;

import javax.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {
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

   /*Getters & Setters*/

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAsunto() {
      return asunto;
   }

   public void setAsunto(String asunto) {
      this.asunto = asunto;
   }

   public String getMensaje() {
      return mensaje;
   }

   public void setMensaje(String mensaje) {
      this.mensaje = mensaje;
   }
}
