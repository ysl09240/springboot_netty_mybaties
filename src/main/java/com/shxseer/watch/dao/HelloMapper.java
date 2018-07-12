package com.shxseer.watch.dao;

import com.shxseer.watch.vo.DrugStoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value ="helloMapper")
public interface HelloMapper {


    DrugStoreVo findDrugStore(String id);
}
