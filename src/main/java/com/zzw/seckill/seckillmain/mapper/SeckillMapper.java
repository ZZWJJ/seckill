package com.zzw.seckill.seckillmain.mapper;

import com.zzw.seckill.seckillmain.entity.Seckill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 秒杀库存表 Mapper 接口
 * </p>
 *
 * @author zzw
 * @since 2020-03-25
 */
@Mapper
public interface SeckillMapper extends BaseMapper<Seckill> {

}
