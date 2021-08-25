package it.coachbase.repository;

import it.coachbase.model.Project;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface ProjectRepository extends ReactiveCouchbaseRepository<Project, String> {
}
