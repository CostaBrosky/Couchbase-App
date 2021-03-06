package it.coachbase.component;

import it.coachbase.model.Project;
import it.coachbase.model.Task;
import it.coachbase.service.ProjectService;
import it.coachbase.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProjectHandler {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    public Mono<ServerResponse> createProject(ServerRequest serverRequest) {
        final Mono<Project> project = serverRequest.bodyToMono(Project.class);

        return project.flatMap(projectService::createProject)
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data));
    }

    public Mono<ServerResponse> createTask(ServerRequest serverRequest) {
        final Mono<Task> task = serverRequest.bodyToMono(Task.class);

        return task.flatMap(taskService::createTask)
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data));
    }

    public Mono<ServerResponse> findProjectById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return projectService.findById(id)
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAllProject(ServerRequest serverRequest) {
        return projectService.findAll().collectList()
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data));
    }

    public Mono<ServerResponse> findTaskById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        return taskService.findById(id)
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAllTask(ServerRequest serverRequest) {
        return taskService.findAll().collectList()
                .flatMap(data -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(data));
    }
}
