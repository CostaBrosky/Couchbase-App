package it.coachbase.service;

import it.coachbase.model.Task;
import it.coachbase.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Mono<Task> createTask(Task t) {
        return taskRepository.save(t);
    }

    @Override
    public Mono<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }
}
