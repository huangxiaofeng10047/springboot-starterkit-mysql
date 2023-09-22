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
public class ProfileFormCommand {
    @NotBlank
    @Size(min = 1, max = 40)
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 13)
    private String mobileNumber;
}
