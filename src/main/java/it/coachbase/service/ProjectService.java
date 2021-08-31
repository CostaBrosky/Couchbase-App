package it.coachbase.service;

import it.coachbase.model.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {

    Mono<Project> createProject(Project p);
    Mono<Project> findById(String id);
    Flux<Project> findAll();
}
