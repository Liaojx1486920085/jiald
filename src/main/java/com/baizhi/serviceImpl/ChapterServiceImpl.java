package com.baizhi.serviceImpl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Error;
import com.baizhi.service.ChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterDao chapterDao;

    @Override
    public Error addChapter(Chapter chapter) {
        chapter.setCreateTime(new Date());
        chapter.setTimes("1");
        chapter.setId(UUID.randomUUID().toString());
        try {
            chapterDao.addChapter(chapter);
            return new Error("14", "添加音乐成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Error("15", "添加音乐失败");
        }
    }

    @Override
    public Error deleteChapter(String id) {
        try {
            chapterDao.deleteChapter(id);
            return new Error("16", "删除音乐成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Error("16", "删除音乐成功");
        }
    }
}
