package com.example.demo.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.deptDao;
import com.example.demo.model.deptModel;
import com.example.demo.service.deptService;
import org.springframework.stereotype.Service;

@Service
public class deptServiceImpl extends ServiceImpl<deptDao, deptModel> implements deptService {
}
