package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Error;

public interface ChapterService {

    public Error addChapter(Chapter chapter);

    public Error deleteChapter(String id);
}
