# HomeWork 1

## 2. list the git commands you learned

`git init`

`git clone <url>`

`git status`

`git add <file>`

`git commit -m "Commit message"`

`git log`

`git log --follow <file>`

`git diff`

`git diff --staged`

## 3.  What is the basic steps to init a git repo in you local ?
- Create a New Directory for Your Project

    ```
      mkdir my_project
      cd my_project
    ```
- Initialize the Git Repository
  
    ```
  git init
  ```

- Stage Files for Commit
    ```
  git add <file_name>  # Add a specific file
  git add .            # Add all files in the directory
  ```
- Commit the Changes
  ```
  git commit -m "Initial commit"
    ```
## 4. How to clone a repo from Github ?
```
git clone <repo-url>
```
## 5. How to create a new branch and checkout to that branch ?
```
git checkout -b new-branch-name
```
## 6. How to merge the branch_test to master branch in command ?
```
git checkout master
git pull origin master
git merge branch_test
#resolve merge conflicts if any
git add <file-name>
git commit -m "Resolved merge conflicts"
git push origin master
```
## 7. Stash code
```
git checkout branch_learn_stash
git stash push -m "Description of what was stashed"
git checkout other_branch_name
git checkout branch_learn_stash
git stash pop
```
## 8. How do you understand PR is based on Branch?
The concept of a PR based on branching enables multiple developers to work on different aspects of a project simultaneously without interference. It facilitates peer reviews and discussions about the code, enhancing code quality and reducing the risk of bugs. Moreover, it helps in managing features and fixes in a controlled and organized manner.

## 9. What is maven role ? what it is used to do?
  Maven is a powerful project management tool used primarily for Java projects. It is used for:
  
  - Project Build Management
  - Dependency Management
  -  Standardization and Consistency
  - Simplifying the Build Process
  - Plugin-based Architecture
  - Project Documentation and Reporting
  - Continuous Integration and Deployment

## 10. What is the lifecycle of maven? could you tell me the details ?
- Maven Build Lifecycles
   Maven has three built-in lifecycles:

  Default: Handles project deployment.

  Clean: Handles project cleaning.

  Site: Manages the creation of the project's site documentation.

Each lifecycle consists of a series of phases that define the order in which the goals are executed.

## 11. What is the difference between package and install in maven lifecycle?
The package phase in Maven takes the compiled code and other resources, which include configuration files, assets, and more, and packages them into a distributable format, such as a JAR, WAR, or EAR file. This phase does not install anything in the local repository, meaning the package is not yet available to other projects on your local machine. The package created is merely stored in the target directory of your project.

The install phase in Maven takes the package generated in the package phase and installs it into the local Maven repository, which is usually located in a .m2 directory in the user's home directory. Once installed, the artifact becomes available to be used as a dependency in other Maven projects on the same machine.

## 12. What is plugins in maven, list some plugins.
In Maven, plugins are tools that provide specific tasks or goals that can be executed as part of the build process. Each plugin can execute one or several related tasks (goals), such as compiling code, running tests, or creating project documentation. Plugins allow for the customization and extension of the build process, enabling Maven to handle a wide variety of development, deployment, and automation tasks.

Commonly used Maven plugins: Maven Compiler Plugin, Maven Surefire Plugin, Maven Failsafe Plugin, Maven JAR Plugin, Maven WAR Plugin, Maven Clean Plugin, Maven Install Plugin, Maven Deploy Plugin, Maven Site Plugin, Maven Assembly Plugin. 

