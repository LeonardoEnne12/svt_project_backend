package com.devsuperior.sam.entity;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SAM_ECOMPSUBJECTS")
public class SubjectsEcompEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSUBJECTS")
    private Long subjectId;

    @Column(name = "CURRICULARUNIT", unique = true)
    private String curricularUnit;

    @Column(name = "WORKLOAD")
    private Integer workload;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "SUBJECT_PREREQUISITES", joinColumns = @JoinColumn(name = "IDSUBJECTS"))
    @Column(name = "PREREQUISITE")
    private List<String> preRequisites;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "SUBJECT_POSITIONS", joinColumns = @JoinColumn(name = "IDSUBJECTS"))
    @Column(name = "POSITION")
    private List<Integer> position;

    @Column(name = "CREDIT")
    private Integer credit;

    // Getters and setters

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getCurricularUnit() {
        return curricularUnit;
    }

    public void setCurricularUnit(String curricularUnit) {
        this.curricularUnit = curricularUnit;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public List<String> getPreRequisites() {
        return preRequisites;
    }

    public void setPreRequisites(List<String> preRequisites) {
        this.preRequisites = preRequisites;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
