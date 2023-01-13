package io.getarrays.userservice.domain;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = AUTO)
  private Long Id;
  private String name;
}
