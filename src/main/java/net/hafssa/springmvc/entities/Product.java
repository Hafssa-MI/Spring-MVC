package net.hafssa.springmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
// Lombok se charge de l'implémentation de ces méthodes
public class Product {
    @Id @GeneratedValue
    private Long  id;
    @NotEmpty
    @Size(min=3, max=50)
    private String name;
    @Min(0)
    private double price;
    @Min(1)
    private double quantity;
}
