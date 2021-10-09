package com.bts.apicompositionmicroservice.controller;

import com.bts.apicompositionmicroservice.dto.NftDto;
import com.bts.apicompositionmicroservice.service.CompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompositionController {
    private final CompositionService compositionService;

    @GetMapping("findnft/{nftId}")
    public NftDto findNft(@PathVariable String nftId) throws Exception {
        return compositionService.findNftByNftId(nftId);
    }
}
