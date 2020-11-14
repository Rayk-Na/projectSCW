package com.offcn.project.service.impl;

import com.offcn.project.mapper.*;
import com.offcn.project.po.*;
import com.offcn.project.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.statements.ProfileValueChecker;

import java.util.List;
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    private TReturnMapper returnMapper;

    @Autowired
    private TProjectMapper projectMapper;

    @Autowired
    private TProjectImagesMapper projectImagesMapper;

    @Autowired
    private TTagMapper tagMapper;

    @Autowired
    private TTypeMapper typeMapper;

    /**
     * 获取项目回报列表
     *
     * @param projectId
     * @return
     */
    @Override
    public List<TReturn> getProjectReturns(Integer projectId) {
        TReturnExample example = new TReturnExample();
        example.createCriteria().andProjectidEqualTo(projectId);
        return returnMapper.selectByExample(example);
    }

    /**
     * 获取系统中所有项目
     *
     * @return
     */
    @Override
    public List<TProject> getAllProjects() {
        return projectMapper.selectByExample(null);
    }

    /**
     * 获取项目图片
     *
     * @param id
     * @return
     */
    @Override
    public List<TProjectImages> getProjectImages(Integer id) {
        TProjectImagesExample example = new TProjectImagesExample();
        example.createCriteria().andProjectidEqualTo(id);
        return projectImagesMapper.selectByExample(example);
    }

    @Override
    public TProject getProjectInfo(Integer projectId) {
        return null;
    }

    @Override
    public List<TTag> getAllProjectTags() {

        return tagMapper.selectByExample(null);
    }

    @Override
    public List<TType> getProjectTypes() {
        return typeMapper.selectByExample(null);
    }

    /**
     * 获取回报信息
     *
     * @param returnId
     * @return
     */
    @Override
    public TReturn getReturnInfo(Integer returnId) {
        return returnMapper.selectByPrimaryKey(returnId);
    }
}
