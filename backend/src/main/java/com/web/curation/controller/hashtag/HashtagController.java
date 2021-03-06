package com.web.curation.controller.hashtag;

import com.web.curation.dto.hashtag.HashtagDto;
import com.web.curation.service.hashtag.HashtagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * com.web.curation.controller.hashtag
 * HashtagController.java
 * @date    2021-01-28 오후 12:45
 * @author  이주희
 *
 * @변경이력
 **/

@Api(tags = {"Hashtags"})
@CrossOrigin(origins = {"*"})
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/hashtags")
public class HashtagController {

    private final HashtagService hashtagService;

    @ApiOperation(value = "키워드로 해시태그 조회")
    @GetMapping("/{keyword}")
    public ResponseEntity<List<HashtagDto>> getHashtagByKeyword(@PathVariable("keyword") @Pattern(regexp = "^[a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]*$") String keyword){
        List<HashtagDto> hashtagDtos = hashtagService.findByContentsStartingWithIgnoreCase(keyword);
        return ResponseEntity.ok().body(hashtagDtos);
    }
}
