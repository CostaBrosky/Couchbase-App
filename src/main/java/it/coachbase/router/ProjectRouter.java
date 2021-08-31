package it.coachbase.router;

import it.coachbase.component.ProjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class ProjectRouter {

    @Bean
    public RouterFunction<ServerResponse> routeProject(ProjectHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/project/create"), handler::createProject)
                .andRoute(RequestPredicates.POST("/task/createTask"), handler::createTask)
                .andRoute(RequestPredicates.GET("/project/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findProjectById)
                .andRoute(RequestPredicates.GET("/project/findAll")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findAllProject)
                .andRoute(RequestPredicates.GET("/task/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findTaskById)
                .andRoute(RequestPredicates.GET("/task/findAll")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findAllTask);
    }
}
