package it.coachbase.repository;

import it.coachbase.model.Task;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface TaskRepository extends ReactiveCouchbaseRepository<Task, String> {
}
