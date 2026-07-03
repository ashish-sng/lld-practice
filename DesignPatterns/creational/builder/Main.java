package DesignPatterns.creational.builder;

public class Main {
    public static void main(String[] args){
        User User1 = new User.UserBuilder("Ashish", "Singh").addAge(10).build();

        User User2 = new User.UserBuilder("Ashish", "Singh").addAge(10).addEmail("ashish@gmail.com").addPhone("84235676").build();

        User User3 = new User.UserBuilder("Ashish","Singh").isVerified(true).build();

        System.out.println(User1 + " " + User2 + " " + User3);
    }
}
