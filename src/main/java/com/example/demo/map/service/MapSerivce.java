package com.example.demo.map.service;

import java.util.List;
import java.util.Map;

import com.example.demo.map.dto.ImageDto;
import com.example.demo.map.dto.MapDto;

public interface MapSerivce {
	List<MapDto> mapList();
	List<MapDto> mapDetailList(int seq);
	void mapDetailInsert(MapDto mapDetailDto);
	int maxAddressNo(int seq);
	int cnt (int seq);
	void mapDetailDelete(MapDto mapDetailDto);
	List<MapDto> mapReviewList(MapDto mapDetailDto);
	void mapReviewInsert(MapDto mapDetailDto);
	int maxReviewSeq(MapDto mapDetailDto);
	
	int insertImage(ImageDto imageDto);
	ImageDto findImage(int id);
	List<ImageDto> mapDetailImg(Map<String, Object> paramMap);
	MapDto mapDetailAll(Map<String, Object> paramMap);
}