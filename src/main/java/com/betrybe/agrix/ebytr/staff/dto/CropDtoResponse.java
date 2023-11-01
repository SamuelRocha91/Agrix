package com.betrybe.agrix.ebytr.staff.dto;

import java.time.LocalDate;

/**
 * Customiza a resposta ao cliente quanto Às plantações.
 *
 * @param id Long.
 * @param name String.
 * @param plantedArea Double.
 * @param farmId Long.
 */
public record CropDtoResponse(Long id, String name, Double plantedArea,
                              Long farmId, LocalDate plantedDate, LocalDate harvestDate) {
}