# **Short questions homework1 - MingHao Lee**

1. **Learn Markdown and show all of basic usage in the ShortQuestions/README.md**
   - Refer to shortQuestions/README.md for markdown knowledge.

2. **Practice git using the platform. List the git commands you learned**
   - Use [Learn Git Branching](https://learngitbranching.js.org/)
   
   - **Git Commands Learned:**
     - `git init`: Initialize a new Git repository
     - `git clone URL`: Clone a repository from a URL
     - `git branch branch_name`: Create a new branch
     - `git checkout branch_name`: Switch to a branch
     - `git merge branch_name`: Merge a branch into the current branch
     - `git stash`: Stash changes    
     - `git stash pop`: Apply stashed changes
     - `git touch`: Create a new empty file and add it to the repository


3. **What are the basic steps to initialize a git repo in your local?**
   - Navigate to your project's directory then initialize a git repository:
     ```bash
     cd /path/to/your/project
     git init
     ```

4. **How to clone a repo from GitHub?**
   - Use the `git clone` command followed by the repository URL:
     ```bash
     git clone https://github.com/username/repository.git
     ```
5. **How to create a new branch and checkout to that branch?**
   - Use the `git branch` command to create a new branch and `git checkout` command to switch to the new branch
     ```bash
     git branch name_of_your_branch
     git checkout name_of_your_branch
     ```
   - Alternatively, use the `git checkout -b` command to create and switch to a new branch in one step:
     ```bash
     git checkout -b name_of_your_branch
     ```
6. **How to merge the branch _test_ to master branch in command? Show me the commands.**
   - Switch to the `master` branch:
     ```bash
     git checkout master
     ```
   - Merge the `_test_` branch into the `master` branch:
     ```bash
     git merge _test_
     ```
7. **How to stash your new code before leaving branch `branch_learn_stash` and pop your stash when you checkout back to `branch_learn_stash`? Try commands way and IntelliJ way.**

   - **Command Line Way:**
     1. Stash your changes and checkout to another branch:
        ```bash
        git stash
        git checkout another_branch
        ```
     2. Checkout back to `branch_learn_stash` and pop the stashed changes:
        ```bash
        git checkout branch_learn_stash
        git stash pop
        ```

   - **IntelliJ Way:**
     1. **Stash your changes:**
        - Go to `VCS` in the top menu.
        - Select `Git` and then `Stash Changes`.
        - Provide a stash message and click `Stash`.

     2. **Checkout to another branch:**
        - Go to `VCS` in the top menu.
        - Select `Git` and then `Branches`.
        - Select the branch you want to checkout to and click `Checkout`.

     3. **Checkout back to `branch_learn_stash`:**
        - Go to `VCS` in the top menu.
        - Select `Git` and then `Branches`.
        - Select `branch_learn_stash` and click `Checkout`.

     4. **Pop the stashed changes:**
        - Go to `VCS` in the top menu.
        - Select `Git` and then `Unstash Changes`.
        - Select the stash you want to apply and click `Apply`.
8. **How do you understand PR is based on Branch?**
   - A Pull Request (PR) is a request to merge changes from one branch into another branch, typically from a feature branch into the main branch.
    It allows developers to review the changes, discuss potential modifications, and ensure the code meets the project's standards before merging.
   Each PR is tied to a specific branch, and the changes proposed in the PR are based on the commits made in that branch.

9. **What is Maven's role? What is it used to do?**
   - **Maven's Role**: Maven is a build automation and project management tool mostly used for Java projects.
    It simplifies the build process and provides a standard way to manage a project's dependencies, build, and documentation.

   - **What it is used to do**:
     - **Dependency Management**: Easily add and remove dependencies/libraries through a centralized `pom.xml` file.
     - **Build Management**: Compile, package, and deploy your project using predefined lifecycles.
     - **Documentation**: Automatically generate project documentation based on the source code and configuration.
     - **Reporting**: Integrate with CI/CD pipelines to generate reports on test results, code coverage, and other metrics.
     - **Project Configuration**: Maintain consistent project configurations across multiple projects.
     - **Plugins**: Extend the functionality of Maven through plugins for various tasks like testing, packaging, and deployment.
    
10. **What is the lifecycle of Maven? Could you tell me the details?**

     - The Maven lifecycle consists of a series of build phases that define the steps to build and deploy a project. Key phases include:

        - **Validate**: Check if the project is correct and all necessary information is available.
        - **Compile**: Compile the source code.
        - **Test**: Run unit tests.
        - **Package**: Package the compiled code into a distributable format, such as a JAR.
        - **Verify**: Run checks on the results of integration tests to ensure quality.
        - **Install**: Install the package into the local repository for use in other projects.
        - **Deploy**: Deploy the package to a remote repository for sharing with other developers.



11. **What is the difference between `package` and `install` in Maven lifecycle?**

   - **Package**: This phase takes the compiled code and packages it into a distributable format, such as a JAR or WAR file.
     It is designed to create the final artifact that can be distributed.
     
   - **Install**: This phase takes the packaged artifact and installs it into the local Maven repository.
     This makes the artifact available for use as a dependency in other projects on the same machine.

12. **What are plugins in Maven? List some plugins.**

   - Plugins in Maven are used to perform specific tasks during the build process. They are an integral part of the build lifecycle and provide the functionality to compile code, run tests, package artifacts, deploy applications, and more.

   - **Examples of Maven Plugins**:
     - **maven-compiler-plugin**: Compiles the project's source code.
     - **maven-jar-plugin**: Creates a JAR file from the compiled code.
     - **maven-war-plugin**: Packages the web application into a WAR file.
     - **maven-dependency-plugin**: Analyzes and manipulates dependencies.

13. **In Repo/MavenProject directory, create a Maven Module using IntelliJ, named as follows:**
   - **groupID**: com.chuwa.learn
   - **artifactID**: java-core

     ### Steps to Create a Maven Module in IntelliJ:
     1. Open IntelliJ and navigate to the `Repo/MavenProject` directory.
     2. Go to `File` > `New` > `Module`.
     3. Select `Maven` from the list of module types and click `Next`.
     4. Enter the following details:
        - **GroupID**: com.chuwa.learn
        - **ArtifactID**: java-core
     5. Click `Next` and then `Finish`.
     6. IntelliJ will create the new Maven module with the specified `groupID` and `artifactID`.

14. **Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.**



      






