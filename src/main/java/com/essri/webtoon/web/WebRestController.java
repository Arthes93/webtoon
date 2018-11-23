package com.essri.webtoon.web;

import com.essri.webtoon.service.ToonService;
import com.essri.webtoon.web.data.Toons;
import com.essri.webtoon.web.dto.ToonsDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class WebRestController {

    private ToonService toonservice;

    @GetMapping("/test")
    public String test() {
        return "It's test!!!";
    }

    /**
     * Batch 작업으로 바꿀 메소드(웹툰 목록 파싱)
     * @return insert 된 데이터 @Batch 돌리는 형태로 바꿀거임
     */
    @RequestMapping(method = RequestMethod.POST, value="/insertData")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Toons> crawlData() {
        return toonservice.crawlData();
    }

    /**
     * 네이버 웹툰 리스트 불러오기
     * @return toons 테이블의 모든 행 @TEST용
     */
    @RequestMapping(method = RequestMethod.GET, value="/getList")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ToonsDTO.ListRes> getList() {
        return toonservice.getList();
    }

    /**
     * 웹툰 리스트 불러오기
     * @return toons 테이블 (model: ConvertWebToonLists)
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public HashMap<String, List<ToonsDTO.ConvertWebToonLists>> getConvertList() {
        return toonservice.convertList();
    }
}
