<script>
import {defineComponent} from 'vue';
import CryptoJS from "crypto-js";
import axios from 'axios';
import {mapActions, mapMutations} from 'vuex'
import router from "@/router";

const url = 'http://localhost:8081/login';

export default defineComponent({
  data() {
    return {
      formData: {
        usuario: "",
        senha: ""
      }
    }
  },
  methods: {
    async submitSignIn() {
      let senha = this.formData.senha
      senha = this.encrypt(senha)
      try {
        this.formData.senha = senha
        const request = await axios.post(url, this.formData)
        this.getUserInfos(request.data);
        this.setTipoDeLogin(1);
        await router.push('/logado');
      } catch (ex) {
        alert("Não foi possível fazer o login, verifique seus dados!");
        console.log(ex.message);
      }
    },
    encrypt(senha) {
      return CryptoJS.SHA512(senha).toString()
    },
    ...mapActions([
      'getUserInfos'
    ]),
    ...mapMutations([
      'setTipoDeLogin'
    ]),
  },
});
</script>

<template>
  <main>
    <div>
      <h1>Iniciar Sessão</h1>
      <form role="form" @submit.prevent="submitSignIn()">
        <fieldset>
          <div>
            <label for="userLogin">Usuário:</label>
            <input id="userLogin" type="text" aria-label="Usuário" placeholder="Usuário" v-model="formData.usuario"
                   required>
          </div>

          <div>
            <label for="userPassword">Senha:</label>
            <input id="userPassword" type="password" aria-label="Senha" placeholder="Senha" v-model="formData.senha"
                   required>
          </div>
          <button type="submit">Entrar</button>
        </fieldset>
      </form>
    </div>
  </main>
</template>

<style scoped>

main {
  background-color: rgba(45, 46, 50);
  height: 100%;
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

label, p, a {
  color: rgb(6, 45, 78);
  padding: 20px;
}

h1 {
  color: aliceblue;
  font-size: 3 dvw;
}

label, input {
  padding: 10px;
  margin: 2 dvh;
  align-items: center;
  justify-content: left;
  text-align: left;
}

fieldset {
  background-color: aliceblue;
  border-radius: 10px;
  border-color: rgb(35, 75, 110);
  align-items: center;
  height: 250px;
}

</style>