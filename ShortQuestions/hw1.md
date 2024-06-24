# HW1

## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

- Headings
- Styling Text
- Quoting Text
- Quoting Code
- Supported Color Models
- Links
- Images
- Lists
- Emojis
- Paragraphs 

## 2. Practice git using the platform. list the git commands you learned

Some Basic Git Commands are:

- git status
- git add
- git commit
- git push
- git checkout
- git merge

## 3. What is the basic steps to init a git repo in you local ?

```
cd /path/to/your/project
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/username/repository.git
git push -u origin master
```

## 4. How to clone a repo from Github ?

- git clone [link]

## 5. How to create a new branch and checkout to that branch ?

```
git branch new_branch_name
git checkout -b new_branch_name
``` 

## 6. How to merge the branch_test to master branch in command ? show me the commands

```
git checkout master
git merge branch_test
``` 

## 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

```
git stash
giit checkout branch_learn_stash
git stash pop
```

## 8. How do you understand PR is based on Branch?

- Developers need to developing each functionality seperatly so that it's not a good choice to make revision or development directly on the main branch because it will be messy.
- Any changes on the sub-branch can be developed and tested so that it makes sure the main branch is safe 
- By using PR, i.e. Pull Request, others can review and leave comment on the changes of code before merging to the main branch.

## 9. What is maven role ? what it be used to do ?

Maven's role is to manage the build lifecycle, dependencies, and project structure, providing a standardized and automated way to manage Java projects. 

## 10. What is the lifecycle of maven? could you tell me the details ?

>Lifecycle of maven:
>1. Validate: Making sure project is correct
>2. Complie: Compling the source code at this time
>3. Test: Running Unit tests
>4. Package: Encapsulating into package such as JAR Package
>5. Verify: Running the checks to make sure the quality is satisified
>6. Install: Installing packages to the local repository
>7. Deploy: Copying the packages to the remote repository

## 11. what is the difference between package and install in maven lifecycle ?

- The package phase creates a distributable artifact (e.g., JAR, WAR), while the install phase copies the artifact to the local Maven repository for use as a dependency in other projects.

## 12. What is plugins in maven, list some plugins.

- Plugins are extensions that provide tasks that can enhance the functionality. Ex: maven-antrun-plugin

## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
### 1. groupID: com.chuwa.learn
### 2. artifactID: java-core
>1. Creating the new module in Repo/MavenProject directory 
>2. Setting the new module with groupID: com.chuwa.learn and artifactID: java-core