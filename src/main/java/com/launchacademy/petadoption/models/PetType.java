package com.launchacademy.petadoption.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pet_types")
@NoArgsConstructor
@Getter
@Setter
public class PetType {
  @Id
  @SequenceGenerator(name="pet_types_generator", sequenceName = "pet_types_id_seq", allocationSize = 1  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_types_generator")
  @Column(name="id", nullable = false)
  private Integer id;

  @Column(name="type", nullable = false)
  private String type;

  @Column(name="img_url", nullable = false)
  private String imgUrl;

  @Column(name="description")
  private String description;
}
