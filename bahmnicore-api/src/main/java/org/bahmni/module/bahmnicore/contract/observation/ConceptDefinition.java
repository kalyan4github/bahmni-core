package org.bahmni.module.bahmnicore.contract.observation;

import org.openmrs.Concept;

import java.util.ArrayList;
import java.util.List;

public class ConceptDefinition {
    private List<ConceptData> concepts = new ArrayList<>();

    public void add(ConceptData conceptData) {
        concepts.add(conceptData);
    }

    public void addAll(List<ConceptData> conceptDatas) {
        concepts.addAll(conceptDatas);
    }

    public int getSortWeightFor(Concept observationConcept) {
        int sortWeight = 1;
        for (ConceptData aConcept : concepts) {
            if (aConcept.getName().equalsIgnoreCase(observationConcept.getName().getName())) {
                return sortWeight;
            } else {
                sortWeight++;
            }
        }
        return -1;
    }

    public int size() {
        return concepts.size();
    }

    public List<ConceptData> getConcepts() {
        return concepts;
    }

    public String rootConceptFor(String childConceptName) {
        for (ConceptData conceptData : concepts) {
            if (conceptData.getName().equalsIgnoreCase(childConceptName)) {
                return conceptData.getRootConcept();
            }
        }
        return null;
    }
}
