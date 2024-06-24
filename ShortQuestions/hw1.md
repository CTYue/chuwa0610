# HW1

### 1. List the git commands you learned
* **`git add`**
* **`git checkout`**
* **`git merge`**
* **`git stash`**
* **`git diff`**
* **`git fetch`**
* **`git remote`**
* **`git rm`**

### 2. What is the basic steps to init a git repo in you local?
* **Navigate to Your Project Directory:** Use the `cd` command to change to the directory where you want to initialize the Git repository. If you don't have a directory yet, you can create one using the `mkdir` command followed by `cd` to enter the new directory.

  * Example:
      ```
      mkdir my_project
      cd my_project
      ```

* **Initialize the Repository:** Type the command `git init`. This creates a new subdirectory named `.git` that contains all necessary repository files — a Git repository skeleton. Your project is now a local Git repository.
    ```
    git init
    ```

### 3. How to clone a repo from Github?
* **Copy the Repository URL**
    - Navigate to the GitHub page of the repository you want to clone.
    - Click on the **Code** button and copy the URL provided under **HTTPS**.

* **Navigate to the Directory**
    - Choose or create a directory where you want to store the cloned repository.
    - Use the `cd` command to navigate into your desired directory. For example:
      ```
      cd path/to/your/directory
      ```

* **Clone the Repository**
    - Use the `git clone` command followed by the URL you copied earlier. For example:
      ```
      git clone https://github.com/username/repository.git
      ```
    - This command will create a local copy of the repository in your specified directory.

* **Verify the Cloning Process**
    - After the cloning process completes, use the `cd` command to move into the repository directory:
      ```
      cd repository
      ```
    - You can list the files using `ls` to verify that the cloning was successful.

### 4. How to create a new branch and checkout to that branch?
* **Navigate to Your Repository:** Use the `cd` command to navigate to the directory where your Git repository is located.

* **Create and Checkout New Branch:** Use the `git checkout -b` command followed by the name of the new branch you want to create. This command does two things: it creates the new branch and then checks it out so you're working in it.

    Example:
    ```
    git checkout -b feature-branch
    ```

### 5. How to merge the branch_test to master branch in command? show me the commands.
* **Navigate to Your Repository**
    - Change to the directory where your Git repository is located using the `cd` command.

* **Switch to the Master Branch**
    - Before merging, make sure you're on the `master` branch. Switch to the `master` branch using:
      ```
      git checkout master
      ```

* **Pull the Latest Updates**
    - It's a good practice to pull the latest changes from the remote repository to your local `master` branch to ensure it's up-to-date:
      ```
      git pull
      ```

* **Merge the Branch**
    - Merge `branch_test` into `master` by using the `git merge` command:
      ```
      git merge branch_test
      ```
    - This command brings all changes made in `branch_test` into the `master` branch.

* **Resolve Any Conflicts**
    - If there are conflicts, Git will prompt you to resolve them. Edit the files to resolve conflicts, then use `git add` to mark them as resolved.
    - After resolving conflicts, you can complete the merge by committing the changes.

* **Push Changes to Remote Repository**
    - After the merge is complete and all conflicts are resolved, push your changes to the remote repository:
      ```
      git push
      ```

### 6. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
#### Using Git Stash in Command Line
##### Stashing Changes
* **Navigate to Your Repository**
    - Use the `cd` command to navigate to your Git repository directory.

* **Stash Your Changes**
    - Before switching branches, save your changes using `git stash` or `git stash push`:
      ```
      git stash push -m "Description of stash"
      ```
    - This command saves your modifications in a stack of unfinished changes that you can reapply later.

##### Switching Branches

* **Checkout to Another Branch**
    - Switch from `branch_learn_stash` to another branch:
      ```
      git checkout another-branch
      ```

* **Return to Original Branch**
    - When ready to continue working on `branch_learn_stash`, switch back:
      ```
      git checkout branch_learn_stash
      ```
##### Applying Your Stashed Changes
* **Pop Your Stash**
    - Reapply the changes you stashed earlier:
      ```
      git stash pop
      ```
    - This command applies the stashed changes and removes them from the stash.

#### Using Git Stash in IntelliJ IDEA
##### Stashing Changes
* **Access Git Tools**
    - Go to `VCS` -> `Git` -> `Stash Changes`.

* **Enter Stash Message**
    - Enter a description for the stash and click `Save`.

##### Switching Branches
* **Switch Branches**
    - Navigate to the bottom-right corner of the IntelliJ window, click on the Git branch name, and select the branch you want to switch to.

* **Return to Original Branch**
    - Follow the same steps to switch back to `branch_learn_stash`.

##### Applying Your Stashed Changes
* **Apply Stashed Changes**
    - To apply stashed changes, go to `VCS` -> `Git` -> `Unstash Changes`.
    - Select the stash to apply and click `Pop`.

### 8. How do you understand PR is based on Branch?
- When you create a PR, you select the branch that contains your proposed changes (source branch) and the branch to which you want these changes to be merged (target branch).
- The PR will then show all the commits and the diff (changes) between the latest commit on the source branch and the target branch. This helps reviewers see what changes would be merged if the PR is accepted.

### 9. What is maven role? what it be used to do?
Maven is a build automation tool used primarily for Java projects. It is designed to simplify the build process like compiling code, packaging binaries, running tests, and dependency management.

#### Common Uses of Maven
- **Automating the build process** for various development stages like compile, test, and deploy.
- **Managing dependencies**, including automatic updating and compatibility checks.
- **Integrating with continuous integration/continuous deployment (CI/CD) systems** for automated builds and testing.
- **Generating project documentation**, site reports, and statistics.

### 9. What is the lifecycle of maven? could you tell me the details ?
Maven uses a defined lifecycle to describe the order in which a software project is built, tested, and deployed. This lifecycle allows Maven to manage a project's build process from start to finish using various phases.
* **Validate**: Checks if all necessary information is available and correct.

* **Compile**: Compiles the source code of the project.

* **Test**: Tests the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.

* **Package**: Packages the compiled code into its distributable format, such as a JAR or WAR.

* **Verify**: Runs any checks to validate the package is valid and meets quality criteria.

* **Install**: Installs the package into the local repository, which can be used as a dependency in other projects locally.

### 10. What is the difference between package and install in maven lifecycle?
#### Key Differences
- **Result Location**:
  - `package`: The artifact remains in the project's `target` directory.
  - `install`: The artifact is copied from the `target` directory into the local Maven repository (typically `.m2/repository`).

- **Purpose**:
  - `package`: To create the artifact.
  - `install`: To make the artifact available for local usage as a dependency.

- **Use Case**:
  - `package`: When you need to create project builds for deployment or distribution.
  - `install`: When you need to share the project as a dependency with other local projects.

### 11. What is plugins in maven, list some plugins.
Maven plugins are components that enhance Maven's capability to manage and build software projects. Plugins are executed during the build process and are configured in the `pom.xml` file of a Maven project. Each plugin is designed to perform specific tasks and can be tied to one or more phases of the Maven lifecycle.
* **Maven Compiler Plugin**
* **Maven Surefire Plugin**
* **Maven War Plugin**
* **Maven Clean Plugin**
* **Maven Install Plugin**
* **Maven Deploy Plugin**
* **Maven Site Plugin**