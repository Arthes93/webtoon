package com.essri.webtoon.liketoon;

import com.essri.webtoon.user.UsersDTO;
import com.essri.webtoon.web.dto.BaseRestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.essri.webtoon.web.dto.BaseRestResponse.success;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/likeToon")
public class LikeToonApi {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity getConvertList(@Valid @RequestBody LikeToonDto.LikeToonReq req, @RequestHeader(value="userId") long userId) {
        LikeToonDto.builder().userId(userId).toonCode(req.getToonCode()).build();
        return BaseRestResponse.success("success");
    }

}