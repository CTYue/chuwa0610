# HW1

1. Git command I learned

    ```jsx
    git init
    git clone
    git add
    git status
    git commit
    git push
    git stash
    git merge
    git rebase
    git fetch
    git push
    ```

2. Basic steps to init a git repo

    ```bash
    mkdir demo
    cd demo
    git init
    git add .
    git commit -m "create repo"
    git remote add origin <url>
    git push -u origin main
    ```

3. Clone a repo from github

    ```bash
    git clone <url>
    ```

4. Create a new branch and checkout to that branch

    ```bash
    git branch <name>
    git checkout <name>
    ```

5. How to merge the branch_test to master branch in command ?

    ```bash
    git checkout master
    git pull
    git merge branch_test
    git add . //if conflict
    git commit "resolve conflict" //if conflict
    git push
    ```

6. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way

   Git:

    ```bash
    git stash push -m "stash changes"
    git checkout <another-branch-name>
    git checkout <branch-name>
    git stash pop
    ```

   intellij:
   VCS -> Git → stash changes

   switch branch

   VCS -> Git → unstash changes

7. How do you understand PR ****is ****based ****on ****Branch?

   Git is a distributed version control system, every branch is isolate. The pull request operation is between branches, it will compare the updates and update the target branch without changing other branches.

8. What is maven role ? what it be used to do ?

   Maven is a dependency management and build tool of Java, like npm of Javascript. Maven can manage the dependencies. it will download the required libraries from central repo. Maven can compile source code into binary code and package code into JAR/WAR etc.Maven can manage the lifecycle of project, intergrates with CICD tools, standardizing and structuring project.

9. What is the lifecycle of maven? could you tell me the details ?

   The lifecycle of Maven is prepare-resource, validate, compile, test, package, install, and deploy.

   In prepare-resource stage and validate stages, maven will checks whether all necessary information for the build is available and whether the project structure is correct.

   In compile stage, Maven will compile the source code of the project (src/main/java) into the target directory.

   In test stage, Maven will test and compiled source code  using a suitable testing framework.

   At package stage, Maven creates the JAR/WAR package as mentioned in POM.xml

   At install stage, Maven install packages in local/remote maven repo

   At deploy stage, Maven copies the final package to the remote repository for sharing with other developers and projects.

10. what is the difference between package and install in maven lifecycle ?

    The goal of package phase is compiled the code and other resource and package them into a distributable format, like JAR, WAR etc, the install stage install the generated packages into local Maven repo. Installing an artifact here makes it available for use as a dependency in other projects that are built on the same machine.

11. What is plugins in maven, list some plugins.

    Maven build tool can executed a collections of plugins, each plugins is designed for a specific tasks, such as compiling code, packaging binaries etc.

    Maven Compiler Plugin

    Maven Surefire Plugin

    Maven WAR Plugin

    Maven Clean Plugin

    Maven Install Plugin

    Maven Deploy Plugin