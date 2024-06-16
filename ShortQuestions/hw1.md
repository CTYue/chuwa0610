## Git
### how to init a git repo in local?
```bash
cd path/to/your/working/dir
git init
```
### how to clone a repo from github?
```bash
git clone <http-link>
```
### how to create a new branch and checkout to that branch?
```bash
git checkout -b new_branch
```
### how to merge the branch_test to master branch?
```bash
git checkout master 
git merge branch_test // solve the conflicts 
git commit
```
### how to stash your code before leaving branch branch_leave_stash and pop your stash after checkout back to branch_leave_stash?
```bash
git stash -m "save the change not reday to commit"
git checkout other_branch
...
git checkout branch_leave_stash
git stash pop
```
when to use git stash?
1. Switching to another branch
2. Pulling updates from a remote repository without committing the current changes
3. Resetting your working directory to a clean state
4. working on an urgent bug on a different branch then return to your original work

### Why PR (pull request) is based on Branch?
PR aka pull request, is used on collaborative platform like GitHub, GitLab. 
```text
propose the changes from one branch(source branch) to another branch(target branch).
team members can review the changes, leave comments, give suggestions.
require at least one approval before merging.
once PR is reviewed and approved, the change can be merged to the target branch. 
(Automatically done by platform if there's no conflicts. )
```

## Maven
### What is maven role? What it be used to do?
role:
```text
1. manage dependencies. 'pom.xml'
2. build project: automates compiling source code, running test, packaging compiled code, deploying the package code.
3. documentation & reporting (dependencies, code coverage, test results)
```

### what is the lifecycle of maven?
prepare resources -> validate -> compile -> test -> package -> install -> deploy
```text
prepare resources: resources copying
validate: validate the project/information
```

local repo, central repo, remote repo

### what is the difference between package and install in maven lifecycle?
```text
package: create JAR/WAR package as mentioned in packaging in pom.xml file (without installing in local)
install: install the package in a local/remote maven repo
```
### what is plugins in maven, list some plugins
Maven plugins are the central part of the Maven system, allowing you to customize and extend the build process. Plugins perform tasks during the build lifecycle, such as compiling code, running tests, packaging artifacts, and deploying them. 

maven compile, maven install, maven depoly, maven clean, maven jar/war etc

### in Repo/MavenProject directory, create a Maven model using IntelliJ, named it as:
```text
groupID: com.chuwa.learn
artifactID: java-core
```
## Do code reviews

