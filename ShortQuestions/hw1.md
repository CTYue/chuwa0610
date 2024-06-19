# HW1

### 2. List the git commands you learned
- `git status`
- `git add`
- `git commit`
- `git checkout`
- `git pull`
- `git push`
- `git rebase`
- `git fetch`
- `git merge`


### 3. What is the basic steps to init a git repo in you local?

```bash
# creat directory for project
mkdir project
# go to the directory
cd project
# init git repo
git init 
```

### 4. How to clone a repo from Github?
- Copy repository url on Github
```bash
# go to your project directory 
cd project_directory
# clone remote repo url
git clone repository_url 
```

### 5. How to create a new branch and checkout to that branch?

```bash
# create a new branch
git checkout branch_name
# or create a new branch and go to that new branch
git checkout -b branch_name
```

### 6. How to merge the branch_test to master branch in command? show me the commands.

```bash
# go to main branch
git checkout main
# pull newest update from remote
git pull
# merge branch_test to main branch
git merge branch_test
# push local change to remote
git push
```

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

#### Using Git Stash in Command Line
```bash
# store local changes in branch named branch_learn_stash
git stash
# switch to another branch
git checkout another_branch_name
# switch back to branch_learn_stash
git checkout branch_learn_stash
# pop stored changes / stash
git stash pop
```

#### Using Git Stash in IntelliJ
- Menu bar `Git` -> `VCS Operations Popup` -> `Stash Changes`
- Add `Message` -> `Create Stash`
- Switch to other branch
- Switch back to branch `branch_learn_stash`
- Menu bar `Git` -> `VCS Operations Popup` -> `Unstash Changes` -> `Apply Stash`


### 8. How do you understand PR is based on Branch?
- PR, pull request is a request to merge your local changes in your branch to target branch.
- The branch that your PR selected, contains all local changes and commits, we could view all detailed changes of 
  each commit.

### 9. What is maven role? what it be used to do?
Maven is a powerful build automation tool which could simplify the process of building project, managing dependency and
configuration.

##### Maven is used for:
- **Simplified Build Process:** includes compiling code, running tests, packaging code into JAR files, deploying 
  application.
- **Dependency Management:** Use a `pom.xml` or `application.properties` file to manage dependencies, allow to 
  download libraries and dependencies automatically. This helps ensure that the correct versions of dependencies are used and reduces conflicts.
- **Continuous Integration:** Maven is used in continuous integration (CI) environments to automate the build, test and 
  deployment process. It integrates well with CI tools like Jenkins, Bamboo, and Travis CI.
- **Documentation:** Maven can generate project documentation based on the information in the POM file, including project reports, dependencies, and developer information.
 

### 10. What is the lifecycle of maven? could you tell me the details ?

1. **Validate**: Validates the project is correct and all necessary information is available.
2. **Compile**: Compiles the source code of the project.
3. **Test**: Tests the compiled source code using a suitable testing framework.
4. **Package**: Packages the compiled code into a distributable format, such as a JAR or WAR file.
5. **Verify**: Runs any checks to verify the package is valid and meets quality criteria.
6. **Install**: Installs the package into the local Maven repository, so it can be used as a dependency in other 
   projects locally.
7. **Deploy**: Copies the final package to the remote repository for sharing with other developers and projects.


### 11. What is the difference between package and install in maven lifecycle?

- `Package`: Creates JAR or WAR file for the project to convert it into a distributable format
- `Install`: Deploys the packaged JAR/ WAR file to the local repository.


### 12. What is plugins in maven, list some plugins.
Maven plugins are components that enhance Maven's capability to manage and build software projects. Plugins are executed during the build process and are configured in the `pom.xml` file of a Maven project. Each plugin is designed to perform specific tasks and can be tied to one or more phases of the Maven lifecycle.
- maven-antrun-plugin
- maven-compiler-plugin
- maven-jar-plugin
- maven-clean-plugin
- maven-install-plugin
- maven-deploy-plugin
- maven-site-plugin