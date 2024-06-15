/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pemira.View;

/**
 *
 * @author Hp
 */
class User {
    private int age;
    private String name, nim, tingkat, kelas, email, candidate;
    
    private boolean hasVoted;

    
    
    public User(String name, String nim, int age, String tingkat, String kelas, String email, String candidate){
        this.name = name;
        this.age = age;
        this.nim = nim;
        this.tingkat = tingkat;
        this.email = email;
        this.kelas = kelas;
        this.candidate = candidate;
    }
    
    // Constructor, getters, and setters
    public User() {
        this.hasVoted = false;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
    
    public User(String candidate){
        this.candidate = candidate;
    }    
    
    public String getname(){
        return name;
    }

    public String getnim(){
        return nim;
    }

    public int getage(){
        return age;
    }

    public String gettingkat(){
        return tingkat;
    }

    public String getkelas(){
        return kelas;
    }

    public String getemail(){
        return email;
    }

    public String getcandidate(){
        return candidate;
    }
}
