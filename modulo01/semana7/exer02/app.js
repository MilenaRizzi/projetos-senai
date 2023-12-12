const userNameInput = document.querySelector("#inputName");
const botaoBuscaPerfil = document.querySelector("#btnBuscaPerfil");
const perfil = document.querySelector("#span-perfil");
const repositorios = document.querySelector("#span-repositorio");
const avatar = document.querySelector("#span-avatar");


async function buscaPefilGitHub(userName) {
    try {
        const url = `https://api.github.com/users/${userName}`;
        const resposta = await fetch(url);
        const dados = await resposta.json();

        perfil.innerHTML = `<strong>${dados.login}</strong>`;
        repositorios.innerHTML = `<strong>${dados.public_repos}</strong>`;
        avatar.innerHTML = `<img src="${dados.avatar_url}" alt="Avatar">`; // Utilizando uma tag img para exibir a imagem
    } catch (error) {
        console.log(error);
    }
}

botaoBuscaPerfil.addEventListener("click", () => {
    const userName = userNameInput.value;
  
    if (userName) {
        buscaPefilGitHub(userName);
    }
  });