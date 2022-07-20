package com.example.demo.map.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.map.dao.MapMapper;
import com.example.demo.map.dto.ImageDto;
import com.example.demo.map.dto.MapDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapSerivce {
	private final MapMapper mapMapper;
	
	@Override
	public List<MapDto> mapList() {
		return mapMapper.mapList();
	}

	@Override
	public List<MapDto> mapDetailList(int seq) {
		return mapMapper.mapDetailList(seq);
	}

	@Override
	public void mapDetailInsert(MapDto mapDetailDto) {
		mapMapper.mapDetailInsert(mapDetailDto);
	}

	@Override
	public int maxAddressNo(int seq) {
		return mapMapper.maxAddressNo(seq);
	}

	@Override
	public int cnt(int seq) {
		return mapMapper.cnt(seq);
	}

	@Override
	public void mapDetailDelete(MapDto mapDetailDto) {
		mapMapper.mapDetailDelete(mapDetailDto);
	}

	@Override
	public List<MapDto> mapReviewList(MapDto mapDetailDto) {
		return mapMapper.mapReviewList(mapDetailDto);
	}

	@Override
	public void mapReviewInsert(MapDto mapDetailDto) {
		mapMapper.mapReviewInsert(mapDetailDto);
	}

	@Override
	public int maxReviewSeq(MapDto mapDetailDto) {
		return mapMapper.maxReviewSeq(mapDetailDto);
	}

	@Override
	public int insertImage(ImageDto imageDto) {
		return mapMapper.insertImage(imageDto);
	}

	@Override
	public ImageDto findImage(int id) {
		return mapMapper.findImage(id);
	}

	@Override
	public List<ImageDto> mapDetailImg(Map<String, Object> paramMap) {
		return mapMapper.mapDetailImg(paramMap);
	}

	@Override
	public MapDto mapDetailAll(Map<String, Object> paramMap) {
		return mapMapper.mapDetailAll(paramMap);
	}
}