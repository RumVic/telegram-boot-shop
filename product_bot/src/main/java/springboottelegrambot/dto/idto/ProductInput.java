package springboottelegrambot.dto.idto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductInput {

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
