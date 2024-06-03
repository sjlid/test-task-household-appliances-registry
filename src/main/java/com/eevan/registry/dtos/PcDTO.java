package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class PcDTO {
    @NotEmpty(message = "Product type should not be empty")
    private String productType;

    @NotEmpty(message = "Manufacturing country should not be empty")
    private String countryManufacturer;

    @NotEmpty(message = "Manufacturing company should not be empty")
    private String companyManufacturer;
    private Boolean isAbleToBuyOnline;
    private Boolean isAbleToInstallment;

    @NotEmpty(message = "Model's name should not be empty")
    private String modelName;

    @NotEmpty(message = "Model's serial should not be empty")
    private String modelSerialNumber;

    @NotEmpty(message = "Model's color should not be empty")
    private String modelColor;

    @NotEmpty(message = "Model's size should not be empty")
    private int modelSize;

    @NotEmpty(message = "Model's price should not be empty")
    private BigDecimal modelPrice;

    @NotEmpty(message = "Model's category should not be empty")
    private String modelCategory;

    @NotEmpty(message = "Model's processor should not be empty")
    private String modelProcessor;
    private Boolean modelAvailability;
}