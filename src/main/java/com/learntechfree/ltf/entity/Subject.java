package com.learntechfree.ltf.entity;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String universities ;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @OneToMany(mappedBy = "subject")
    private Set<Unit> units;

}
