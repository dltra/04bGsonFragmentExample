package com.example.gsonfragmentexample;

public class Data {
    public SampleData[] list_data;
    private int i=-1;
    public SampleData getNextSample() {
        return list_data[(++i)%list_data.length];
    }
    public class SampleData {
        public int itemNumber;
        public String description;
        public int quantity;
        @Override
        public String toString() {
            return "SampleData{" +
                    "itemNumber=" + itemNumber +
                    ", description='" + description + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
