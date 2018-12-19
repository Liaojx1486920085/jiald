package com.baizhi.serviceImpl;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Resource
    private GuruDao guruDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Guru> selectGuru() {
        List<Guru> gurus = guruDao.selectGuru();
        return gurus;
    }
}
