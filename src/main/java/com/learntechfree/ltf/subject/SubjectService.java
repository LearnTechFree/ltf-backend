package com.learntechfree.ltf.subject;

import com.learntechfree.ltf.entity.Category;
import com.learntechfree.ltf.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> listSubjects() {

        return subjectRepository.findAll();
    }

    public List<Subject> finaAllSubjectsForCategory(Category category) {

        return (List<Subject>) category.getSubjects();
    }
}
