package com.example.children.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.children.model.Children;
import com.example.children.service.ChildrenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    @PostMapping("/api/children")
    public ResponseEntity<Children> createPatient(@RequestBody Children children) {
        try {
            Children created = childrenService.create(children);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<Children>> getSort(@PathVariable ("field") String field) {
        List<Children> li = childrenService.childSort(field);

        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    @GetMapping("/api/children/{offset}/{pageSize}")
    public ResponseEntity<List<Children>> getPage(@PathVariable ("offset") int offset,@PathVariable ("pageSize") int pageSize) {
        Page<Children> page = childrenService.childPagination(offset, pageSize);
        List<Children> li = page.getContent();
        
        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    @GetMapping("/api/children/{offset}/{pageSize}/{field}")
    public ResponseEntity<List<Children>> getPageSort(@PathVariable ("offset") int offset,@PathVariable ("pageSize") int pageSize,@PathVariable("field") String field) {
        List<Children> li = childrenService.childPaginationSort(offset, pageSize, field);
        
        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    
}
