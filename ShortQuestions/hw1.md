### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

SEE README.md

### 2. practice git using the platform. list the git commands you learned

```
git status
git log
git commit
git add
git pull
git push
git merge
git rebase
git fetch
```

### 3. What is the basic steps to init a git repo in you local?

```bash
git init
```

### 4. How to clone a repo from Github?

```bash
git clone repo_url
```

### 5. How to create a new branch and checkout to that branch?

```bash
git cehckout -b branch_name
```

### 6. How to merge the branch_test to master branch in command? show me the commands.

```bash
git checkout master
git pull origin master
git merge branch_test
git push origin master
```

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to \*\*branch_learn_stash ? try commands way and intellij way.

```bash
git checkout branch_learn_stash
git stash
git checkout different_branch
git checkout branch_learn_stash
git stash pop
```

### 8. How do you understand PR is based on Branch?

- A Pull Request (PR) allows you to merge changes from one branch to the main codebase, while also enabling a review process by other developers.

### 9. What is maven role? what it be used to do?

- Maven helps automate the build process and manage project dependencies for Java projects. It is similar to `apt` in Linux and `npm` in Node.js.

### 10. What is the lifecycle of maven? could you tell me the details ?

- **validate**: Validates the project is correct.
- **compile**: Compiles the source code of the project.
- **test**: Runs tests to test the program.
- **package**: Like JAR or WAR.
- **verify**: Runs any checks to verify the package is valid and meets quality criteria.
- **install**: Installs the package into the local repository, for use as a dependency in other projects locally.
- **deploy**: Copies the final package to the remote repository for sharing with other developers and projects.

### 11. What is the difference between package and install in maven lifecycle?

- **package**: this phase take compiled code and convert to JAR, WAR files.
- **install**: This phase directly install package to local maven repository.

### 12. What is plugins in maven, list some plugins.

- In Maven, plugins are a key feature that extend the capabilities of the build system. Plugins are used to perform specific tasks such as compiling code, running tests, packaging binaries, generating documentation, and deploying artifacts.
- some plugins example : Maven Install Plugin, Maven Deploy Plugin, Maven Clean Plugin,Maven Site Plugin.
