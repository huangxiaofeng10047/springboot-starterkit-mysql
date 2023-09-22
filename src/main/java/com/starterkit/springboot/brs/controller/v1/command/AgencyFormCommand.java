package com.starterkit.springboot.brs.controller.v1.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;



/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class AgencyFormCommand {
    @NotBlank
    @Size(min = 5, max = 100)
    private String agencyName;

    @NotBlank
    @Size(max = 100)
    private String agencyDetails;
}
