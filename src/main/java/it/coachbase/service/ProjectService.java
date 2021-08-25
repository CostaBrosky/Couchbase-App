package it.coachbase.service;

import it.coachbase.model.Project;
import reactor.core.publisher.Mono;

public interface ProjectService {

    Mono<Project> createProject(Project p);
}
