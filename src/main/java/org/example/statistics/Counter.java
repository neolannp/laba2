package org.example.statistics;

import java.util.ArrayList;

public interface Counter {
    void count();
    String getName();
    ArrayList<?> getTotal();
}
