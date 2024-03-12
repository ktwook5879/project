package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.ParkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkMapper {
    public ParkDTO selectParkList(int seq)throws Exception;

    List<ParkDTO> getSearchList(ParkDTO parkDTO)throws Exception;

    List<ParkDTO> selectImage(int seq)throws Exception;
}
