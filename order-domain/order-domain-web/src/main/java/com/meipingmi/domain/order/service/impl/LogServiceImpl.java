package com.meipingmi.domain.order.service.impl;

import com.meipingmi.domain.order.entity.LogDO;
import com.meipingmi.domain.order.mapper.LogMapper;
import com.meipingmi.domain.order.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogDO> implements LogService {

}
