package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private static class Task {
        String text;
        boolean done;

        Task(String text) {
            this.text = text;
            this.done = false;
        }

        @Override
        public String toString() {
            return (done ? "[x] " : "[ ] ") + text;
        }
    }

    private final List<Task> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(new Task(item));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).done = true;
            return true;
        }
        return false;
    }

    public List<String> search(String substring) {
        List<String> results = new ArrayList<>();
        if (substring == null || substring.trim().isEmpty()) return results;
        String lower = substring.toLowerCase();
        for (Task t : items) {
            if (t.text.toLowerCase().contains(lower)) {
                results.add(t.toString());
            }
        }
        return results;
    }

    public List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (Task t : items) {
            result.add(t.toString());
        }
        return result;
    }

    public int size() {
        return items.size();
    }
}