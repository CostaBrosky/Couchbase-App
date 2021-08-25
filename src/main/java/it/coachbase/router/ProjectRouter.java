package it.coachbase.router;

import it.coachbase.component.ProjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class ProjectRouter {

    @Bean
    public RouterFunction<ServerResponse> routeProject(ProjectHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/project/create"), handler::createProject)
                .andRoute(RequestPredicates.POST("/task/createTask"), handler::createTask);
    }
}
