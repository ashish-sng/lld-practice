package 02-design-patterns.creational.Builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final int age;
    private final String address;
    private final String profilePicUrl;
    private final String bio;
    private final String role;
    private final Boolean isVerified;

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

    public static class UserBuilder{
        //Required
        private final String firstName;
        private final String lastName;
        // Optional
        private final String email;
        private final String phone;
        private final int age;
        private final String address;
        private final String profilePicUrl;
        private final String bio;
        private final String role;
        private final Boolean isVerified;

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
        public UserBuilder isVerified(String isVerified){
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

        public User build(){
            return new User(this);
        }
    }


}

class Main {
    public static void main(String[] args){
        User User1 = new User.UserBuilder("Ashish", "Singh").addAge(10).build();

        User User2 = new User.UserBuilder("Ashish","Singh").build();

        System.out.println(User1 + " " + User2);
    }
}

// 3 problems:

// 1. Telescoping Constructor problem
// 2. Positional ambiguity / wrong order bugs
// 3. Immutability is impossible without Builder
