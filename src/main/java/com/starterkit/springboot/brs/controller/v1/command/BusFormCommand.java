package com.starterkit.springboot.brs.controller.v1.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class BusFormCommand {
    @NotBlank
    @Size(min = 4, max = 8)
    private String code;

    @Min(value = 10, message = "Cannot enroll a bus with capacity smaller than 10")
    private int capacity;

    @NotBlank
    private String make;
}
