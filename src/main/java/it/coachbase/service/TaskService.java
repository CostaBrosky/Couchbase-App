package it.coachbase.service;

import it.coachbase.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {

    Mono<Task> createTask(Task t);
    Mono<Task> findById(String id);
    Flux<Task> findAll();
}
