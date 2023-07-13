package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            for (String value : e.getValue()) {
                if (value.equals(developer)) {
                    list.add(e.getKey());
                }
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        list.sort(new MyComparator(""));

        return list;
    }
}

class MyComparator implements java.util.Comparator<String> {

    private final int referenceLength;

    public MyComparator(String reference) {
        super();
        this.referenceLength = reference.length();
    }

    public int compare(String s1, String s2) {
        int dist1 = Math.abs(s1.length() - referenceLength);
        int dist2 = Math.abs(s2.length() - referenceLength);

        return dist2 - dist1;
    }
}