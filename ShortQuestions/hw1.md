## HW1

1. list the git commands you learned

   >+ git merge
   >+ git rebase
   >+ ^
   >+ ~
   >+ git reset
   >+ git revert
   >+ git cherry-pick
   >+ git tag
   >+ git describe
   >+ git checkout HEAD~^2~2
   >+ git pull --rebase
   >+ git branch -u o/main foo
   >+ git checkout -b foo o/main
   >+ git push :bar
   >+ git fetch :foo

2. What is the basic steps to init a git repo in you local?

   >+ Init the git repo
   >
   >  ```git
   >  git init -b main
   >  ```
   >
   >+ Add all the files to the repo
   >
   >+ Commit the files

3. How to clone a repo from Github?

   >+ Find the URL
   >+ Git clone + URL

4. How to create a new branch and checkout to that branch?

   >1. Create a new branch
   >   + git checkout
   >   + git branch
   >2. Checkout to branch
   >   + git checkout -b
   >3. In one command
   >   + git switch

5. How to merge the branch_test to master branch in command?

   >```
   >git merge branch_test
   >```

7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.

   >```
   >git stash
   >git checkout other_branch
   >git checkout branch_learn_stash
   >git pop
   >```

8. How do you understand PR is based on Branch?

   >1. Changes are isolated before merging to the main branch.
   >2. The development can be divided into different branches as features, which improves the efficiency of the programming and make it easier to debug the issues.
   >3. In a PR, related developers can review the codes, leave comments and merge the branch to the main branch.

9. What is maven role ? what it be used to do ?

   >Maven is used to simply the download, add and remove of the dependencies. 
   >
   >Role:
   >
   >1. Manage dependencies
   >2. Build project
   >3. Documentation
   >4. Reporting
   >5. Others

10. What is the lifecycle of maven? could you tell me the details?

    >Lifecycle:  
    >
    >1. Validate: validate if the project is correct and all neccessary information is available
    >2. Compile: source code complilation is done in this phrase
    >3. Test: test the compiled source code suitable for testing framework
    >4. Package: Take the compiled code and package it in its distributable format.
    >5. Verify: run any checks on results of integration tests to ensure quality criteria are met.
    >6. Install: install the package in local/remote maven repository.
    >7. Deploy: Copies the final package to the remote repository

11. what is the difference between package and install in maven lifecycle?

    >`Package` is to package the compiled code in a distributable format into some target folder, while `install` will put this format into local repository so that other projects can use it

12. What is plugins in maven, list some plugins.

    >`Plugins` are used to execute the actual build tasks of maven, which allows for the reuse of common build logic across multiple projects. For example, maven-clean-plugin, maven-antrun-plugin

13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows: 

    groupID: com.chuwa.learn

    artifactID: java-core

    >1. Navigate to Repo/MavenProject
    >2. New Module with groupID: com.chuwa.learn, artifactID: java-core

14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.