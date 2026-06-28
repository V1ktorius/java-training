package ru.aston.hometask3.builder;

public final class User {
    public enum Gender {
        Male,
        Female
    }

    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final int age;
    private final boolean active;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.gender = builder.gender;
        this.age = builder.age;
        this.active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private Gender gender;
        private int age;
        private boolean active;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public boolean getActivityStatus() {
        return active;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age + ", " + gender + ", " + email;
    }
}
