package com.bts.apicompositionmicroservice.rest.nft;

import com.bts.apicompositionmicroservice.dto.NftDto;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bts-nft", url = "http://localhost:8080", fallbackFactory = NftFeignClientFallbackFactory.class)
public interface NftFeignClient {
    @GetMapping("/api/findnft/{nftId}")
    public NftDto findNft(@PathVariable String nftId) throws Exception;
}

@Component
class NftFeignClientFallbackFactory implements FallbackFactory<NftFeignClient> {
    @Override
    public NftFeignClient create(Throwable cause) {
        return new NftFeignClient() {
            @Override
            public NftDto findNft(String nftId) throws Exception {
                throw new Exception(cause.getMessage());
            }
        };
    }
}