package it.coachbase.service;

import it.coachbase.model.Project;
import it.coachbase.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Mono<Project> createProject(Project p) {
        return projectRepository.save(p);
    }
}
