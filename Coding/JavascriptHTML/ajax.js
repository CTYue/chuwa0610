async function fetchRepos() {
  const userID = document.getElementById("githubUserID").value;
  const url = `https://api.github.com/users/${userID}/repos`;

  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error("Failed to fetch repos");
    }
    const repos = await response.json();
    document.getElementById("result").innerHTML = `<pre>${JSON.stringify(
      repos,
      null,
      2
    )}</pre>`;
  } catch (error) {
    document.getElementById("result").textContent = `Error: ${error.message}`;
  }
}
function fetchReposUsingPromise() {
  const userID = document.getElementById("githubUserID").value;
  const url = `https://api.github.com/users/${userID}/repos`;

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to fetch repos");
      }
      return response.json();
    })
    .then((repos) => {
      document.getElementById("result").innerHTML = `<pre>${JSON.stringify(
        repos,
        null,
        2
      )}</pre>`;
    })
    .catch((error) => {
      document.getElementById("result").textContent = `Error: ${error.message}`;
    });
}
