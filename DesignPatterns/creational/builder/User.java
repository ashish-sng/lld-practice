package DesignPatterns.creational.builder;


public class User {
    private final String firstName;
    private final String lastName;
    private String email;
    private String phone;
    private int age;
    private String address;
    private String profilePicUrl;
    private String bio;
    private String role;
    private Boolean isVerified;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName; 
        this.age = builder.age;  
        this.email = builder.email;  
        this.phone = builder.phone;  
        this.address = builder.address;  
        this.profilePicUrl = builder.profilePicUrl;  
        this.bio = builder.bio;  
        this.role = builder.role;  
        this.isVerified = builder.isVerified;  
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isVerified=" + isVerified +
                "}";
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

    public String getPhone() {
        return phone;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getProfilePicUrl() {
        return profilePicUrl;
    }
    
    public String getBio() {
        return bio;
    }
    
    public String getRole() {
        return role;
    }
    
    public Boolean isVerified() {
        return isVerified;
    }
    
    public static class UserBuilder{
        //Required
        private final String firstName;
        private final String lastName;
        // Optional
        private String email;
        private String phone;
        private int age;
        private String address;
        private String profilePicUrl;
        private String bio;
        private String role;
        private boolean isVerified;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;   
        }
        

        public UserBuilder addAge(int age){
            this.age = age;
            return this;
        }
        public UserBuilder addEmail(String email){
            this.email = email;
            return this;
        }
        public UserBuilder addPhone(String phone){
            this.phone = phone;
            return this;
        }
        public UserBuilder addProfileUrl(String profilePicUrl){
            this.profilePicUrl = profilePicUrl;
            return this;
        }
        public UserBuilder addBio(String bio){
            this.bio = bio;
            return this;
        }
        public UserBuilder isVerified(boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }
        public UserBuilder addAddress(String address){
            this.address = address;
            return this;
        }
        public UserBuilder addRole(String role){
            this.role = role;
            return this;
        }

        public User build() {
            if (this.isVerified && this.email == null) {
                throw new IllegalStateException("Email is required for verified users");
            }
            return new User(this);
        }
    }
}
