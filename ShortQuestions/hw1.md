#Homework1

## Yirun Wang

### 2. practice git using the platform.list the git commands you learned
```
git commit
git branch [branch]
git checkout branchName
git merge [branch]
git rebase [branch]
git head
git clone <res-url>
git fetch <remote>
git pull <remote>
git push <remote><branch>
git stash
git reset
git revert
git cheery-pick
```

### 3. What is the basic steps to init a git repo in you local?
```
git init
git commit -m "repo commit"
```

### 4. How to clone a repo from github
```
Find the repo url on github.
cd project
git clone <repo-url>
```

### 5. How to create a new branch and checkout to that branch?
```
git branch new_branch
git checkout new_branch
```

### 6. How to merge the branch_test to master branch in commmand?
```
git checkout master
git merge branch_test
```


### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash?
```
git stash
git checkout otherbranch

git checkout branch_learn_stash
git stash pop
```

### 8. How do you understand PR is based on Branch?
Developers will create different branches for different features or improvements. When those branches are ready for review and integration into the main project, a PR is used to merge the changes to the source branch. Other team memeber will review the code. Reviewers approve the PR. And the changes can be finally merged to the target branch.

### 9. What is maven role? 
Maven is an open-source tool for build automation and project management. 
- Manage Dependencies: Maven will manage the libraries and frameworks.
- Build Project: Maven defines a standard lifecycle with complie, test, package, install, deploy.
- Documentaion with plugins.
- Reporting: the coverage of test results.

### 10. What is the lifecycle of Maven?
Clean:
Clean up the project directory by deleting the target directory.

Default:
- Validate: Validates the project to make sure it has all the necessary dependencies for building.
- Complie: Compile the source code into bytecode.
- Test: Run tests.
- Package: Complie code into distributed package format, like JAR.
- Verify: Run checks on the package to ensure its validity.
- Install: Install the package into the local repository, making sure its available for other projects locally.
- Copy the final package to remote repository.

Site:
Generate project documentation and reports.

### 11. What's the difference between package and install in maven lifecycle.
Package will package the complied source code into distrbutable format, like JAR.
Install means take the packaged artifacts generated in the package phase, and install in in the local maven repository.

### 12. plugins in Maven?
Plugins are components that extend its functionality to perform specific tasks. Plugins allow for the reuse of common build logic across different projects.

maven-compiler-plugin
maven-jar-plugin
maven-war-plugin
maven-site-plugin
maven-clean-plugin
maven-checkstyle-plugin

