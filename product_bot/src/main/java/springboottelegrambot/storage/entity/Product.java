package springboottelegrambot.storage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "product") //schema = "app_product"
public class Product {
    @Id
    private UUID id;
    private Long dtCreate;
    private Long dtUpdate;
    private String brand;
    private String gender;
    private String model;
    private String purpose;
    private String shape;
    private String band;
    private String material;
    private String flexInCollection;
    private double optimalWight;
    private double optimalHeight;
}
