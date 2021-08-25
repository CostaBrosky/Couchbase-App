package it.coachbase.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.util.List;

@Data
@Document
@Scope(value = "dev")
@Collection(value = "project")
public class Project {

    @Id
    private String id;
    private String name;
    private String code;

    @Field("desc")
    private String description;
    private String startDate;
    private String endDate;

    @Field("cost")
    private Long estimatedCost;
    private List<String> countyList;

    @Version
    private Long version;
}
