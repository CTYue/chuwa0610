write your answer to this folder.

## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo  repo as example) Encapsulation; Polymorphism; Inheritance; 
```java
class Animal {
    private int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    //Encapsulation
    public int getWeight() {
        return weight;
    }

    //Encapsulation
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal{
    public Cat(int weight) {
        super(weight);
    }

    // Polymorphism
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(10);

        //Inheritance
        System.out.println(cat.getWeight());
    }
}
```

## 2.  What is wrapper class in Java and Why we need wrapper class? 
* Wrapper classes are objects that wrap around primitive data types in Java, for example int -> Integer, double -> Double
* Wrapper classes encapsulate primitive data types, provide useful utility methods such as toString(), and it also provide a way to handle null values.

## 3.  What is the difference between HashMap and HashTable?
|Hashmap|Hashtable|
|  ----  | ----  |
|No method is synchronized.|Every method is synchronized.|
|Multiple threads can operate simultaneously and hence hashmap’s object is not thread-safe.|At a time only one thread is allowed to operate the Hashtable’s object. Hence it is thread-safe.|
|Threads are not required to wait and hence relatively performance is high.|It increases the waiting time of the thread and hence performance is low.|
|Hashmap|Hashtable|
|Null is allowed for both key and value.|Null is not allowed for both key and value. Otherwise, we will get a null pointer exception.|

## 4.  What is String pool in Java and why we need String pool? 
* String pool is a special memory region in Java where String literals are stored.
* Memory Efficiency, Reduced Garbage Collection

## 5.  What is Java garbage collection?
* Java garbage collection is the process by which Java programs perform automatic memory management.

## 6.  What are access modifiers and their scopes in Java? 
* Default: visible within the same package.
* Public: available everywhere.
* Private: accessible from the same class only.
* Protected: accessible from the same package, as well as from all subclasses of its class.

## 7.  What is final key word? (Filed, Method, Class)
## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
## 9.  What is the differences between overriding and overloading?
## 10.  What is the differences between super and this?
## 11.  What is the Java load sequence?
## 12.  What is Polymorphism ? And how Java implements it ? 
## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 
## 14.  What is Interface and what is abstract class? What are the differences between them?
## 15.  design a parking lot (put the code to codingQuestions/coding1 folder, )
## 1.  If you have no ability to design it, please find the solution in internet, then understand it, and re-type 
## it.(Do NOT just copy and paste)
## 16.  What are Queue interface implementations and what are the differences and when to use what?




## 1.  Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
[ShortQuestions/README.md](README.md).

## 2. practice git using the platform. list the git commands you learned
* git commit
* git branch
* git checkout
* git merge
* git branch -f
* git reset
* git revert
* git cherry-pick
* git rebase
* git rebase -m
* git commit --amend
## 3.  What is the basic steps to init a git repo in you local ?
```
git init
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/username/repo.git
git push -u origin main
```
## 4.  How to clone a repo from Github ?
```
git clone <url>
```

## 5.  How to create a new branch and checkout to that branch ?
```
git branch <branchName>
git checkout <branchName>
```

## 6.  How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
```

## 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you  checkout back to **branch_learn_stash ? try commands way and intellij way.
### 1) command line
```
git stash
git checkout branch_learn_stash
git stash pop
```

### 2) intellij 
* Git | Uncommitted Changes | Stash Changes.
* checkout branch_learn_stash | Git | Uncommitted Changes | Unstash Changes | choose and apply stash.

## 8.  How do you understand PR is based on Branch?
* pr serves as a proposal to merge changes made in one branch of a repository into another

## 9.  What is maven role ? what it be used to do ?
* Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

## 10.  What is the lifecycle of maven? could you tell me the details ?
### 1) Clean
* pre-clean - execute processes needed prior to the actual project cleaning.
* clean - remove all files generated by the previous build.
* post-clean - execute processes needed to finalize the project cleaning.
### 2) prepare-resources
* ?
### 3) default
* validate - validate the project is correct and all necessary information is available
* compile - compile the source code of the project
* test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* package - take the compiled code and package it in its distributable format, such as a JAR.
* verify - run any checks on results of integration tests to ensure quality criteria are met
* install - install the package into the local repository, for use as a dependency in other projects locally
* deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

### 4) site
* pre-site - execute processes needed prior to the actual project site generation
* site - generate the project's site documentation
* post-site - execute processes needed to finalize the site generation, and to prepare for site deployment
* site-deploy - deploy the generated site documentation to the specified web server

## 11.  what is the difference between package and install in maven lifecycle ?
* package - take the compiled code and package it in its distributable format
* install - install the package into the local repository

## 12.  What is plugins in maven, list some plugins.
* Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects.
* maven-compiler-plugin, maven-surefire-plugin, maven-failsafe-plugin

## 13.  In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:1.  groupID: com.chuwa.learn  2.  artifactID: java-core 
[MavenProject](../MavenProject).

## 14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it
[My PR](https://github.com/Liam-Zhou/chuwa0610/pull/9)
