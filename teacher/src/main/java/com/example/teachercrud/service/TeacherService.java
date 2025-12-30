package com.example.teachercrud.service;

import com.example.teachercrud.entity.Teacher;
import com.example.teachercrud.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> findAll() {
        return repo.findAll();
    }

    public void save(Teacher teacher) {
        repo.save(teacher);
    }

    public Teacher findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
