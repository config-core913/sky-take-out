package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    //根据菜品id查询对应的套餐id
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);


    //根据id修改套餐
    @AutoFill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    void insertBatch(List<SetmealDish> setmealDishes);

    @Delete("delete from setmeal_dish where setmeal_id = #{setmeal_id}")
    void deleteBySetmealId(Long setmealId);

    @Select("select * from setmeal_dish where id = #{id}")
    List<SetmealDish> getBySetmealId(Long id);
}
