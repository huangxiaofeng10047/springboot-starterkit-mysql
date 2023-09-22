package com.starterkit.springboot.brs.controller.v1.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
public class TripFormCommand {
    @NotBlank
    private String sourceStop;

    @NotBlank
    private String destinationStop;

    @NotBlank
    private String busCode;

    @Positive
    private int tripDuration;

    @Positive
    private int tripFare;
}
