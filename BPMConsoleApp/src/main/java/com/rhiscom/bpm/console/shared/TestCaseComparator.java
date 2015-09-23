package com.rhiscom.bpm.console.shared;

import java.util.Comparator;

import com.rhiscom.bpm.console.client.event.TestCaseEvent;

public class TestCaseComparator implements Comparator<TestCaseEvent> {
    @Override
    public int compare(TestCaseEvent o1, TestCaseEvent o2) {

	if (o1.getStateDate().compareTo(o2.getStateDate()) > 0) {
	    System.out.println("Date1 is after Date2");
	    return -1;
	}
	if (o1.getStateDate().compareTo(o2.getStateDate()) < 0) {
	    return -1;
	}
	if (o1.getStateDate().compareTo(o2.getStateDate()) == 0) {
	    return 0;
	}
	return 0;

	// return (o1.getId() > o2.getId() ? -1 : (o1.getId() == o2.getId() ? 0
	// : 1));
    }

}
