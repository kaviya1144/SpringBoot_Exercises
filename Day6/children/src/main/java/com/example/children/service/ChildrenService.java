package com.example.children.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.children.model.Children;
import com.example.children.repository.ChildrenRepo;

@Service
public class ChildrenService {
    
    @Autowired
    private ChildrenRepo childrenRepo;

    public Children create(Children children) {
        return childrenRepo.save(children);
    }

    public Page <Children> childPagination(int offset,int pageSize){
        return childrenRepo.findAll(PageRequest.of(offset, pageSize));
    }

    public List<Children> childSort(String field){
        return childrenRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public List<Children> childPaginationSort(int offset,int pageSize,String field){
        PageRequest pageRequest = PageRequest.of(offset, pageSize,Sort.Direction.ASC,field);
        Page<Children> page = childrenRepo.findAll(pageRequest);
        return page.getContent();
    }
}
