package com.unbm.andrei.ntviewer.models;

/**
 * Created by Andrei on 8/27/2017.
 */

public class ProblemReportTranslator {

    private static final String EQ_INSTALL_STRING = "Equipment Install";
    private static final String DEC_ISP_STRING = "Decommissioning ISP's equipment";
    private static final String DEC_SUB_STRING = "Decommissioning subscriber's equipment";
    private static final String DERANGEMENT_MALFUNCTION_STRING = "Derangement/Malfunction";
    private static final String NEW_CONTRACT_STRING = "New contract";
    private static final String PRIORITY_BLOCKED = "Blocked";
    private static final String PRIORITY_URGENT = "Urgent";
    private static final String PRIORITY_HIGH = "High";
    private static final String PRIORITY_LOW = "Low";


    public static String problemTypeToString(@ProblemType int problemType) {
        switch (problemType) {
            case ProblemType.PROBLEM_TYPE_EQUIPMENT_INSTALL:
                return EQ_INSTALL_STRING;
            case ProblemType.PROBLEM_TYPE_DECOMISSION_ISP_EQ:
                return DEC_ISP_STRING;
            case ProblemType.PROBLEM_TYPE_DECOMISSION_SUB_EQ:
                return DEC_SUB_STRING;
            case ProblemType.PROBLEM_TYPE_MALFUNCTION:
                return DERANGEMENT_MALFUNCTION_STRING;
            case ProblemType.PROBLEM_TYPE_NEW_CONTRACT:
                return NEW_CONTRACT_STRING;
            default:
                return "Unknown";
        }
    }

    public static String priorityTypeToString(@PriorityType int priorityType) {
        switch (priorityType) {
            case PriorityType.PRIORITY_BLOCKED:
                return PRIORITY_BLOCKED;
            case PriorityType.PRIORITY_URGENT:
                return PRIORITY_URGENT;
            case PriorityType.PRIORITY_HIGH:
                return PRIORITY_HIGH;
            case PriorityType.PRIORITY_LOW:
                return PRIORITY_LOW;
            default:
                return "Unknown";
        }
    }

}
