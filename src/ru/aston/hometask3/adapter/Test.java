package ru.aston.hometask3.adapter;

public class Test {
    public static void main(String[] args) {
        MediaAdapter adapter = new MediaAdapter();
        try {
            adapter.play("1.wav");
            System.out.println("Test successful. No exceptions");
        } catch (Exception e) {
            System.out.println("Test failed with exception " + e.getMessage());
        }

        try {
            adapter.play("2.mp3");
            System.out.println("Test successful. No exceptions");
        } catch (Exception e) {
            System.out.println("Test failed with exception " + e.getMessage());
        }

        try {
            adapter.play("3.flv");
            System.out.println("Test failed. Was expecting exception.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test successful. Expected exception " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Test failed with exception " + e.getMessage());
        }

        try {
            adapter.play("4.mp4");
            System.out.println("Test successful. No exceptions");
        } catch (Exception e) {
            System.out.println("Test failed with exception " + e.getMessage());
        }
    }
}
