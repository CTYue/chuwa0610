## Markdown Usage
Refer to `ShortQuestions/README.md` for Markdown examples.

## Git Commands Learned
- `git init`: Initialize a new Git repository.
- `git clone <repo-url>`: Clone a repository from GitHub.
- `git branch <branch-name>`: Create a new branch.
- `git checkout <branch-name>`: Switch to a branch.
- `git merge <branch-name>`: Merge a branch into the current branch.
- `git stash`: Stash changes.
- `git stash pop`: Apply stashed changes.

## Steps to Initialize a Git Repository
1. Navigate to the project directory.
2. Run `git init` to create a new Git repository.

## How to Clone a Repository from GitHub
1. Copy the repository URL from GitHub.
2. Run `git clone <repo-url>`.

## How to Create and Checkout a New Branch
1. Run `git branch <branch-name>` to create a branch.
2. Run `git checkout <branch-name>` to switch to the new branch.

## How to Merge `branch_test` to `master`
1. Run `git checkout master` to switch to the master branch.
2. Run `git merge branch_test` to merge `branch_test` into `master`.

## How to Stash and Pop Code
1. Run `git stash` to stash changes.
2. Run `git checkout branch_learn_stash` to switch to the branch.
3. Run `git stash pop` to apply stashed changes.

## Understanding PRs
Pull Requests (PRs) are based on branches. Changes made in a branch can be reviewed and discussed before merging into another branch.

## Maven Role
Maven is a build automation tool used for Java projects. It manages dependencies, compiles code, runs tests, and packages the application.

## Maven Lifecycle
1. Validate: Validate the project.
2. Compile: Compile the source code.
3. Test: Run tests.
4. Package: Package compiled code into a distributable format.
5. Verify: Run checks on the results.
6. Install: Install the package into the local repository.
7. Deploy: Deploy the package to a remote repository.

## Difference Between Package and Install in Maven Lifecycle
- `package`: Compiles and packages the code.
- `install`: Compiles, packages, and installs the package into the local repository.

## Maven Plugins
- `maven-compiler-plugin`: Compiles Java code.
- `maven-surefire-plugin`: Runs tests.
- `maven-jar-plugin`: Creates JAR files.

## Creating a Maven Module
1. Open IntelliJ.
2. Navigate to the `Repo/MavenProject` directory.
3. Create a new Maven module with:
   - **Group ID**: `com.chuwa.learn`
   - **Artifact ID**: `java-core`

## Code Review
Go over the PRs in your repository, and leave useful comments on other students' PRs. Do not merge the PRs.