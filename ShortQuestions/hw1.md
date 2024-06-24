## 1. Learn Mark Down and show all of basic usage in the ShortQuestions/README.md

## 2. List the git commands from the link
- `git commit`
- `git checkout -b <branch_name>`
- `git merge`
- `git rebase`
- `git checkout HEAD^`/`git checkout HEAD~<num>`
- `git reset`/`git revert`
- `git cherry-pick`
- `git rebase -i HEAD~<num>`

## 3. What is the basic steps to init a git repo in you local?
`git init`

## 4. How to clone a repo from Github?
`git clone <url>`

## 5. How to create a new branch and checkout to that branch?
`git checkout -b <branch_name>`

## 6. How to merge the branch_test to master branch in command?
`git checkout master`

`git merge branch_test`

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ?
`git stash`

`git stach pop`

## 8. How do you understand PR is based on Branch?
PR should be rasied before a feature/sub branch merging into the main branch. Co-workers or supervisors should perform code review on the new code, ask for changes, and approve.

## 9. What is maven role? what it be used to do?
Maven can be used to manage dependencies, build projects, generate documentations and reports.

## 10. What is the lifecycle of maven? could you tell me the details?
1. **mvn clean**: Removes the files generated at build-time in the target directory.
2. **prepare-resources**: Copies resources to the output directory.
3. **Validate**: Validates if the project is correct and if all necessary information is available
4. **package**: Takes the compiled code and resources, creates the JAR/WAR package as mentioned in the packaging in POM.xml file.
5. **install**: Installs the package in local/remote maven repo.

## 11. what is the difference between package and install in maven lifecycle?
The package phase creates JAR/WAR package in the build directory. However, install phase installs the package in local/remote maven repo. They are used in different scope and purpose.

## 12. What is plugins in maven, list some plugins.
Plugins are tools that provide specific goals during the build process. Each plugin can execute different goals that can be used in different phases of the maven lifecycle. The common tasks that can be performed by plugins are compiling code, packaging binary file, and generating documentation.

### Some Maven plugins:
- Maven Compiler Plugin
- Maven Surefire Plugin
- Maven War Plugin
