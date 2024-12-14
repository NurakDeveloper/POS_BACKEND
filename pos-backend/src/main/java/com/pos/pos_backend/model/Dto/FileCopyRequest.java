package com.pos.pos_backend.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileCopyRequest {
    private String imagePathFromMachine;
    private String copyToFolderpath;
}
