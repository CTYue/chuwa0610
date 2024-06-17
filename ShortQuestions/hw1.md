## 1. Learn Mark Down and show all of basic usage in the ShortQuestions/README.md

## 2. List the git commands from the link
- `git commit`
- `git checkout -b <branch_name>`
- `git merge`
- `git rebase branch`
- `git revert HEAD`
- `git reset HEAD~1`
- `git reset`/`git revert`
- `git cherry-pick commit1 commit2`
- `git rebase -i HEAD~<num>`

## 3. What is the basic steps to init a git repo in you local?
`git init`

## 4. How to clone a repo from Github?
`git clone repo_link`

## 5. How to create a new branch and checkout to that branch?
`git checkout -b <branch_name>`

## 6. How to merge the branch_test to master branch in command?
`git checkout master`

`git merge branch_test`

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ?
`git stash`
`git checkout new_branch`
`git stach pop`

## 8. How do you understand PR is based on Branch?

There is a branch with some changes and commits. We create a PR to merge it to master/main branch. Reviewers should perform code review on the new code, and approve it. Then our code changes get merged.

## 9. What is maven role? what it be used to do?
Maven is used for:
1. Manage dependencies
2. Build projects
3. Generate documentations and reports.

## 10. What is the lifecycle of maven? could you tell me the details?
1. **mvn clean**: Delete previous build artifacts.
2. **prepare-resources**: Prepares resources required for the build.
3. **Validate**: Checks the project's structure and configuration.
4. **package**: Compiles the code and packages it into a distributable format.
5. **install**: Installs the packaged artifacts into the local repository.

## 11. what is the difference between package and install in maven lifecycle?
In the Maven lifecycle, the package phase is responsible for assembling the compiled code and resources into a JAR or WAR file. This phase ensures that all the necessary files are included and correctly structured for deployment or distribution. The install phase takes this packaged artifact and installs it into the local Maven repository. 

## 12. What is plugins in maven, list some plugins.
In Maven, plugins are collections of goals that perform specific tasks during the build process. They extend the functionality of Maven and can be bound to different phases of the lifecycle, allowing for a customizable and automated build process. 

### Some Maven plugins:
- maven-jar-plugin
- maven-deploy-plugin
