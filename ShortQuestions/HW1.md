# HW1
## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
check ShortQuestions/ReadMe.md
## 2. practice git using the platform. list the git commands you learned
```
git commit
git branch
git checkout
git merge
git rebase
git reset
git revert
git cherry-pick 
git rebase
git tag
git describe
git clone
git fetch
git pull
git push
```
## 3. What is the basic steps to init a git repo in you local ?
use
```
git init
```
Then push it to the repository with
```
git add .
git commit -m “init project”
git push
```
## 4. How to clone a repo from Github ?
```
git clone [project link]
```

## 5. How to create a new branch and checkout to that branch ?

```
git branch your_branch
git checkout your_branch
```
or
```
git checkout -b your_branch
```

## 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
### git
```
git stash
git checkout your_branch
<...do things...>
git checkout branch_learn_stash
git stash pop
```
### intellij
```
click on ___commit___ on the left toolbar\
right click on ___Changes___ and click ___shelve changes___\
switch branch on the top toolbar and do things\
switch back to branch_lean_stash\
On shelf tab click on the change that was shelved
```

## 8. How do you understand PR is based on Branch?
Pull request is created when branches are merged back to the main branch. While branching gives developer the freedom to work independently, PR lets others to view changes and make sure no conflict during the merge.
## 9. What is maven role ? what it be used to do ?
Mavens is a powerful automatic build tool for Java. We can use it to build projects, manage dependencies, run tests, etc.
## 10. What is the lifecycle of maven? could you tell me the details ?
Clean - cleans the project, so it is ready to build\
preparing-resources - copy resources that will be used for building\
validate - checks if the project is correct & necessary information are available\
compile - compiles the source code\
test - compiles any test framework\
package - converts codes into distributable format, like JAR/WAR packages\
install - installs any packages from repositories\
deploy - copies final package to remote repositories

## 11. what is the difference between package and install in maven lifecycle ?
While "package" only converts code to packages, "install" puts the packages into the repository
## 12. What is plugins in maven, list some plugins.
Plugins are used as tools to perform a specific task(building/reporting) during the build. They can compile code, run tests, package and publish finished product and more.
### clean
clean up after the build
### compiler
compiles Java sources

## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
On top toolbar, select File->New->Module\
Then in groupID fill com.chuwa.learn\
In ArtifactID fill java-core\
click Create\
It automatically generates this 
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.chuwa.learn</groupId>
    <artifactId>java-core</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>22</maven.compiler.source>
        <maven.compiler.target>22</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
```
## 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in otherstudents' PR, please don't merge it.
Done at [Olivia](https://github.com/Liam-Zhou/chuwa0610/pull/4).
