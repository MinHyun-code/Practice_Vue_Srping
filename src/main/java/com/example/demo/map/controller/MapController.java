package com.example.demo.map.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.map.dto.ImageDto;
import com.example.demo.map.dto.MapDto;
import com.example.demo.map.service.MapServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MapController {
	private final MapServiceImpl mapService;
	
	// 데이터 조회
	@RequestMapping(method = RequestMethod.GET, value = "/api/map")
    public List<MapDto> mapList(){
		List<MapDto> mapDto = mapService.mapList();
        return mapDto;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/mapDetail")
    public List<MapDto> mapDetailList(@RequestParam int seq){
		List<MapDto> mapDetailDto = mapService.mapDetailList(seq);
        return mapDetailDto;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/mapDetail")
    public void mapDetailInsert(@RequestParam int seq, @RequestParam String user_id, @RequestParam String shop_nm, @RequestParam("file") List<MultipartFile> files,
    		@RequestParam String shop_call, @RequestParam String shop_address, @RequestParam String shop_intro) throws IOException {
		MapDto mapDetailDto = new MapDto();

		int maxAddressNo;
		int cnt = mapService.cnt(seq);
		if(cnt > 0) {
			maxAddressNo = mapService.maxAddressNo(seq);
		} else {
			maxAddressNo = 0;
		}
		
		mapDetailDto.setSeq(seq);
		mapDetailDto.setReg_user_id(user_id);
		mapDetailDto.setShop_nm(shop_nm);
		mapDetailDto.setShop_address(shop_address);
		mapDetailDto.setShop_call(shop_call);
		mapDetailDto.setShop_intro(shop_intro);
		mapDetailDto.setAddress_no(maxAddressNo);
		
		String dirName = "C:\\springworkspace\\Practice\\image\\" + seq + "_" + shop_nm + "\\info";
		String pathName = seq + "_" + shop_nm + "\\info";
		
        try{
            File folder = new File(dirName);
            ImageDto imageDto = new ImageDto();
            if (!folder.exists()) folder.mkdirs();

            for(MultipartFile image : files) {
                imageDto.setSeq(seq);
                imageDto.setAddress_no(maxAddressNo);
    	        imageDto.setMimetype(image.getContentType());
    	        imageDto.setOriginal_name(image.getOriginalFilename());
    	        imageDto.setData(pathName);
    	        mapService.insertImage(imageDto);                
    	        File destination = new File(dirName + File.separator + image.getOriginalFilename());
                image.transferTo(destination);
            }
        } catch (Exception e) {
			}
		mapService.mapDetailInsert(mapDetailDto);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/api/mapDetail")
    public void mapDetailDelete(@RequestParam int seq, @RequestParam String user_id, @RequestParam int address_no){
		MapDto mapDetailDto = new MapDto();
		mapDetailDto.setSeq(seq);
		mapDetailDto.setDel_user_id(user_id);
		mapDetailDto.setAddress_no(address_no);
		mapService.mapDetailDelete(mapDetailDto);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/mapReview")
    public List<MapDto> mapReviewList(@RequestParam int seq, @RequestParam int address_no){
		MapDto mapDetailDto = new MapDto();
		mapDetailDto.setSeq(seq);
		mapDetailDto.setAddress_no(address_no);
		List<MapDto> mapReviewList = mapService.mapReviewList(mapDetailDto);
        return mapReviewList;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/mapReview")
    public void mapReviewInsert(@RequestParam int seq, @RequestParam int address_no, @RequestParam String user_id, 
    		@RequestParam String review_title, @RequestParam String review_content){
		MapDto mapDetailDto = new MapDto();
		mapDetailDto.setSeq(seq);
		mapDetailDto.setAddress_no(address_no);
		
		int maxReviewSeq;
		int cnt = mapService.cnt(seq);
		if(cnt > 0) {
			maxReviewSeq = mapService.maxReviewSeq(mapDetailDto);
		} else {
			maxReviewSeq = 0;
		}
		
		
		mapDetailDto.setReview_title(review_title);
		mapDetailDto.setReview_content(review_content);
		mapDetailDto.setReview_seq(maxReviewSeq);
		mapDetailDto.setReg_user_id(user_id);
		mapService.mapReviewInsert(mapDetailDto);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/mapDetailAll")
    public Map<String, Object> mapDetailAll(@RequestParam int seq, @RequestParam int address_no){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seq", seq);
		paramMap.put("address_no", address_no);
		paramMap.put("mapDetailImg",mapService.mapDetailImg(paramMap));
		paramMap.put("mapDetailAll", mapService.mapDetailAll(paramMap));
        return paramMap;
    }
}