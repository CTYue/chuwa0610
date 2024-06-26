# HW1

2. Some basic Git commands are:
```bash
    git init
    git clone
    git commit
    git status
    git add
    git reset
    git branch
    git checkout
    git merge
    git fetch
    git push
    git pull
    git rebase
```
3. basic steps to init a git repo in local:
```bash
    cd dir //Navigate to your project directory
    git init //Initialize the Git repository
    git add . //Add all files to the repository
    git commit -m "commit" //Commit the files
    git remote add origin [url] //Connect to a remote repository
    git push -u origin master //Push your commits to the remote repository
```
4. How to clone a repo from Github?
```bash
git clone [url]
```
5. How to create a new branch and check out to that branch?
```bash
git branch [name]
git checkout [name]
```
6. How to merge the branch_test to master branch in command?
```bash
cd [path]
git fetch origin //Ensure You Have the Latest Changes
git checkout master //Switch to the Master Branch
git merge branch_test //Merge the branch_test Branch
git commit //Complete the Merge
git push origin master //Push the Changes to the Remote Repository
```

7. To stashing and popping code:
```bash
git stash push -m "" //Stash Changes
git checkout branch_learn_stash //Checkout Back to **branch_learn_stash
git stash pop
```

8. A PR(pull request) being based on a branch means that the changes proposed in the PR originate from a specific branch. This branch contains the new code or fixes that are intended to be merged into the main branch after review and approval. This workflow allows for isolated development, thorough review, and controlled integration of new features or fixes into the main codebase.
9. Maven is a powerful build automation and project management tool primarily used in Java projects. It provides a comprehensive framework for managing a project's build lifecycle, dependencies, documentation, reporting and overall structure. 
10. Maven is based around the central concept of a build lifecycle. What this means is that the process for building and distributing a particular project is clearly defined.
It is only necessary to learn a small set of commands to build any Maven project, and the POM will ensure to get the results.
There are three built-in build lifecycles: default, clean and site. The default lifecycle handles your project deployment, the clean lifecycle handles project cleaning, while the site lifecycle handles the creation of your project's web site.
11. The package phase is responsible for creating the distributable package (JAR, WAR, etc.) and places it in the target directory of the project. The install phase goes a step further than package. It not only packages the code but also installs the package into the local Maven repository. This makes the package available for other projects on the same machine to use as a dependency.
12. Maven plugins are a central part of the Maven build system. They are used to perform specific tasks in the build lifecycle, such as compiling code, running tests, packaging the application, and more. Each plugin provides one or more goals, which are executed during the build process. Plugins extend the functionality of Maven and can be used to customize the build process: maven-compiler-plugin,maven-surefire-plugin,maven-jar-plugin
