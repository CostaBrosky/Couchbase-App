package it.coachbase.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

@Data
@Document
@Scope(value = "dev")
@Collection(value = "task")
public class Task {

    @Id
    private String id;

    @Field("pid")
    private String projectId;
    private String name;

    @Field("desc")
    private String description;
    private String ownername;
    private Long cost;

    @Version
    private Long version;
}
